/**
 * 32. Longest Valid Parentheses
 * 
 * Given a string containing just the characters '(' and ')', 
 * find the length of the longest valid (well-formed) parentheses substring.
 * 
 * Example 1:
 *
 * Input: s = "(()"
 * Output: 2
 * Explanation: The longest valid parentheses substring is "()".
 * 
 * Example 2:
 *
 * Input: s = ")()())"
 * Output: 4
 * Explanation: The longest valid parentheses substring is "()()".
 * 
 * Example 3:
 *
 * Input: s = ""
 * Output: 0
 * 
 * Solution: There are two methods, one is using dynamic programming, another is using stack to keep record of the index of
 * opening parentheses.
 * 
 **/

class Solution {
    public int longestValidParentheses(String s) {
        //==================Method1:DP=======================
        // int sLen = s.length();
        // int result = 0; // The result maximum length
        // // dp[i] represents the longest valid substring ending at ith index
        // int[] dp = new int[sLen];
        // for (int i = 1; i < sLen; i++) {
        //     // Only when c = ")" we need to update the value
        //     if (s.charAt(i) == ')') {
        //         if (s.charAt(i-1) == '(') {
        //             // Add 2 to the dp[i-2];
        //             dp[i] = (i >= 2 ? dp[i-2] : 0) + 2;
        //         } else {
        //             // Check if there is a open parentheses on the left
        //             if (i-dp[i-1]-1 >= 0 && s.charAt(i-dp[i-1]-1) == '(') {
        //                 dp[i] = dp[i-1] + ((i-dp[i-1]-2) >= 0 ? dp[i-dp[i-1]-2] : 0) + 2;
        //             }
        //         }
        //         // In other cases, the dp[i] = 0
        //         result = Math.max(result, dp[i]);
        //     }
        // }
        // return result;
        //==================Method2:Stack=======================
        // When encountering (, push the index into stack
        // When encountering ), pop one element, and calculate the difference between i and peek
        // After popping, if the stack is empty, we need to push the current index into it
        // This index would be used as the boundary to calculate the length
        Stack<Integer> openIdx = new Stack<>();
        openIdx.push(-1); // Used as the left boundary to calculate the difference
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                openIdx.push(i);
            } else {
                openIdx.pop(); // Pop out one
                if (openIdx.isEmpty()) {
                    openIdx.push(i);
                } else {
                    result = Math.max(result, i-openIdx.peek());
                }
            }
        }
        return result;
    }
}


