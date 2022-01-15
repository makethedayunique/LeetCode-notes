/**
 * 376. Wiggle Subsequence
 * A wiggle sequence is a sequence where the differences between successive numbers strictly alternate between 
 * positive and negative. The first difference (if one exists) may be either positive or negative. 
 * A sequence with one element and a sequence with two non-equal elements are trivially wiggle sequences.
 *
 * For example, [1, 7, 4, 9, 2, 5] is a wiggle sequence because the differences (6, -3, 5, -7, 3) alternate 
 * between positive and negative.
 * 
 * In contrast, [1, 4, 7, 2, 5] and [1, 7, 4, 5, 5] are not wiggle sequences. The first is not because its first 
 * two differences are positive, and the second is not because its last difference is zero.
 * 
 * A subsequence is obtained by deleting some elements (possibly zero) from the original sequence, leaving the remaining elements in their original order.
 * 
 * Given an integer array nums, return the length of the longest wiggle subsequence of nums.
 * 
 * Example 1:
 *
 * Input: nums = [1,7,4,9,2,5]
 * Output: 6
 * Explanation: The entire sequence is a wiggle sequence with differences (6, -3, 5, -7, 3).
 * 
 * Example 2:
 *
 * Input: nums = [1,17,5,10,13,15,10,5,16,8]
 * Output: 7
 * Explanation: There are several subsequences that achieve this length.
 * One is [1, 17, 10, 13, 10, 16, 8] with differences (16, -7, 3, -3, 6, -8).
 * 
 */
class Solution {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        // ------------------Greedy-ALgo-------------------------
        // int preDiff = 0;
        // int curDiff = 0;
        // int result = 1; // Default to be 1, because we only compute the difference between two numbers
        // for (int i = 0; i < nums.length - 1; i++) {
        //     curDiff = nums[i + 1] - nums[i];
        //     if ((curDiff > 0 && preDiff <= 0) || (curDiff < 0 && preDiff >= 0)) {
        //         result++;
        //         preDiff = curDiff;
        //     }
        // }
        // return result;
        // ----------------linear-DP------------------------------
        // int[] up = new int[nums.length];
        // int[] down = new int[nums.length];
        // for (int i = 1; i < nums.length; i++) {
        //     if (nums[i] - nums[i - 1] > 0) {
        //         up[i] = down[i - 1] + 1;
        //         down[i] = down[i - 1];
        //     } else if (nums[i] - nums[i - 1] < 0) {
        //         down[i] = up[i - 1] + 1;
        //         up[i] = up[i - 1];
        //     } else {
        //         up[i] = up[i - 1];
        //         down[i] = down[i - 1];
        //     }
        // }
        // return 1 + Math.max(up[nums.length - 1], down[nums.length - 1]);
        // ------------Optimized-space-DP---------------------------
        int up = 1;
        int down =1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                up = down + 1;
            } else if (nums[i] < nums[i - 1]) {
                down = up + 1;
            }
        }
        return Math.max(up, down);
    }
}



