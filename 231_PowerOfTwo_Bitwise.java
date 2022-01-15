/*
 * 231. Power of Two
 *
 * Given an integer n, return true if it is a power of two. Otherwise, return false.
 *
 * An integer n is a power of two, if there exists an integer x such that n == 2x.
 *
 * Example 1:
 *
 * Input: n = 1
 * Output: true
 * Explanation: 20 = 1
 *
 * Example 2:
 *
 * Input: n = 16
 * Output: true
 * Explanation: 24 = 16
 *
 */
class Solution {
    public boolean isPowerOfTwo(int n) {
        // -----------bitwise-manipulation----------
        /*
         * power of n: only one 1 in the number
         * 1: 0b1
         * 2: 0b10
         * 4: 0b100
         * n - 1: all 1 except for the highest
         * 0: 0b0
         * 1: 0b01
         * 3: 0b011
         * n & n - 1 = 0
         * won't for non power-of-two numbers
         *
         */
        return n > 0 && (n & n - 1) == 0; // "-" priority is higher than "&"
        // ------------------Loop-------------------
        // if (n <= 0) {
        //     return false;
        // }
        // while (n > 1) {
        //     if (n % 2 == 0) {
        //         n = n / 2;
        //     } else {
        //         return false;
        //     }
        // }
        // return true;
    }
}



