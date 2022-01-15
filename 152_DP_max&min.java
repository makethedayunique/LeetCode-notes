/*
 * 152. Maximum Product Subarray
 * 
 * Given an integer array nums, find a contiguous non-empty subarray 
 * within the array that has the largest product, and return the product.
 *
 * It is guaranteed that the answer will fit in a 32-bit integer.
 *
 * A subarray is a contiguous subsequence of the array.
 *
 * Example 1:
 * Input: nums = [2,3,-2,4]
 * Output: 6
 * Explanation: [2,3] has the largest product 6.
 *
 * Example 2:
 * Input: nums = [-2,0,-1]
 * Output: 0
 * Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 *
 * Constraints:
 *
 * 1 <= nums.length <= 2 * 104
 * -10 <= nums[i] <= 10
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 *
*/
class Solution {
    public int maxProduct(int[] nums) {
        /*
         * @ Think about maintain the maxmum value of the subarray and minimum value
         * @ Everytime update the two values
         * @ When meet with 0, update to 1
         * @ Initialize the max result to max(nums)
        */
        int currMax = 1;
        int currMin = 1;
        int maxV = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num > maxV) {
                maxV = num;
            }
        }
        for (int num : nums) {
            if (num == 0) {
                currMax = 1;
                currMin = 1;
            } else {
                int temp = currMax * num;
                currMax = Math.max(temp, currMin * num);
                currMin = Math.min(temp, currMin * num);
                
                if (num > currMax) {
                    currMax = num;
                }
                if (num < currMin) {
                    currMin = num;
                }
                
                if (currMax > maxV) {
                    maxV = currMax;
                }
            }
        }
        return maxV;
    }
}