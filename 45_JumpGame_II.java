/**
 * 45. Jump Game II
 * 
 * Given an array of non-negative integers nums, you are initially positioned at the first index of the array.
 *
 * Each element in the array represents your maximum jump length at that position.
 * 
 * Your goal is to reach the last index in the minimum number of jumps.
 * 
 * You can assume that you can always reach the last index.
 * 
 * Example 1:
 *
 * Input: nums = [2,3,1,1,4]
 * Output: 2
 * Explanation: The minimum number of jumps to reach the last index is 2. 
 * Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * 
 * Example 2:
 *
 * Input: nums = [2,3,0,1,4]
 * Output: 2
 * 
 */
class Solution {
    public int jump(int[] nums) {
        // Think of the numbers as several intervals, each of which representing a step
        int step = 0;
        int upperBound = 0;
        int lowerBound = 0;
        while (upperBound < nums.length - 1) {
            step++;
            int temp = upperBound;
            for (int i = lowerBound; i <= temp; i++) {
                upperBound = Math.max(upperBound, nums[i] + i);
            }
            lowerBound = temp + 1;
        }
        return step;
        // ----------------------Greedy----------------------------
        // int nextDist = 0;
        // int currDist = 0;
        // int step = 0;
        // for (int i = 0; i < nums.length - 1; i++) { // We only need to go to the position of nums.length - 1
        //     nextDist = Math.max(nextDist, nums[i] + i); // update the next farthest distance
        //     if (i == currDist) {
        //         // When met with the farthest pointer, update it
        //         step++;
        //         currDist = nextDist;
        //     }
        // }
        // return step;
    }
}


