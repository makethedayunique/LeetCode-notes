/**
 * 1249. Minimum Remove to Make Valid Parentheses
 * 
 * Given a string s of '(' , ')' and lowercase English characters.
 *
 * Your task is to remove the minimum number of parentheses ( '(' or ')', 
 * in any positions ) so that the resulting parentheses string is valid and return any valid string.
 *
 * Formally, a parentheses string is valid if and only if:
 * 
 * It is the empty string, contains only lowercase characters, or
 * It can be written as AB (A concatenated with B), where A and B are valid strings, or
 * It can be written as (A), where A is a valid string.
 * 
 * Example 1:
 *
 * Input: s = "lee(t(c)o)de)"
 * Output: "lee(t(c)o)de"
 * Explanation: "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.
 * 
 * Example 2:
 *
 * Input: s = "a)b(c)d"
 * Output: "ab(c)d"
 * 
 * Example 3:
 *
 * Input: s = "))(("
 * Output: ""
 * Explanation: An empty string is also valid.
 * 
 * Solution:
 * solution1: Use hashset to store the parentheses to be removed
 * solution2: Two passes to take valid characters
 * 
 **/
class Solution {
    public String minRemoveToMakeValid(String s) {
        /** ============Solution1=============================
        USe stack and priority queue to record the invalid opening and closing parentheses
        And then remove them. We could use hashset to optimize the speed 
        **/
        /**
        PriorityQueue<Integer> invalidCloses = new PriorityQueue<>();
        Stack<Integer> openPs = new Stack<Integer>();
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                openPs.push(i);
            } else if (s.charAt(i) == ')') {
                if (openPs.isEmpty()) {
                    invalidCloses.offer(i);
                } else {
                    openPs.pop();
                }
            } else {
                continue;
            }
        }
        
        while (!openPs.isEmpty()) {
            invalidCloses.offer(openPs.pop());
        }
        
        StringBuilder sb = new StringBuilder();
        int index = 0;
        
        while (!invalidCloses.isEmpty()) {
            int skip = invalidCloses.poll();
            sb.append(s.substring(index, skip));
            index = skip + 1;
        }
        if (index < s.length()) sb.append(s.substring(index));
        
        return sb.toString();
        **/
        
        /**============Solution2=============================
        Two passes, first time iterate and remove invalid ")", and record the number of invalid 
        Second pass just remove the "(" from rightmost **/
        int extraLeftCount = 0;
        int leftCount = 0;
        // First Pass
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                leftCount++;
                extraLeftCount++;
            } else if (s.charAt(i) == ')') {
                if (extraLeftCount == 0) {
                    continue;
                }
                extraLeftCount--;
            }
            sb.append(s.charAt(i));
        }
        
        // Second Pass
        StringBuilder result = new StringBuilder();
        int keepLeft = leftCount - extraLeftCount;
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '(') {
                if (keepLeft == 0) continue;
                keepLeft--;
            }
            result.append(sb.charAt(i));
        }
        return result.toString();
    }
}



 