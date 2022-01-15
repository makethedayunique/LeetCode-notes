/*
 * 239. Sliding Window Maximum
 *
 * You are given an array of integers nums, there is a sliding window of size k 
 * which is moving from the very left of the array to the very right. 
 * You can only see the k numbers in the window. 
 * Each time the sliding window moves right by one position.
 *
 * Return the max sliding window.
 *
 * Example 1:
 *
 * Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
 * Output: [3,3,5,5,6,7]
 * Explanation: 
 * Window position                Max
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 *
 * Solution: Use Monotonic Queue
 *
 */
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        /*
         * Solution: Sliding Window
         * Maintain a deque in which the first is always the largest one in the previous k nums
         * Indexes are maintained in order to get rid of the number which has been out of k
         * After updating the deque, add the first value to the result array
         *
         * Since every number will be inserted and poped out the deque only once
         * The time complexity will be O(n)
         *
         */
        int[] result = new int[nums.length - k + 1];
        Deque<Integer> sliding = new LinkedList<>();
        int index = 0;
        while (index < nums.length) {
            if (index < k) {
                while (!sliding.isEmpty() && nums[sliding.peekLast()] < nums[index]) {
                    sliding.pollLast();
                }
                sliding.offerLast(index);
                if (index == k - 1) {
                    result[index - k + 1] = nums[sliding.peekFirst()];
                }
            } else {
                if (sliding.peekFirst() <= index - k) {
                    sliding.pollFirst();
                }
                while (!sliding.isEmpty() && nums[sliding.peekLast()] < nums[index]) {
                    sliding.pollLast();
                }
                sliding.offerLast(index);
                result[index - k + 1] = nums[sliding.peekFirst()];
            }
            index++;
        }
        return result;
    }
}


