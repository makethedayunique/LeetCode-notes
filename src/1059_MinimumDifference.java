/**
 * 1509. Minimum Difference Between Largest and Smallest Value in Three Moves
 * 
 * You are given an integer array nums. In one move, you can choose one element of nums and change it by any value.
 *
 * Return the minimum difference between the largest and smallest value of nums after performing at most three moves.
 * 
 * Example 1:
 *
 * Input: nums = [5,3,2,4]
 * Output: 0
 * Explanation: Change the array [5,3,2,4] to [2,2,2,2].
 * The difference between the maximum and minimum is 2-2 = 0.
 * 
 * Example 2:
 *
 * Input: nums = [1,5,0,10,14]
 * Output: 1
 * Explanation: Change the array [1,5,0,10,14] to [1,1,0,1,1]. 
 * The difference between the maximum and minimum is 1-0 = 1.
 * 
 * Solution: Sort the array in ascending order, and then take the first three - two - one - zero elements from 
 * the front and get the minimum difference
 * 
 **/
class Solution {
    public int minDifference(int[] nums) {
        if (nums.length <= 4) {
            return 0;
        }
        Arrays.sort(nums);
        int arrayLen = nums.length;
        int result = Integer.MAX_VALUE;
        for (int i = 0; i <= 3; i++) {
            result = Math.min(result, nums[arrayLen-4+i]-nums[i]);
        }
        return result;
    }
} 