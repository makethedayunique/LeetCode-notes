/*
 * 523. Continuous Subarray Sum
 *
 * Given an integer array nums and an integer k, 
 * return true if nums has a continuous subarray of size at least two 
 * whose elements sum up to a multiple of k, or false otherwise.

 * An integer x is a multiple of k if there exists an integer n 
 * such that x = n * k. 0 is always a multiple of k.
 *
 * Example 1:
 * Input: nums = [23,2,4,6,7], k = 6
 * Output: true
 * Explanation: [2, 4] is a continuous subarray of size 2 whose elements sum up to 6.
 *
 * Example 2:
 * Input: nums = [23,2,6,4,7], k = 13
 * Output: false
*/

import java.util.Hashtable;
class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        /*
         * @ Method: prefix sum and hashtable
         * @ Principle:
         * @ prefix array sum = k * x + r
         * @ for current array, if you can find r in hashtable
         * @ current array sum = k * y + r
         * @ k * y + r - k * x - r = k * (y - x)
         * @ which returns true
         * @ Initialize with (0, -1)
         * @ If first element we find k, then check if 0 - (-1) > 2
        */
        Hashtable<Integer, Integer> prefixIndex = new Hashtable<>();
        prefixIndex.put(0, -1);
        int currSum = 0;
        int index = 0;
        for (int num : nums) {
            currSum += num;
            currSum %= k;
            if (prefixIndex.containsKey(currSum)) {
                if (index - prefixIndex.get(currSum) >= 2) {
                    return true;
                }
            } else {
                prefixIndex.put(currSum, index);
            }
            index++;
        }
        return false;
    }
}

