/**
 * 1937. Maximum Number of Points with Cost
 * 
 * You are given an m x n integer matrix points (0-indexed). 
 * Starting with 0 points, you want to maximize the number of points you can get from the matrix.
 *
 * To gain points, you must pick one cell in each row. Picking the cell at coordinates (r, c) will add points[r][c] to your score.
 *
 * However, you will lose points if you pick a cell too far from the cell that you picked in the previous row. 
 * For every two adjacent rows r and r + 1 (where 0 <= r < m - 1), 
 * picking cells at coordinates (r, c1) and (r + 1, c2) will subtract abs(c1 - c2) from your score.
 *
 * Return the maximum number of points you can achieve.
 * 
 * abs(x) is defined as:
 *
 * x for x >= 0.
 * -x for x < 0.
 * 
 * Example 1:
 * 
 * Input: points = [[1,2,3],[1,5,1],[3,1,1]]
 * Output: 9
 * Explanation:
 * The blue cells denote the optimal cells to pick, which have coordinates (0, 2), (1, 1), and (2, 0).
 * You add 3 + 5 + 3 = 11 to your score.
 * However, you must subtract abs(2 - 1) + abs(1 - 0) = 2 from your score.
 * Your final score is 11 - 2 = 9.
 * 
 * Example 2:
 * 
 * Input: points = [[1,5],[2,3],[4,2]]
 * Output: 11
 * Explanation:
 * The blue cells denote the optimal cells to pick, which have coordinates (0, 1), (1, 1), and (2, 0).
 * You add 5 + 3 + 4 = 12 to your score.
 * However, you must subtract abs(1 - 1) + abs(1 - 0) = 1 from your score.
 * Your final score is 12 - 1 = 11.
 * 
 * Solution: Use dynamic programming and left-right traverse and right-left traverse to add to next row
 * 
 **/
class Solution {
    public long maxPoints(int[][] points) {
        /**
        Use dynamic programming
        dp[i][j] represents maximum score gotten when taking cell (i,j)
        to compute dp[i][j], go through all the cells in the previous row
        Time Limit exceed: O(m*n^2)
        Instead, we can think of one way with time complexity O(m*n)
        For each row, traverse from left to right and then from right to left
        Compute the largest value which could be directly added to the next line 
        in the same column
        **/
        int m = points.length;
        int n = points[0].length;
        long result = Integer.MIN_VALUE;
        long[][] scores = new long[m][n];
        
        // Set the first row
        for (int j = 0; j < n; j++) {
            scores[0][j] = Long.valueOf(points[0][j]);
        }
        
        for (int i = 0; i < m-1; i++) {
            // Traverse from left to right
            for (int j = 1; j < n; j++) {
                // Take the maximum of the score and the previous score minus 1 (abs val)
                scores[i][j] = Math.max(scores[i][j], scores[i][j-1] - 1);
            }
            // Traverse from right to left
            for (int j = n-2; j >= 0; j--) {
                scores[i][j] = Math.max(scores[i][j], scores[i][j+1] - 1);
            }
            // Add the accumulated values to the next row
            for (int j = 0; j < n; j++) {
                scores[i+1][j] = points[i+1][j] + scores[i][j];
            }
        }
        
        /**
        // Method with time complexity O(m*n^2)
        // Set the first line
        for (int i = 0; i < n; i++) {
            scores[0][i] = Long.valueOf(points[0][i]);
        }
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                long tempMax = Integer.MIN_VALUE;
                for (int k = 0; k < n; k++) {
                    tempMax = Math.max(tempMax, scores[i-1][k] + points[i][j] - Math.abs(j-k));
                }
                scores[i][j] = tempMax;
            }
        }
        **/
        
        for (long score: scores[m-1]) {
            result = Math.max(result, score);
        }
        return result;
    }
}


 