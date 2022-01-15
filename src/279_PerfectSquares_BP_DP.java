/**
 * 279. Perfect Squares
 * 
 * Given an integer n, return the least number of perfect square numbers that sum to n.
 *
 * A perfect square is an integer that is the square of an integer; in other words, 
 * it is the product of some integer with itself. For example, 1, 4, 9, and 16 are perfect squares while 3 and 11 are not.
 *
 * Example 1:
 *
 * Input: n = 12
 * Output: 3
 * Explanation: 12 = 4 + 4 + 4.
 * 
 * Example 2:
 *
 * Input: n = 13
 * Output: 2
 * Explanation: 13 = 4 + 9.
 * 
 * Solution: Same as the 322, backPack problem.
 * 
 */
class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        int end = (int)Math.sqrt(n);
        for (int i = 1; i <= end; i++) {
            for (int j = i*i; j <= n; j++) {
                if (dp[j - i * i] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j - i * i] + 1);
                }
            }
        }
        if (dp[n] == Integer.MAX_VALUE) return -1;
        return dp[n];
    }
}




