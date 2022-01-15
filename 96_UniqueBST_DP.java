/**
 * 96. Unique Binary Search Trees
 * 
 * Given an integer n, return the number of structurally unique BST's (binary search trees) which has exactly n nodes
 * of unique values from 1 to n.
 * 
 * Example 1:
 * 
 * Input: n = 3
 * Output: 5
 * 
 * Example 2:
 *
 * Input: n = 1
 * Output: 1
 * 
 * Solution: when you see that you need to return a number, basically it means that you need to use the dynamic programming
 * 
 */
class Solution {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += (dp[j - 1] * dp[i - j]);
            }
        }
        return dp[n];
    }
}