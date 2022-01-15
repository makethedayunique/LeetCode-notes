/**
 * 122. Best Time to Buy and Sell Stock II
 * You are given an integer array prices where prices[i] is the price of a given stock on the ith day.
 *
 * On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time. 
 * However, you can buy it then immediately sell it on the same day.
 *
 * Find and return the maximum profit you can achieve.
 * 
 * Example 1:
 *
 * Input: prices = [7,1,5,3,6,4]
 * Output: 7
 * Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
 * Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
 * Total profit is 4 + 3 = 7.
 * 
 * Example 2:
 *
 * Input: prices = [1,2,3,4,5]
 * Output: 4
 * Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
 * Total profit is 4.
 * 
 * Greedy and DP
 * 
 */
class Solution {
    public int maxProfit(int[] prices) {
        // Always buy at a low point and sell when reaches the highest point
        int profit = 0;
        int priceB = prices[0];
        int sold = 0; // flag to mark if bought stock has been sold
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < prices[i - 1]) {
                profit += prices[i - 1] - priceB;
                priceB = prices[i];
                sold = 1;
            } else {
                sold = 0;
            }
        }
        if (sold == 0) {
            profit += (prices[prices.length - 1] - priceB);
        }
        return profit;
        // -----------------Sell-and-buy-everyday-only-take-positive-profit-----
        // int profit = 0;
        // for (int i = 1; i < prices.length; i++) {
        //     profit += Math.max(0, prices[i] - prices[i - 1]);
        // }
        // return profit;
        // ---------------------DP----------------------------------------------
        // int[][] dp = new int[prices.length][2];
        // // dp[i][0] represents maximum cash when having stock
        // // dp[i][1] represents maximum cash after selling stock
        // dp[0][0] = -1 * prices[0];
        // for (int i = 1; i < prices.length; i++) {
        //     dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
        //     dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
        // }
        // return Math.max(dp[prices.length - 1][0], dp[prices.length - 1][1]);
    }
}



