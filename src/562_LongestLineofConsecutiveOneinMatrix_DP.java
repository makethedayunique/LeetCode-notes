/**
 * 562. Longest Line of Consecutive One in Matrix
 * 
 * Given an m x n binary matrix mat, return the length of the longest line of consecutive one in the matrix.
 *
 * The line could be horizontal, vertical, diagonal, or anti-diagonal.
 * 
 * Example 1:
 * 
 * Input: mat = [[0,1,1,0],[0,1,1,0],[0,0,0,1]]
 * Output: 3
 * 
 * Example 2:
 * 
 * Input: mat = [[1,1,1,1],[0,1,1,0],[0,0,0,1]]
 * Output: 4
 * 
 * Solution: dynamic programming
 * 
 **/
class Solution {
    public int longestLine(int[][] mat) {
        /** Brute force **/
        // int result = , but with O(n^2); // Longest length
        // int m = mat.length;
        // int n = mat[0].length;
        // for (int i = 0; i < m; i++) {
        //     for (int j = 0; j < 4; j++) {
        //         result = Math.max(result, getLength(mat, i, 0, m, n, j));
        //         result = Math.max(result, getLength(mat, i, n-1, m, n, j));
        //     }
        // }
        // for (int i = 0; i < n; i++) {
        //     for (int j = 0; j < 4; j++) {
        //         result = Math.max(result, getLength(mat, 0, i, m, n, j));
        //     }
        // }
        // return result;
        
        /** Dynamic Programming **/
        // We could try to decrease the space complexity by using 2d array
        int result = 0;
        int m = mat.length;
        int n = mat[0].length;
        // ===================3D dynamic programming=======================
        int dp[][][] = new int[m][n][4]; // four directional current length
        int dir[][] = {{0,-1},{-1,0}, {-1,-1}, {-1,1}};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n ; j++) {
                if (mat[i][j] == 0) {
                    continue; // Default values are all 0
                }
                // Otherwise, update the values
                for (int k = 0; k < 4; k++) {
                    int pX = i + dir[k][0];
                    int pY = j + dir[k][1];
                    if (ifValid(pX, pY, m, n)) {
                        dp[i][j][k] = dp[pX][pY][k] + 1;
                    } else {
                        dp[i][j][k] = 1;
                    }
                    result = Math.max(dp[i][j][k], result);
                }
            }
        }
        return result;
    }
    
    private boolean ifValid (int x, int y, int lenX, int lenY) {
        if (x < 0 || x >= lenX || y < 0 || y >= lenY) {
            return false;
        }
        return true;
    }
    
    private int getLength(int[][] mat, int startX, int startY, int lenX, int lenY, int iterationType) {
        /**
        type 0" horizontal
        1" vertical
        2" diagonal
        3" anti-diagonal
        **/
        int maxLen = 0;
        int curr = 0;
        while (startX < lenX && startY < lenY && startX >= 0 && startY >= 0) {
            if (mat[startX][startY] == 1) {
                curr++;
            } else {
                curr = 0;
            }
            maxLen = Math.max(maxLen, curr);
            switch(iterationType) {
                case 0:
                    startY += 1;
                    break;
                case 1:
                    startX += 1;
                    break;
                case 2:
                    startX += 1;
                    startY += 1;
                    break;
                case 3:
                    startX += 1;
                    startY -= 1;
                    break;
            }
        }
        return maxLen;
    }
}



 