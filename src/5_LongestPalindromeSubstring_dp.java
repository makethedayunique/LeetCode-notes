/**
 * 5. Longest Palindromic Substring
 * 
 * Given a string s, return the longest palindromic substring in s.
 * 
 * Example 1:
 *
 * Input: s = "babad"
 * Output: "bab"
 * Explanation: "aba" is also a valid answer.
 * 
 * Example 2:
 *
 * Input: s = "cbbd"
 * Output: "bb"
 * 
 * Solution: use dynamic programming
 * dp[i][j] is a boolean value indicating whether substring s[i:j] is a palindrome
 * 
 **/
class Solution {
    public String longestPalindrome(String s) {
        /** Use DP **/
        boolean[][] dp = new boolean[s.length()][s.length()];
        int[] result = new int[2];
        int len = s.length();
        // Initiate substring with length 1
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        // Initiate substring with length 2
        for (int i = 0; i < len-1; i++) {
            if (s.charAt(i) == s.charAt(i+1)) {
                dp[i][i+1] = true;
                result[0] = i;
                result[1] = i+1;
            }
        }
        // Extend the length until the string length
        for (int l = 3; l <= len; l++) {
            for (int i = 0; i < len-l+1; i++) {
                if (dp[i+1][i+l-2] == true && s.charAt(i) == s.charAt(i+l-1)) {
                    dp[i][i+l-1] = true;
                    result[0] = i;
                    result[1] = i+l-1;
                }
            }
        }
        return s.substring(result[0],result[1]+1);
    }
}


 