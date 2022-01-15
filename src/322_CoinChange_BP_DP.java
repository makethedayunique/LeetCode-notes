/**
 * 322. Coin Change
 * 
 * You are given an integer array coins representing coins of different denominations and an integer amount 
 * representing a total amount of money.
 *
 * Return the fewest number of coins that you need to make up that amount. 
 * If that amount of money cannot be made up by any combination of the coins, return -1.
 * 
 * You may assume that you have an infinite number of each kind of coin.
 * 
 * Example 1:
 *
 * Input: coins = [1,2,5], amount = 11
 * Output: 3
 * Explanation: 11 = 5 + 5 + 1
 * 
 * Example 2:
 *
 * Input: coins = [2], amount = 3
 * Output: -1
 * 
 * Example 3:
 *
 * Input: coins = [1], amount = 0
 * Output: 0
 * 
 * Solution: BackPack problem, dp[i] represent the minimum coins needed to reach i amount
 * Order doesn't matter, dp[0] = 0, Initial others to max_value
 * 
 */
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        // for (int i = 1; i <= amount; i++) {
        //     for (int j = 0; j < coins.length; j++) {
        //         if (i >= coins[j] && dp[i - coins[j]] != Integer.MAX_VALUE) dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]]);
        //     }
        // }
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                if (dp[j - coins[i]] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
                }
            }
        }
        
        if (dp[amount] == Integer.MAX_VALUE) return -1;
        return dp[amount];
    }
}




