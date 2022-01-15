/**
 * 714. Best Time to Buy and Sell Stock with Transaction Fee
 * 
 * You are given an array prices where prices[i] is the price of a given stock on the ith day, 
 * and an integer fee representing a transaction fee.
 *
 * Find the maximum profit you can achieve. You may complete as many transactions as you like, 
 * but you need to pay the transaction fee for each transaction.
 *
 * Note: You may not engage in multiple transactions simultaneously 
 * (i.e., you must sell the stock before you buy again).
 * 
 * Example 1:
 *
 * Input: prices = [1,3,2,8,4,9], fee = 2 
 * Output: 8
 * Explanation: The maximum profit can be achieved by:
 * - Buying at prices[0] = 1
 * - Selling at prices[3] = 8
 * - Buying at prices[4] = 4
 * - Selling at prices[5] = 9
 * The total profit is ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
 * 
 * Example 2:
 * 
 * Input: prices = [1,3,7,5,10,3], fee = 3
 * Output: 6
 * 
 * Solution: DP or Greedy
 * 
 */
class Solution {
    public int maxProfit(int[] prices, int fee) {
        // -------------------------Greedy-------------------------------
        int minVal = prices[0];
        int result = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minVal) {
                minVal = prices[i];
            }
            if (prices[i] - minVal <= fee) {
                continue;
            }
            result += (prices[i] - minVal - fee); // Not actually sell, but store the profit
            minVal = prices[i] - fee; // If it's a real sell, then profit will be it and minVal will finally be updated, if not, then minVal is prices[i] - fee
        }
        return result;
        
        // ----------------------Dynamic-Programming---------------------
//         int[][] dp = new int[prices.length][2];
//         // [i][0] sell [i][1] hold
//         dp[0][1] = -1 * prices[0];
        
//         for (int i = 1; i < prices.length; i++) {
//             dp[i][0] = Math.max(dp[i - 1][1] + prices[i] - fee, dp[i - 1][0]);
//             dp[i][1] = Math.max(dp[i - 1][0] - prices[i], dp[i - 1][1]);
//         }
        
//         return Math.max(dp[prices.length - 1][0], dp[prices.length - 1][1]);
    }
}



