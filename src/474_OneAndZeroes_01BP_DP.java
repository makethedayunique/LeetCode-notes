/**
 * 474. Ones and Zeroes
 * 
 * You are given an array of binary strings strs and two integers m and n.
 *
 * Return the size of the largest subset of strs such that there are at most m 0's and n 1's in the subset.
 *
 * A set x is a subset of a set y if all elements of x are also elements of y.
 * 
 * Example 1:
 *
 * Input: strs = ["10","0001","111001","1","0"], m = 5, n = 3
 * Output: 4
 * Explanation: The largest subset with at most 5 0's and 3 1's is {"10", "0001", "1", "0"}, so the answer is 4.
 * Other valid but smaller subsets include {"0001", "1"} and {"10", "1", "0"}.
 * {"111001"} is an invalid subset because it contains 4 1's, greater than the maximum of 3.
 * 
 * Example 2:
 *
 * Input: strs = ["10","0","1"], m = 1, n = 1
 * Output: 2
 * Explanation: The largest subset is {"0", "1"}, so the answer is 2.
 *
 * Solution: This is a backpack problem, go through all the strs, dp[i][j] means the largest subset by using str before this
 *           and no more than i's 0 and j's 1
 * dp[i][j] = max(dp[i][j], dp[i-zeroNum][j-oneNum] + 1)
 * Traverse from back to forth, because you cannot use the updated array
 *  
 */
class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (String str: strs) {
            int one = 0;
            int zero = 0;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '0') zero++;
                else one++;
            }
            // Traverse from the back to the number
            for (int j = m; j >= zero; j--) {
                for (int k = n; k >= one; k--) {
                    dp[j][k] = Math.max(dp[j][k], dp[j - zero][k - one] + 1);
                }
            }
        }
        return dp[m][n];
    }
}



