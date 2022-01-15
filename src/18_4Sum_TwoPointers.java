/*
 * 18. 4Sum
 * 
 * Given an array nums of n integers, return an array of all the unique quadruplets 
 * [nums[a], nums[b], nums[c], nums[d]] such that:
 *
 * 0 <= a, b, c, d < n
 * - a, b, c, and d are distinct.
 * - nums[a] + nums[b] + nums[c] + nums[d] == target
 * - You may return the answer in any order.
 * Example 1:
 *
 * Input: nums = [1,0,-1,0,-2,2], target = 0
 * Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 *
 * Example 2:
 *
 * Input: nums = [2,2,2,2,2], target = 8
 * Output: [[2,2,2,2]]
 *
 * Method: Two Pointers
 *
 * In 3Sum problem, use one outer loop and two pointers
 * In 4Sum problem, use two outer loop and two pointers
 * In 5Sum, 6Sum, ...
 *
*/
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        /*
         * Solution: Two pointers
        */
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 4) {
            return result;
        }
        // Sort the array first
        Arrays.sort(nums);
        // Define some variables
        int left = 0;
        int right = 0;
        int sum = 0;
        // Use two loops outside
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                left = j + 1;
                right = nums.length - 1;
                while (left < right) {
                    sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum > target) {
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        
                        while (left < right && nums[left] == nums[left + 1]) left++;
                        while (left < right && nums[right] == nums[right - 1]) right--;
                        
                        left++;
                        right--;
                    }
                }
            }
        }
        return result;
    }
}



