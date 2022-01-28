/**
 * 115. Distinct Subsequences
 * 
 * Given two strings s and t, return the number of distinct subsequences of s which equals t.
 *
 * A string's subsequence is a new string formed from the original string by deleting some (can be none) of 
 * the characters without disturbing the remaining characters' relative positions. 
 * (i.e., "ACE" is a subsequence of "ABCDE" while "AEC" is not).
 *
 * The test cases are generated so that the answer fits on a 32-bit signed integer.
 * 
 * Example 1:
 *
 * Input: s = "rabbbit", t = "rabbit"
 * Output: 3
 * Explanation:
 * As shown below, there are 3 ways you can generate "rabbit" from S.
 * ra*b*bbit
 * rab*b*bit
 * rabb*b*it
 *
 * Example 2:
 *
 * Input: s = "babgbag", t = "bag"
 * Output: 5
 * Explanation:
 * As shown below, there are 5 ways you can generate "bag" from S. 
 * 
 * Solution: Use Dynamic Programming, dp[i][j] represents the number of subsequences of s[:j] equals t[:i]
 * 
 */
class Solution {
    public int numDistinct(String s, String t) {
        if (s.length() < t.length()) return 0;
        int[][] dp = new int[t.length() + 1][s.length() + 1];
        Arrays.fill(dp[0], 1);
        for (int i = 1; i <= t.length(); i++) {
            for (int j = 1; j <= s.length(); j++) {
                dp[i][j] += dp[i][j - 1];
                if (t.charAt(i - 1) == s.charAt(j - 1)) {
                    dp[i][j] += dp[i - 1][j - 1];
                }
            }
        }
        return dp[t.length()][s.length()];
    }
}




