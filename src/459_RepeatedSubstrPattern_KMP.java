/*
 * 459. Repeated Substring Pattern
 *
 * Given a string s, check if it can be constructed by taking a substring of it and 
 * appending multiple copies of the substring together.
 *
 * Example 1:
 *
 * Input: s = "abab"
 * Output: true
 * Explanation: It is the substring "ab" twice.
 *
 * Example 2:
 *
 * Input: s = "aba"
 * Output: false
 *
 * Example 3:
 * 
 * Input: s = "abcabcabcabc"
 * Output: true
 * Explanation: It is the substring "abc" four times or the substring "abcabc" twice.
 * 
 * Solution: KMP Algorithm
 * After going through the string, if longest common prefix-suffix of last position is val,
 * If len % (len - val) == 0 and val != 0, then there is this pattern existing.
 * If not, then there is not.
 *
 */
class Solution {
    public boolean repeatedSubstringPattern(String s) {
        if (s.length() == 0) {
            return false;
        }
        int[] next = new int[s.length()];
        getNext(next, s);
        int len = s.length();
        if (next[len - 1] != 0 && len % (len - next[len - 1]) == 0) {
            return true;
        } else {
            return false;
        }
    }
    
    private void getNext(int[] next, String s) {
        next[0] = 0;
        int left = 0;
        for (int right = 1; right < s.length(); right++) {
            while (left > 0 && s.charAt(left) != s.charAt(right)) {
                left = next[left - 1];
            }
            if (s.charAt(left) == s.charAt(right)) {
                left++;
            }
            next[right] = left;
        }
    }
}


