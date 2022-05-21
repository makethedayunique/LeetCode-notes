/**
 * 1277. Count Square Submatrices with All Ones
 * 
 * Given a m * n matrix of ones and zeros, return how many square submatrices have all ones.
 * 
 * Example 1:
 * 
 * Input: matrix =
 * [
 *   [0,1,1,1],
 *   [1,1,1,1],
 *   [0,1,1,1]
 * ]
 * 
 * Output: 15
 * 
 * Explanation: 
 * There are 10 squares of side 1.
 * There are 4 squares of side 2.
 * There is  1 square of side 3.
 * Total number of squares = 10 + 4 + 1 = 15.
 * 
 * Example 2:
 *
 * Input: matrix = 
 * [
 *   [1,0,1],
 *   [1,1,0],
 *   [1,1,0]
 * ]
 * 
 * Output: 7
 * Explanation: 
 * There are 6 squares of side 1.  
 * There is 1 square of side 2. 
 * Total number of squares = 6 + 1 = 7.
 *
 * Solution: Compute the largest length of squre which could ended with current cell. Add all the values up. 
 * 
 **/
class Solution {
    public int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] maxSquare = new int[m+1][n+1];
        int result = 0;
        for (int i = 1; i <= m ; i++) {
            for (int j = 1; j <= n; j++) {
                if (matrix[i-1][j-1] == 1) {
                    // value = 1 + min(left three corners value)
                    maxSquare[i][j] = Math.min(Math.min(maxSquare[i-1][j], maxSquare[i][j-1]), 
                                         maxSquare[i-1][j-1]) + 1;
                    result += maxSquare[i][j];
                }
            }
        }
        return result;
    }
}



