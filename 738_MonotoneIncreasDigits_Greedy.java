/**
 * 738. Monotone Increasing Digits
 * 
 * An integer has monotone increasing digits if and only if each pair of adjacent digits x and y satisfy x <= y.
 *
 * Given an integer n, return the largest number that is less than or equal to n with monotone increasing digits.
 * 
 * Example 1:
 *
 * Input: n = 10
 * Output: 9
 * 
 * Example 2:
 *
 * Input: n = 1234
 * Output: 1234
 * 
 * Solution: find the last one left > right from the last, label the start index and change all digits later to '9'
 * 			1243 -> 1239
 * 			98765 -> 89999
 * 
 */
class Solution {
    public int monotoneIncreasingDigits(int n) {
        /*
         * Start from the final one, if i + 1 < i, i--, store the i+1 position
         * all the positions behind i + 1 should be set to 9 later
         */
        Integer y = new Integer(n);
        char[] digits = y.toString().toCharArray();
        int start = Integer.MAX_VALUE;
        for (int i = digits.length - 1; i > 0; i--) {
            if (digits[i] < digits[i - 1]) {
                digits[i - 1] = (char)(digits[i - 1] - '1' + '0');
                // replace with digits[i - 1]--;
                start = i;
            }
        }
        int result = 0;
        int index = 0;
        while (index < digits.length) {
            if (index >= start) {
                result = 10 * result + 9;
            } else {
                result = 10 * result + (digits[index] - '0');
            }
            index++;
        }
        return result;
    }
}


