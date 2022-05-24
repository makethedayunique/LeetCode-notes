/**
 * 647. Palindromic Substrings
 * 
 * Given a string s, return the number of palindromic substrings in it.
 *
 * A string is a palindrome when it reads the same backward as forward.
 * 
 * A substring is a contiguous sequence of characters within the string.
 * 
 * Example 1:
 *
 * Input: s = "abc"
 * Output: 3
 * Explanation: Three palindromic strings: "a", "b", "c".
 * 
 * Example 2:
 *
 * Input: s = "aaa"
 * Output: 6
 * Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
 * 
 * Solution: Use dynamic programming to calculate.
 * 			 Two base cases: 1. string with only one character
 * 			 				 2. string with two characters
 * 
 **/
class Solution {
    public int countSubstrings(String s) {
        /**
            Use dynamic programming
            two base cases: word with one character and two characters
        **/
        int sLen = s.length();
        // ===================================Method 1================================:
        /**
        boolean[][] dp = new boolean[sLen][sLen]; // Initialize with all false
        int result = 0; // This is the returned variable maintaining the count of palindromes
        for (int i = 0; i < sLen; i++) {
            dp[i][i] = true;
            result += 1;
        }
        // Base case with two characters
        for (int i = 0; i < sLen - 1; i++) {
            if (s.charAt(i) == s.charAt(i+1)) {
                result += 1;
                dp[i][i+1] = true;
            }
        }
        // Iteration
        for (int l = 3; l <= sLen; l++) {
            for (int i = 0; i <= sLen-l; i++) {
                if (dp[i+1][i+l-2] && s.charAt(i) == s.charAt(i+l-1)) {
                    result += 1;
                    dp[i][i+l-1] = true;
                }
            }
        }
        **/
        // ===================================Method 2================================:
        int result = 0;
        // Iterate through all the one character and two characters as the centers
        for (int i = 0; i < sLen; i++) {
            result += countAroundCenter(s, i, i);
            result += countAroundCenter(s, i, i+1);
        }
        return result;
        
    }
    
    private int countAroundCenter(String s, int left, int right) {
        // Count all palindromes with center string s
        int res = 0;
        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) == s.charAt(right)) {
                res += 1;
                left--;
                right++;
            } else {
                break;
            }
        }
        return res;
    }
}



