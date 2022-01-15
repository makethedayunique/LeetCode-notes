/**
 * 1005. Maximize Sum Of Array After K Negations
 * 
 * Given an integer array nums and an integer k, modify the array in the following way:
 *
 * choose an index i and replace nums[i] with -nums[i].
 * You should apply this process exactly k times. You may choose the same index i multiple times.
 *
 * Return the largest possible sum of the array after modifying it in this way.
 * 
 * Example 1:
 *
 * Input: nums = [4,2,3], k = 1
 * Output: 5
 * Explanation: Choose index 1 and nums becomes [4,-2,3].
 * 
 * Example 2:
 *
 * Input: nums = [3,-1,0,2], k = 3
 * Output: 6
 * Explanation: Choose indices (1, 2, 2) and nums becomes [3,1,0,2].
 * 
 */
class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        // Use sort two times
        Arrays.sort(nums);
        int index = 0;
        while (index < nums.length && nums[index] < 0 && k > 0) {
            nums[index] = -1 * nums[index];
            index++;
            k--;
        }
        int res = 0;
        for (int num: nums) res += num;

        if (k % 2 != 0) {
            Arrays.sort(nums);
            res -= (2 * nums[0]);
        }
        
        return res;
        // -----------------Sort-by-the-absolute-value-----------------
//         nums = IntStream.of(nums)
//         .boxed()
//         .sorted((o1, o2) -> Math.abs(o1) - Math.abs(o2))
//         .mapToInt(Integer::intValue).toArray();
        
//         int res = 0;
//         for (int i = nums.length - 1; i >= 0; i--) {
//             if (nums[i] < 0 && k > 0) {
//                 nums[i] *= -1;
//                 res += nums[i];
//                 k--;
//             } else {
//                 res += nums[i];
//             }
//         }
//         if (k % 2 != 0) res -= (2 * nums[0]);
//         return res;
    }
}


