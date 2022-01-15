/*
 * 28. Implement strStr()
 *
 * Implement strStr().
 *
 * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 *
 * Clarification:
 *
 * What should we return when needle is an empty string? This is a great question to ask during an interview.
 *
 * For the purpose of this problem, we will return 0 when needle is an empty string. 
 * This is consistent to C's strstr() and Java's indexOf().
 *
 * Example 1:
 *
 * Input: haystack = "hello", needle = "ll"
 * Output: 2
 *
 * Example 2:
 *
 * Input: haystack = "aaaaa", needle = "bba"
 * Output: -1
 *
 * Example 3:
 *
 * Input: haystack = "", needle = ""
 * Output: 0
 *
 * KMP Algorithm
 * Build a prefix table which stores the longest common length of prefix and suffix of the substring ended in i
 * When iterating the string, if met with a mismatch, go to the next[i - 1] position to continue
 *
 * Runtime 91%, memory 84%
 *
 */
class Solution {
    public int strStr(String haystack, String needle) {
        /*
         * We will use KMP algorithm for this question
         * Build a prefix table which stores the longest common prefix-suffix table
         * It will help us avoid repeated match
         */
        if (needle.length() == 0) {
            return 0;
        }
        int[] next = new int[needle.length()];
        getNext(next, needle);
        int start = 0; // Start index to match in the needle [0, needle)
        for (int i = 0; i < haystack.length(); i++) {
            while (start > 0 && needle.charAt(start) != haystack.charAt(i)) {
                start = next[start - 1];
            }
            if (needle.charAt(start) == haystack.charAt(i)) {
                start++;
            }
            if (start == next.length) {
                return i - next.length + 1;
            }
        }
        return -1;
    }
    
    private void getNext(int[] next, String needle) {
        /*
         * This function intends to find build the prefix table next
         */
        next[0] = 0;
        int left = 0;
        for (int right = 1; right < needle.length(); right++) {
            while (left > 0 && needle.charAt(left) != needle.charAt(right)) {
                left = next[left - 1]; // Find the prefix index of the previous position
            }
            if (needle.charAt(left) == needle.charAt(right)) {
                left++;
            }
            next[right] = left;
        }
    }
}


