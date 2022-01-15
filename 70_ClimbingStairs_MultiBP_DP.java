/**
 * 70. Climbing Stairs
 * 
 * You are climbing a staircase. It takes n steps to reach the top.
 *
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * 
 * Example 1:
 *
 * Input: n = 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 * 
 * Example 2:
 *
 * Input: n = 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 * 
 * Solution: regular dynamic programming, or think it as a backpack problem.
 * 1 or 2 steps are items weights, target is the total steps, order matters, so notice the loops.
 * 
 */
class Solution {
    public int climbStairs(int n) {
        // -----------------------regular-dp---------------------------------
        // if (n == 1) return 1;
        // int[] dp = new int[n + 1];
        // dp[1] = 1;
        // dp[2] = 2;
        // for (int i = 3; i <= n; i++) {
        //     // two ways to get i, from i - 2 climb 2 steps, from i - 1 climb 1 step
        //     dp[i] = dp[i - 2] + dp[i - 1]; 
        // }
        // return dp[n];
        
        // -------------------Multi-BackPack-Problem-------------------------
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            if (i >= 1) dp[i] = dp[i] + dp[i - 1];
            if (i >= 2) dp[i] = dp[i] + dp[i - 2];
        }
        return dp[n];
    }
}


