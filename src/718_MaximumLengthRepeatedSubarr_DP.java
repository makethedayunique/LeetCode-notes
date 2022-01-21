/**
 * 718. Maximum Length of Repeated Subarray
 * 
 * Given two integer arrays nums1 and nums2, return the maximum length of a subarray that appears in both arrays.
 * 
 * Example 1:
 *
 * Input: nums1 = [1,2,3,2,1], nums2 = [3,2,1,4,7]
 * Output: 3
 * Explanation: The repeated subarray with maximum length is [3,2,1].
 * 
 * Example 2:
 *
 * Input: nums1 = [0,0,0,0,0], nums2 = [0,0,0,0,0]
 * Output: 5
 *
 * Solution: Use dynamic programming, dp[i][j] indicate the maximum length of repeated subarray 
 * in nums1's subarray with end index i - 1 and nums2's subarray with end index j - 1
 * 
 */
class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        // Subarray here indicate only continuous array
        // ------------------2D-DP------------------------------------------------
        // int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        // int result = 0;
        // for (int i = 1; i <= nums1.length; i++) {
        //     for (int j = 1; j <= nums2.length; j++) {
        //         if (nums1[i - 1] == nums2[j - 1]) dp[i][j] = dp[i - 1][j - 1] + 1;
        //         if (dp[i][j] > result) result = dp[i][j];
        //     }
        // }
        // return result;
        // ------------------1D-DP------------------------------------------------
        int[] dp = new int[nums2.length + 1];
        int result = 0;
        for (int i = 1; i <= nums1.length; i++) {
            for (int j = nums2.length; j > 0; j--) {
                if (nums1[i - 1] == nums2[j - 1]) dp[j] = dp[j - 1] + 1;
                else dp[j] = 0;
                if (dp[j] > result) result = dp[j];
            }
        }
        return result;
    }
}





