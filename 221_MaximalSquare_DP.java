/*
 * 221. Maximal Square
 * Given an m x n binary matrix filled with 0's and 1's, 
 * find the largest square containing only 1's and return its area.
 *
 * Example 1:
 *
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 *
 * Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
 * Output: 4
 *
 * Example 2:
 *
 * 0 1
 * 1 0
 * 
 * Input: matrix = [["0","1"],["1","0"]]
 * Output: 1
 *
 * Solution: dynamic programming
 */
class Solution {
    public int maximalSquare(char[][] matrix) {
        /*
         * Method: Dynamic Programming
         * dp[i][j] represents the squre with largest length width with right bottom corner (i, j)
         * if matrix[i][j] == 1: // if is 0, it will be 0
         *   // determined by the small one
         *   dp[i][j] = min(dp[i-1][j], dp[i][j-1], dp[i-1][j-1] + 1) + 1
         *   maxlen = max(maxlen, dp[i][j])
         */
        //----------------------------------Original---------------------------------------
        int rows = matrix.length;
        int cols = matrix.length > 0 ? matrix[0].length : 0;
        int[][] dp = new int[rows+1][cols+1]; // outer most line are reserved for computing
        int maxLen = 0;
        for (int i = 1; i < rows + 1; i++) {
            for (int j = 1; j < cols + 1; j++) {
                if (matrix[i-1][j-1] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
                    maxLen = Math.max(maxLen, dp[i][j]);
                }
            }
        }
        return maxLen * maxLen;
        /*
         * Since every time we only use previous value and values of previous row
         * We can only use 1d array to maintain the dynamic programming values
         */
        //----------------------------------Modified---------------------------------------
        int rows = matrix.length;
        int cols = matrix.length > 0 ? matrix[0].length : 0;
        int[] dp = new int[cols+1]; int prev = 0; // prev represent dp[i-1][j-1]
        int maxLen = 0;
        for (int i = 1; i < rows + 1; i++) {
            for (int j = 1; j < cols + 1; j++) {
                int temp = dp[j];
                if (matrix[i-1][j-1] == '1') {
                    dp[j] = Math.min(Math.min(dp[j], dp[j-1]), prev) + 1;
                    maxLen = Math.max(maxLen, dp[j]);
                } else {
                    dp[j] = 0;
                }
                prev = temp;
            }
        }
        return maxLen * maxLen;
    }
}

