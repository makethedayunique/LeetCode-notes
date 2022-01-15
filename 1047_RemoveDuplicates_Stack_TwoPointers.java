/*
 * 1047. Remove All Adjacent Duplicates In String
 *
 * You are given a string s consisting of lowercase English letters. 
 * A duplicate removal consists of choosing two adjacent and equal letters and removing them.
 *
 * We repeatedly make duplicate removals on s until we no longer can.
 *
 * Return the final string after all such duplicate removals have been made. 
 * It can be proven that the answer is unique.
 *
 * Example 1:
 *
 * Input: s = "abbaca"
 * Output: "ca"
 * Explanation: 
 * For example, in "abbaca" we could remove "bb" since the letters are adjacent and equal, 
 * and this is the only possible move.  The result of this move is that the string is "aaca", 
 * of which only "aa" is possible, so the final string is "ca".
 *
 * Example 2:
 *
 * Input: s = "azxxzy"
 * Output: "ay"
 *
 * Solution1: Two Pointers - better performance
 * Solution2: Stack
 *
 */
import java.util.LinkedList;
class Solution {
    public String removeDuplicates(String s) {
        /*
         * Use two pointers to change
         * --------------------------------Method-1----------------------------
         */
        char[] chars = s.toCharArray();
        int slow = 0;
        int fast = 0;
        while (fast < chars.length) {
            chars[slow] = chars[fast];
            if (slow > 0 && chars[slow] == chars[slow - 1]) {
                slow--; // slow is the position to fast position value to set
            } else {
                slow++;
            }
            fast++;
        }
        return new String(chars, 0, slow);
        
        /*
         * Use the Deque as the stack
         * --------------------------------Method-2----------------------------
         */
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty() || stack.peekFirst() != s.charAt(i)) {
                stack.addFirst(s.charAt(i));
            } else {
                stack.removeFirst();
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pollLast());
        }
        return sb.toString();
    }
}


