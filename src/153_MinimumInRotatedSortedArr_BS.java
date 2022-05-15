/**
 * 153. Find Minimum in Rotated Sorted Array
 * 
 * Suppose an array of length n sorted in ascending order is rotated between 1 and n times. 
 * For example, the array nums = [0,1,2,4,5,6,7] might become:
 *
 * [4,5,6,7,0,1,2] if it was rotated 4 times.
 * [0,1,2,4,5,6,7] if it was rotated 7 times.
 * Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array 
 * [a[n-1], a[0], a[1], a[2], ..., a[n-2]].
 *
 * Given the sorted rotated array nums of unique elements, return the minimum element of this array.
 *
 * You must write an algorithm that runs in O(log n) time.
 * 
 * Example 1:
 *
 * Input: nums = [3,4,5,1,2]
 * Output: 1
 * Explanation: The original array was [1,2,3,4,5] rotated 3 times.
 * 
 * Example 2:
 * 
 * Input: nums = [4,5,6,7,0,1,2]
 * Output: 0
 * Explanation: The original array was [0,1,2,4,5,6,7] and it was rotated 4 times.
 * 
 * Solution: Use binary search
 *
 */
class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        // ------------------------Method1----------------------------------------
        /**
        // If the tail element is greater than the head element, then it is not rotated
        if (nums[l] <= nums[r]) {
            return nums[l];
        }
        while (l <= r) {
            // When we try to find the point, there might be two conditions
            int mid = l + (r - l) / 2;
            if (nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            }
            if (nums[mid] < nums[mid - 1]) {
                return nums[mid];
            }
            // If the middle number is greater than the leftmost node, then the point is to the right
            // Else the point is to the left
            if (nums[mid] > nums[0]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
        */
        // ------------------------Method2----------------------------------------
        while (nums[l] > nums[r]) {
            // When the left number is smaller than right number
            int mid = l + (r - l) / 2;
            if (nums[mid] > nums[r]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return nums[l];
    }
}



