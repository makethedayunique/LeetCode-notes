/**
 * 268. Missing Number
 * 
 * Given an array nums containing n distinct numbers in the range [0, n], 
 * return the only number in the range that is missing from the array.
 *
 * Example 1:
 *
 * Input: nums = [3,0,1]
 * Output: 2
 * Explanation: n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 
 * 2 is the missing number in the range since it does not appear in nums.
 * 
 **/
class Solution {
    public int missingNumber(int[] nums) {
        /** Solution 1 **/
        // boolean[] exist = new boolean[nums.length+1];
        // for (int num: nums) {
        //     exist[num] = true;
        // }
        // for (int i = 0; i < exist.length; i++) {
        //     if (!exist[i]) {
        //         return i;
        //     }
        // }
        // return -1;
        /** Solution 2 **/
        // Every index XOR value should be 0, so if there is no missing,
        // The XOR result of all indexes and values should lead to 0
        // So the result in this question will be the missing value
        int result = nums.length;
        for (int i = 0; i < nums.length; i++) {
            result = result ^ (i ^ nums[i]);
        }
        return result;
    }
}