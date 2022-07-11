/**
 * 1477. Find Two Non-overlapping Sub-arrays Each With Target Sum
 * 
 * You are given an array of integers arr and an integer target.
 *
 * You have to find two non-overlapping sub-arrays of arr each with a sum equal target. 
 * There can be multiple answers so you have to find an answer where the sum of the lengths of the two sub-arrays is minimum.
 *
 * Return the minimum sum of the lengths of the two required sub-arrays, or return -1 if you cannot find such two sub-arrays.
 * 
 * Example 1:
 *
 * Input: arr = [3,2,2,4,3], target = 3
 * Output: 2
 * Explanation: Only two sub-arrays have sum = 3 ([3] and [3]). The sum of their lengths is 2.
 * 
 * Example 2:
 *
 * Input: arr = [7,3,4,7], target = 7
 * Output: 2
 * Explanation: Although we have three non-overlapping sub-arrays of sum = 7 ([7], [3,4] and [7]), 
 * but we will choose the first and third sub-arrays as the sum of their lengths is 2.
 * 
 * Example 3:
 *
 * Input: arr = [4,3,2,6,2,3,4], target = 6
 * Output: -1
 * Explanation: We have only one sub-array of sum = 6.
 * 
 * Solution: Use two pointers to iterate through the array to find all the sub arrays
 * During the same time, use a memory array to store previous minimum length of the subarray ending at certain index.
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * 
 **/
class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int left = 0;
        int right = 0;
        int currSum = arr[0];
        /** Use the memory array to store the previous length **/
        int[] memory = new int[arr.length]; // memory[i] represents minimum length ending before index i
        Arrays.fill(memory, Integer.MAX_VALUE);
        
        int result = Integer.MAX_VALUE;
        
        while (right < arr.length) {
            if (currSum > target) {
                currSum -= arr[left];
                left++;
                continue;
            }
            if (currSum == target) {
                memory[right] = Math.min(right > 0 ? memory[right-1] : Integer.MAX_VALUE, right-left+1);
                if (left > 0 && memory[left-1] != Integer.MAX_VALUE) result = Math.min(result, memory[left-1]+right-left+1);
                right++;
                if (right < arr.length) {
                    currSum += arr[right];
                }
                continue;
            }
            memory[right] = right > 0 ? memory[right-1] : Integer.MAX_VALUE;
            right++;
            if (right < arr.length) {
                currSum += arr[right];
            }
        }
        
        
        /** Time Limit Exceed
        for (int i = 0; i < subarrays.size()-1; i++) {
            for (int j = i+1; j < subarrays.size(); j++) {
                int[] sub1 = subarrays.get(i);
                int[] sub2 = subarrays.get(j);
                if (sub1[1] >= sub2[0]) {
                    continue;
                }
                result = Math.min(result, sub1[1]-sub1[0]+sub2[1]-sub2[0]+2);
            }
        }
        **/
        return result == Integer.MAX_VALUE?-1:result;
    }
}


 