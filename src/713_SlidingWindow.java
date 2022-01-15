/*
 * 713. Subarray Product Less Than K
 *
 * Given an array of integers nums and an integer k, 
 * return the number of contiguous subarrays where the product of all the elements 
 * in the subarray is strictly less than k.
 *
 * Example 1:
 * Input: nums = [10,5,2,6], k = 100
 * Output: 8
 * Explanation: The 8 subarrays that have product less than 100 are:
 * [10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6]
 * Note that [10, 5, 2] is not included as the product of 100 is not strictly less than k.
 *
 * Example 2:
 * Input: nums = [1,2,3], k = 0
 * Output: 0
*/
class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        // Method: sliding window
        // To find the increased number of subarray is to add the current window size
        // Example: [5,2] -> [5,2,4] if still satisfy, then add 3
        //          3 means add {4} to {} {2} {5,2}
        //          [5,2,4] -> [5,2,4,6] if still satisfy, then add 4
        //          4 means add {6} to {} {4} {2,4} {5,2,4}
        //          [5,2,4,6] -> [2,4,6,8] slide by one location, then add 4
        //          4 means add {8} to {} {6} {4,6} {2,4,6}
        //          By doing so, can avoid duplicated subarray counting
        
        if (k <= 1) {
            return 0;
        }
        
        int res = 0;
        int left = 0; // left pointer
        int currPro = 1;
        // i is the right pointer
        for (int i = 0; i < nums.length; i++) {
            currPro *= nums[i];
            while (currPro >= k) {
                currPro /= nums[left];
                left++;
            }
            res += i - left + 1; // Increment by the size
        }
        return res;
    }
}