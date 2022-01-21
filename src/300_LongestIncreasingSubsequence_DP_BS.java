/**
 * 300. Longest Increasing Subsequence
 * 
 * Given an integer array nums, return the length of the longest strictly increasing subsequence.
 *
 * A subsequence is a sequence that can be derived from an array by deleting some or no elements without 
 * changing the order of the remaining elements. For example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7].
 * 
 * Example 1:
 *
 * Input: nums = [10,9,2,5,3,7,101,18]
 * Output: 4
 * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
 * 
 * Example 2:
 *
 * Input: nums = [0,1,0,3,2,3]
 * Output: 4
 * 
 * Example 3:
 *
 * Input: nums = [7,7,7,7,7,7,7]
 * Output: 1
 *
 * Solution: DP or Binary Search
 * 
 */
class Solution {
    public int lengthOfLIS(int[] nums) {
        // --------------Dynamic-Programming--------------------------
        // int[] dp = new int[nums.length];
        // dp[0] = 1;
        // int result = 1;
        // for (int i = 1; i < nums.length; i++) {
        //     int temp = 1;
        //     for (int j = 0; j < i; j++) {
        //         if (nums[i] > nums[j]) temp = Math.max(temp, dp[j] + 1);
        //     }
        //     dp[i] = temp;
        //     if (temp > result) result = temp;
        // }
        // return result;
        // ------------Binary-Search-------------------------------------------
        // piles[i] represents the smallest tail in all increasing subsequences with length i
        //
    	/**
    	 * Use an example: nums = [10,9,2,5,3,7,101,18], piles = [0,0,0,0,0,0,0,0], 
    	 * size = 0
    	 * num: 10, after BS, piles = [10,0,0,0,0,0,0,0], l = size,  size = 1;
    	 * num: 9,  after BS, piles = [9,0,0,0,0,0,0,0],  l != size, size = 1;
    	 * num: 2,  after BS, piles = [2,0,0,0,0,0,0,0],  l != size, size = 1;
    	 * num: 5,  after BS, piles = [2,5,0,0,0,0,0,0],  l = size,  size = 2;
    	 * num: 3,  after BS, piles = [2,3,0,0,0,0,0,0],  l != size, size = 2;
    	 * num: 7,  after BS, piles = [2,3,7,0,0,0,0,0],  l = size,  size = 3;
    	 * num: 101,after BS, piles = [2,3,7,101,0,0,0,0],l = size,  size = 4;
    	 * num: 18, after BS, piles = [2,3,7,18,0,0,0,0], l != size, size = 4;
    	 * return 4;
    	 */
        int[] piles = new int[nums.length];
        int size = 0;
        for (int num: nums) {
            int l = 0; int r = size;
            while (l < r) {
                int m = l + (r - l) / 2;
                if (piles[m] < num) {
                    l = m + 1;
                } else {
                    r = m;
                }
            }
            piles[l] = num;
            if (l == size) size++;
        }
        return size;
    }
}





