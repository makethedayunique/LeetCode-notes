/**
 * 518. Coin Change 2
 * 
 * You are given an integer array coins representing coins of different denominations and an integer amount 
 * representing a total amount of money.
 *
 * Return the number of combinations that make up that amount. 
 * If that amount of money cannot be made up by any combination of the coins, return 0.
 *
 * You may assume that you have an infinite number of each kind of coin.
 *
 * The answer is guaranteed to fit into a signed 32-bit integer.
 * 
 * Example 1:
 *
 * Input: amount = 5, coins = [1,2,5]
 * Output: 4
 * Explanation: there are four ways to make up the amount:
 * 5=5
 * 5=2+2+1
 * 5=2+1+1+1
 * 5=1+1+1+1+1
 * 
 * Example 2:
 *
 * Input: amount = 3, coins = [2]
 * Output: 0
 * Explanation: the amount of 3 cannot be made up just with coins of 2.
 * 
 * Solution: Ultimate BP. Going through all the nodes and amount below 5 from coin[i] to target, dp[i] = dp[i] + dp[i - coin[i]]
 * return dp[target]
 * 
 */
class Solution {
    public int change(int amount, int[] coins) {
        // Initialization
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                dp[j] = dp[j] + dp[j - coins[i]];
            }
        }
        return dp[amount];
    }
}



