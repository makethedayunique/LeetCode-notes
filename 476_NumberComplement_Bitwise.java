/*
 * 476. Number Complement
 *
 * The complement of an integer is the integer you get when you flip all the 0's to 1's 
 * and all the 1's to 0's in its binary representation.
 * 
 * For example, The integer 5 is "101" in binary and its complement is "010" which is the integer 2.
 * Given an integer num, return its complement.
 *
 * Example 1:
 *
 * Input: num = 5
 * Output: 2
 * Explanation: The binary representation of 5 is 101 (no leading zero bits), and its complement is 010. 
 * So you need to output 2.
 *
 */
class Solution {
    public int findComplement(int num) {
        int[] br = new int[31];
        int index = 0;
        while (num > 0) {
        	// Check if the lowest position is 1
            br[index] = (num & 1);
            num = num / 2;
            index++;
        }
        int base = 1;
        for (int i = 0; i < index; i++) {
            br[i] = 1 - br[i];
            num += (base * br[i]);
            base *= 2;
        }
        return num;
    }
}