/**
 * 680. Valid Palindrome II
 * 
 * Given a string s, return true if the s can be palindrome after deleting at most one character from it.
 * 
 * Example 1:
 *
 * Input: s = "aba"
 * Output: true
 * 
 * Example 2:
 *
 * Input: s = "abca"
 * Output: true
 * Explanation: You could delete the character 'c'.
 * 
 * Example 3:
 *
 * Input: s = "abc"
 * Output: false
 * 
 **/
class Solution {
    public boolean validPalindrome(String s) {
        // The thought here is that compare the outermost characters of a string
        // It they are the same, we could delete the outermost chars and check the rest
        // If the current two chars are not equal, we only need to check strings deleting
        // one of the two chars. Because if we don't delete one of the two chars, it can
        // never be palindromes.
        int l = 0;
        int r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return ifPalindrome(s, l + 1, r) || ifPalindrome(s, l, r - 1);
            }
            l++;
            r--;
        }
        return true;
    }
    
    private boolean ifPalindrome(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}

 