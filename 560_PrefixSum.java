/*
 * 560. Subarray Sum Equals K
 *
 * Given an array of integers nums and an integer k, 
 * return the total number of continuous subarrays whose sum equals to k.
 * 
 * Example 1:
 * Input: nums = [1,1,1], k = 2
 * Output: 2
 * 
 * Example 2:
 * Input: nums = [1,2,3], k = 3
 * Output: 2
*/
import java.util.Hashtable;
class Solution {
    public int subarraySum(int[] nums, int k) {
        /*
         * @ Method: Prefix Sum & HashTable
         * @ Sliding Window doesn't work in this problem because of negative values
         * @ Loop Through the array, count the prefix sum
         * @ At the same time, compute k - totalSum and find if there is key in the table
         * @ Add the value of the key in the hashtable
        */
        Hashtable<Integer, Integer> prefixSumTable = new Hashtable<>();
        prefixSumTable.put(0, 1);
        int res = 0;
        int currSum = 0;
        int difference = 0;
        int value = 0;
        for (int num : nums) {
            currSum += num;
            difference = currSum - k;
            if (prefixSumTable.containsKey(difference)) {
                res += prefixSumTable.get(difference);
            }
            if (prefixSumTable.containsKey(currSum)) {
                value = prefixSumTable.get(currSum) + 1;
            } else {
                value = 1;
            }
            prefixSumTable.put(currSum, value);
        }
        return res;
    }
}