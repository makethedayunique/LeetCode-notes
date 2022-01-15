/**
 * 494. Target Sum
 * 
 * You are given an integer array nums and an integer target.
 *
 * You want to build an expression out of nums by adding one of the symbols '+' and '-' before each integer 
 * in nums and then concatenate all the integers.
 *
 * For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1 and concatenate them 
 * to build the expression "+2-1".
 * Return the number of different expressions that you can build, which evaluates to target.
 * 
 * Example 1:
 *
 * Input: nums = [1,1,1,1,1], target = 3
 * Output: 5
 * Explanation: There are 5 ways to assign symbols to make the sum of nums be target 3.
 * -1 + 1 + 1 + 1 + 1 = 3
 * +1 - 1 + 1 + 1 + 1 = 3
 * +1 + 1 - 1 + 1 + 1 = 3
 * +1 + 1 + 1 - 1 + 1 = 3
 * +1 + 1 + 1 + 1 - 1 = 3
 * 
 * Example 2:
 *
 * Input: nums = [1], target = 1
 * Output: 1
 * 
 * Solution: think of the question as the 01BP problem
 */
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num: nums) sum += num;
        if (target > sum || target < -1 * sum) return 0;
        int[][] dp = new int[nums.length][2 * sum + 1];
        // Initialize array when i, j = 0
        dp[0][nums[0] + sum]++;
        dp[0][-1 * nums[0] + sum]++;
        // Start traversal
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j <= 2 * sum; j++) { 
                if (j >= nums[i]) dp[i][j] += dp[i - 1][j - nums[i]];
                if (j <= 2 * sum - nums[i]) dp[i][j] += dp[i - 1][j + nums[i]];
                // We can also start from -sum to sum, then we can add nums[i] to the sum if dp[i-1][j+sum] > 0
                // if (dp[i - 1][j + sum] > 0) {
                // 	dp[i][j + nums[i] + sum] += dp[i - 1][j + sum];
                // 	dp[i][j - nums[i] + sum] += dp[i - 1][j + sum];
                // }
            }
        }
        return dp[nums.length - 1][target + sum];
    }
}
/**
 * We can also build hashmap with sum and frequency by iterating all the numbers one by one
 * 
 */


