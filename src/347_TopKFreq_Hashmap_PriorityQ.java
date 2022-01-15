/*
 * 347. Top K Frequent Elements
 *
 * Given an integer array nums and an integer k, return the k most frequent elements. 
 * You may return the answer in any order.
 *
 * Example 1:
 *
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 *
 * Example 2:
 * 
 * Input: nums = [1], k = 1
 * Output: [1]
 *
 * Solution: Use a HashMap to count the frequency, then use priority queue to store the K largest numbers
 *
 */
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        /*
         * Use a hashmap to count the frequency
         * Use a priority queue to store the maintain k numbers with highest frequency
         * Inside the priority queue is a min heap
         */
        //-----------------------Common-Step------------------------
        // Count the frequency
        HashMap<Integer, Integer> numCount = new HashMap<>();
        for (int num: nums) {
            numCount.put(num, numCount.getOrDefault(num, 0) + 1);
        }
        // Put into a min heap
        // Numbers with lowest frequency will be put to the top
        //-----------------------Try-map-entry---------------------
        Set<Map.Entry<Integer, Integer>> entries = numCount.entrySet();
        Queue<Map.Entry<Integer, Integer>> que = new PriorityQueue<>(
                (e1, e2) -> e1.getValue() - e2.getValue());
        for (Map.Entry<Integer, Integer> entry: entries) {
            que.offer(entry);
            if (que.size() > k) {
                que.poll();
            }
        }
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = que.poll().getKey();
        }
        return result;
        
        //-----------------------Try-original----------------------
        Queue<Integer> que = new PriorityQueue<>(
            (o1, o2) -> numCount.get(o1) - numCount.get(o2));
        for (int num: numCount.keySet()) {
            que.offer(num);
            if (que.size() > k) {
                que.poll();
            }
        }
        // Only maintain k numbers with highest frequency
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = que.poll();
        }
        return result;
    }
}