/*
 * 151. Reverse Words in a String
 *
 * Given an input string s, reverse the order of the words.
 *
 * A word is defined as a sequence of non-space characters. 
 * The words in s will be separated by at least one space.
 *
 * Return a string of the words in reverse order concatenated by a single space.
 *
 * Note that s may contain leading or trailing spaces or multiple spaces between two words. 
 * The returned string should only have a single space separating the words. Do not include any extra spaces.
 *
 * Example 1:
 *
 * Input: s = "the sky is blue"
 * Output: "blue is sky the"
 *
 * Example 2:
 * 
 * Input: s = "  hello world  "
 * Output: "world hello"
 * Explanation: Your reversed string should not contain leading or trailing spaces.
 *
 * Example 3:
 *
 * Input: s = "a good   example"
 * Output: "example good a"
 * Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
 *
 * Solution: Use two pointers and go through character array only once
 * Runtime: 100%, Memory: 99.01%
 *
 */
class Solution {
    public String reverseWords(String s) {
        /*
         * Play with string and two pointers
         */
        char[] chars = s.toCharArray();
        char[] newChars = new char[chars.length + 1]; // Reserve an extra space
        // Start from the last position
        int index = chars.length - 1;
        int newPos = 0;
        while (index >= 0) {
            while (index >= 0 && chars[index] == ' ') { index--; } // Skip all the spaces
            int endIndex = index;
            while (index >= 0 && chars[index] != ' ') { index--; }
            for (int i = index + 1; i <= endIndex; i++) {
                newChars[newPos] = chars[i];
                newPos++;
                // The check need to be put in the loop to avoid extra space
                if (i == endIndex) {
                    newChars[newPos] = ' ';
                    newPos++;
                }
            }
        }
        if (newPos == 0) {
            return "";
        } else {
            return new String(newChars, 0, newPos - 1);
        }
    }
}

