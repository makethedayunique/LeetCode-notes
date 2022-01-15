/*
 * 15. 3Sum
 * 
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] 
 * such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 *
 * Notice that the solution set must not contain duplicate triplets.
 *
 * Example 1:
 *
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 *
 * Example 2:
 *
 * Input: nums = []
 * Output: []
 *
 * Method: two pointers
 *
*/
// --------------------------Method---------------------------
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        /*
         * Two pointers method
        */
        List<List<Integer>> result = new ArrayList<>();
        
        if (nums.length < 3) {
            return result;
        }
        // Make the array numbers to be in ascending order
        Arrays.sort(nums);
        
        int left = 0;
        int right = 0;
        int sum = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            // If the value is greater than 0, just return
            if (nums[i] > 0) {
                return result;
            }
            // Avoid the same combination
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            
            left = i + 1;
            right = nums.length - 1;
            while (left < right) {
                sum = nums[left] + nums[right] + nums[i];
                if (sum > 0) {
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // Avoid the duplicated combination
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    // If there is one combination to be 0
                    // Then we move left and right pointers to the center
                    left++;
                    right--;
                }
            }
        }
        return result;
    }
}


