/**
 * 188. Best Time to Buy and Sell Stock IV
 * 
 * You are given an integer array prices where prices[i] is the price of a given stock on the ith day, and an integer k.
 *
 * Find the maximum profit you can achieve. You may complete at most k transactions.
 *
 * Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
 * 
 * Example 1:
 *
 * Input: k = 2, prices = [2,4,1]
 * Output: 2
 * Explanation: Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit = 4-2 = 2.
 * 
 * Example 2:
 *
 * Input: k = 2, prices = [3,2,6,5,0,3]
 * Output: 7
 * Explanation: Buy on day 2 (price = 2) and sell on day 3 (price = 6), profit = 6-2 = 4. 
 * Then buy on day 5 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
 * 
 * Solution: Dynamic Programming. There will be 2 * k + 1 states on each day.
 * 
 */
class Solution {
    public int maxProfit(int k, int[] prices) {
        if (k == 0 || prices.length == 0) return 0;
        int[][] dp = new int[prices.length][2 * k + 1];
        for (int i = 0 ; i < k; i++) {
            dp[0][2 * i + 1] = - prices[0];
        }
        for (int i = 1; i < prices.length; i++) {
            for (int j = 1; j <= k; j++) {
                dp[i][2 * j - 1] = Math.max(dp[i - 1][2 * j - 1], dp[i - 1][2 * j - 2] - prices[i]);
                dp[i][2 * j] = Math.max(dp[i - 1][2 * j], dp[i - 1][2 * j - 1] + prices[i]);
            }
        }
        return dp[prices.length - 1][2 * k];
    }
}




