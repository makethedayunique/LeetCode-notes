/**
 * 343. Integer Break
 * 
 * Given an integer n, break it into the sum of k positive integers, where k >= 2, 
 * and maximize the product of those integers.
 * 
 * Return the maximum product you can get.
 * 
 * Example 1:
 *
 * Input: n = 2
 * Output: 1
 * Explanation: 2 = 1 + 1, 1 × 1 = 1.
 * 
 * Example 2:
 *
 * Input: n = 10
 * Output: 36
 * Explanation: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36.
 * 
 * Solution: Dynamic Programming
 * 
 */
class Solution {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        // dp[i] means the maximum product when dividing i
        // dp[0] and dp[1] mean nothing, so initialize from dp[2]
        // for every i, go through from 1 to i - 1, dp[i] = max(dp[i], dp[i - j]*j, j*(i-j))
        // max(dp[i-j]*j, j*(i-j)) means either only two numbers, or j * multiple numbers
        
        dp[2] = 1; // start from 3
        for (int i = 3; i <= n; i++) {
            // We don't initialize the dp[1], so j only come to i - 1
            // for i - 1 * 1 = i - 1 * dp[1]
            for (int j = 1; j < i - 1; j++) { 
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }
        return dp[n];
        
    }
}



