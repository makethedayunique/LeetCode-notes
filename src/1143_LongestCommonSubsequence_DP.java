/**
 * 1143. Longest Common Subsequence
 * 
 * Given two strings text1 and text2, return the length of their longest common subsequence. 
 * If there is no common subsequence, return 0.
 *
 * A subsequence of a string is a new string generated from the original string with some characters 
 * (can be none) deleted without changing the relative order of the remaining characters.
 *
 * For example, "ace" is a subsequence of "abcde".
 * A common subsequence of two strings is a subsequence that is common to both strings.
 * 
 * Example 1:
 *
 * Input: text1 = "abcde", text2 = "ace" 
 * Output: 3  
 * Explanation: The longest common subsequence is "ace" and its length is 3.
 * 
 * Example 2:
 *
 * Input: text1 = "abc", text2 = "abc"
 * Output: 3
 * Explanation: The longest common subsequence is "abc" and its length is 3.
 * 
 * Example 3:
 *
 * Input: text1 = "abc", text2 = "def"
 * Output: 0
 * Explanation: There is no such common subsequence, so the result is 0.
 * 
 * Solution: Dynamic Programming, dp[i][j] represents the longest common subsequence until i-1 and j-1 positions
 * 
 */
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        // ------------------------2D-DP--------------------------------------
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1] + 1;
                else dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
            }
        }
        return dp[text1.length()][text2.length()];
    }
}



