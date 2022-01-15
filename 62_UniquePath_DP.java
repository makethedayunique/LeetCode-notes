/**
 * 62. Unique Paths
 * 
 * There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]). 
 * The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). 
 * The robot can only move either down or right at any point in time.
 *
 * Given the two integers m and n, return the number of possible unique paths that the robot can take to reach
 * the bottom-right corner.
 * 
 * The test cases are generated so that the answer will be less than or equal to 2 * 109.
 * 
 * Example 1:
 * 
 * Input: m = 3, n = 7
 * Output: 28
 * 
 * Example 2:
 *
 * Input: m = 3, n = 2
 * Output: 3
 * 
 */
class Solution {
    public int uniquePaths(int m, int n) {
        // ------------------Math--------------------------
        int start = m + n - 2;
        int min = Math.min(m, n) - 1;
        int count = min;
        long result = 1;
        while (count > 0) {
            result *= start;
            while (min > 0 && result % min == 0) {
                result /= min;
                min--;
            }
            start--;
            count--;
        }
        return (int)result;
        // ----------------DP------------------------------
        // int[][] dp = new int[m][n];
        // Arrays.fill(dp[0], 1);
        // for (int i = 0; i < m; i++) dp[i][0] = 1;
        // for (int i = 1; i < m; i++) {
        //     for (int j = 1; j < n; j++) {
        //         dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
        //     }
        // }
        // return dp[m - 1][n - 1];
    }
}



