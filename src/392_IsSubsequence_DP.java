/**
 * 392. Is Subsequence
 * 
 * Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
 *
 * A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) 
 * of the characters without disturbing the relative positions of the remaining characters. 
 * (i.e., "ace" is a subsequence of "abcde" while "aec" is not).
 * 
 * Example 1:
 *
 * Input: s = "abc", t = "ahbgdc"
 * Output: true
 * 
 * Example 2:
 *
 * Input: s = "axc", t = "ahbgdc"
 * Output: false
 * 
 * Solution: DP, dp[i][j] represents if s[:i] is subsequence of t[:j]
 * If dp[i][j - 1] == true, then dp[i][j] = true
 * If dp[i - 1][j - 1] == true && s[i - 1] = t[j - 1], then dp[i][j] = true
 * Initialize dp[0] with all true meaning "" is subsequence of all t's substring
 *  
 */
class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s.length() > t.length()) return false;
        boolean[][] dp = new boolean[s.length() + 1][t.length() + 1];
        Arrays.fill(dp[0], true);
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                if (dp[i][j - 1]) dp[i][j] = true;
                if (s.charAt(i - 1) == t.charAt(j - 1) && dp[i - 1][j - 1]) dp[i][j] = true;
            }
        }
        return dp[s.length()][t.length()];
    }
}



