/**
 * 227. Basic Calculator II
 * 
 * Given a string s which represents an expression, evaluate this expression and return its value. 
 *
 * The integer division should truncate toward zero.
 *
 * You may assume that the given expression is always valid. All intermediate results will be in the range of [-231, 231 - 1].
 *
 * Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().
 * 
 * Example 1:
 *
 * Input: s = "3+2*2"
 * Output: 7
 * Example 2:
 *
 * Input: s = " 3/2 "
 * Output: 1
 * Example 3:
 *
 * Input: s = " 3+5 / 2 "
 * Output: 5
 * 
 * Solution: When going through the current number, we can decide to do the correct computation
 * based on the previous operator.
 *
 */
class Solution {
    public int calculate(String s) {
        /**
            Whether to store the current number will be dependent on the next
            operator
            Go through the characters, if it is digit, store to current number
            If it is an operator, if the previous operator is + or -, push the
            current number with previous number into stack
            If the previous operator is * or /, compute by popping one previous
            number and pushing into the stack
        */
        /**
        int sLen = s.length();
        Stack<Integer> stack = new Stack<>();
        char prevOp = '+'; // Default operator
        int currNum = 0;
        
        for (int i = 0; i < sLen; i++) {
            char currChar = s.charAt(i);
            // If the char is digit
            if (Character.isDigit(currChar)) {
                currNum = currNum * 10 + (currChar - '0');
            }
            // Other conditions, if this is the end, also compute
            if (!Character.isDigit(currChar) && !Character.isWhitespace(currChar) || i == sLen - 1) {
                // If it is not space and not digit, or it is the end of the string
                // Check the previous operator
                if (prevOp == '+') {
                    stack.push(currNum); // Push +currNum
                } else if (prevOp == '-') {
                    stack.push(-currNum); // Push -currNum
                } else if (prevOp == '*') {
                    stack.push(stack.pop() * currNum); // Push prevNum * currNum
                } else {
                    stack.push(stack.pop() / currNum); // Push prevNum / currNum
                }
                // Update the previous operator to this operator
                prevOp = currChar;
                currNum = 0;
            }
        }
        // Go through the stack and compute the result
        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;
        */
        /**
        Solution 2: without using a stack, we can just use a variable to track the previous value
        */
        int sLen = s.length();
        char prevOp = '+'; // Default operator
        int currNum = 0;
        int prevNum = 0;
        int result = 0;
        
        for (int i = 0; i < sLen; i++) {
            char currChar = s.charAt(i);
            // If the char is digit
            if (Character.isDigit(currChar)) {
                currNum = currNum * 10 + (currChar - '0');
            }
            // Other conditions, if this is the end, also compute
            if (!Character.isDigit(currChar) && !Character.isWhitespace(currChar) || i == sLen - 1) {
                // If it is not space and not digit, or it is the end of the string
                // Check the previous operator
                if (prevOp == '+' || prevOp == '-') {
                    // If the previous op is + or -, then the previous number 
                    // could be updated to the result, the current number should
                    // be updated to the prevNum with the correct symbol
                    result = result + prevNum;
                    prevNum = prevOp == '+' ? currNum:-currNum;
                } else if (prevOp == '*') {
                    // If the previous op is *, compute and update to the previous
                    prevNum = prevNum * currNum;
                } else {
                    prevNum = prevNum / currNum;
                }
                // Update the previous operator to this operator
                prevOp = currChar;
                currNum = 0;
            }
        }
        // Finally, add the currNum to the result
        result += prevNum;
        return result;
    }
}


 