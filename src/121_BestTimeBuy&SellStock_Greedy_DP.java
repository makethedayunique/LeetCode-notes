/**
 * 121. Best Time to Buy and Sell Stock
 * 
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 *
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in 
 * the future to sell that stock.
 *
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 * 
 * Example 1:
 *
 * Input: prices = [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 * Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
 * 
 * Example 2:
 *
 * Input: prices = [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transactions are done and the max profit = 0.
 * 
 * Solution: Greedy or Dynamic Programming(Only buy and sell once). greedy method is better (faster)
 * 
 */ 
class Solution {
    public int maxProfit(int[] prices) {
        // --------------------Greedy-----------------------------
        int min = Integer.MAX_VALUE;
        int result = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            } else {
                if (prices[i] - min > result) {
                    result = prices[i] - min;
                }
            }
        }
        return result;
        // -----------------DP-------------------------------------
        // int[][] dp = new int[prices.length][2];
        // // dp[i][0] keeps stock, dp[i][1] keeps no stock
        // dp[0][0] = 0 - prices[0];
        // for (int i = 1; i < prices.length; i++) {
        //     dp[i][0] = Math.max(dp[i - 1][0], 0 - prices[i]);
        //     dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
        // }
        // return dp[prices.length - 1][1];
    }
}



