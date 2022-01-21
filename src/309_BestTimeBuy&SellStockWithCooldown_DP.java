/**
 * 309. Best Time to Buy and Sell Stock with Cooldown
 * 
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 *
 * Find the maximum profit you can achieve. You may complete as many transactions as you like 
 * (i.e., buy one and sell one share of the stock multiple times) with the following restrictions:
 *
 * After you sell your stock, you cannot buy stock on the next day (i.e., cooldown one day).
 * Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
 * 
 * Example 1:
 *
 * Input: prices = [1,2,3,0,2]
 * Output: 3
 * Explanation: transactions = [buy, sell, cooldown, buy, sell]
 *
 * Example 2:
 *
 * Input: prices = [1]
 * Output: 0
 *
 * Solution: Use Dynamic Programming and there will be four states everyday
 *   
 */
class Solution {
    public int maxProfit(int[] prices) {
        // four states
        // 0: hold stock
        // 1: sell day
        // 2: sold more than 2 day, passed cooldown day
        // 3: is a cooldown day
        int[][] dp = new int[prices.length][4];
        dp[0][0] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][3] - prices[i], Math.max(dp[i - 1][0], dp[i - 1][2] - prices[i]));
            dp[i][1] = dp[i - 1][0] + prices[i];
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][3]);
            dp[i][3] = dp[i - 1][1];
        }
        return Math.max(Math.max(dp[prices.length - 1][1], dp[prices.length - 1][2]),
                        dp[prices.length - 1][3]);
    }
}




