/**
 * 213. House Robber II
 * 
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. 
 * All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. 
 * Meanwhile, adjacent houses have a security system connected, and it will automatically contact the police 
 * if two adjacent houses were broken into on the same night.
 *
 * Given an integer array nums representing the amount of money of each house, return the maximum amount of 
 * money you can rob tonight without alerting the police.
 * 
 * Example 1:
 *
 * Input: nums = [2,3,2]
 * Output: 3
 * Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2), because they are adjacent houses.
 * 
 * Example 2:
 *
 * Input: nums = [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 * Total amount you can rob = 1 + 3 = 4.
 * 
 * Example 3:
 *
 * Input: nums = [1,2,3]
 * Output: 3
 * 
 * Solution: Since the path is a circle, to avoid the first and last in this array to be robbed the same time.
 * We go through two subarrays which seperate out the first and last one out respectively.
 * 
 */
class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        int left = helper(0, nums.length - 2, nums);
        int right = helper(1, nums.length - 1, nums);
        return Math.max(left, right);
    }
    
    private int helper(int start, int end, int[] nums) {
        if (start > end) return 0;
        int len = end - start + 1;
        int[] dp = new int[len];
        if (len == 1) return nums[start];
        if (len == 2) return Math.max(nums[start], nums[end]);
        dp[0] = nums[start];
        dp[1] = Math.max(nums[start], nums[start + 1]);
        for (int i = start + 2; i <= end; i++) {
            dp[i - start] = Math.max(dp[i - start - 1], dp[i - start - 2] + nums[i]);
        }
        return dp[end - start];
    }
}





