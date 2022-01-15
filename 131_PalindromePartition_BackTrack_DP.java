/*
 * 131. Palindrome Partitioning
 *
 * Given a string s, partition s such that every substring of the partition is a palindrome. 
 * Return all possible palindrome partitioning of s.
 *
 * A palindrome string is a string that reads the same backward as forward.
 *
 * Example 1:
 *
 * Input: s = "aab"
 * Output: [["a","a","b"],["aa","b"]]
 *
 * Example 2:
 *
 * Input: s = "a"
 * Output: [["a"]]
 *
 * Solution 1: Use dynamic programming to find all the substring
 * Solution 2: Use function to check if it is palindrome every time
 *
 */
class Solution {
    private int[][] dp;
    private List<List<String>> result = new ArrayList<>();
    private List<String> path = new ArrayList<>();
    
    public List<List<String>> partition(String s) {
    	//-----------------dp-procedure----------------------------
        dp = new int[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = 1;
        }
        for (int i = 1; i < s.length(); i++) { // Length of the substring - 1, start from len of 2
            for (int j = 0; j < s.length() - i; j++) {
                if (s.charAt(j) == s.charAt(j + i)) {
                    if (j + 1 <= j + i - 1 && dp[j + 1][j + i - 1] == 1) {
                        dp[j][j + i] = 1;
                    } else if (j + 1 > j + i - 1) {
                        dp[j][j + i] = 1;
                    } else {}
                } else {}
            }
        }
        
        backTrack(0, s);
        return result;
    }
    
    private void backTrack(int start, String s) {
        if (start == s.length()) {
            List<String> temp = new ArrayList<>();
            for (String subs: path) { temp.add(subs); }
            result.add(temp);
            return;
        }
        
        for (int i = start; i < s.length(); i++) {
        	// -----------------Use-the-dp------------------
            if (dp[start][i] == 1) {
        	// -----------------Use-the-sub-method----------
            // if (isPalindrome(s, start, i)) {
                path.add(s.substring(start, i + 1));
                backTrack(i + 1, s);
                path.remove(path.size() - 1);
            } else {
                continue;
            }
        }
    }
    
    private boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}


