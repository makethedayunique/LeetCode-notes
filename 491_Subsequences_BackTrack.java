/*
 * 491. Increasing Subsequences
 *
 * Given an integer array nums, return all the different possible increasing subsequences of the given array with 
 * at least two elements. You may return the answer in any order.
 *
 * The given array may contain duplicates, and two equal integers should also be considered a special 
 * case of increasing sequence.
 * 
 * Example 1:
 *
 * Input: nums = [4,6,7,7]
 * Output: [[4,6],[4,6,7],[4,6,7,7],[4,7],[4,7,7],[6,7],[6,7,7],[7,7]]
 *
 * Example 2:
 *
 * Input: nums = [4,4,3,2,1]
 * Output: [[4,4]]
 *
 * Solution: BackTrack, for every node, go through all the nodes after and check condition
 *			 For the nodes satisfying the condition, add it first and backtrack then remove
 *			 In the loop for every backTrack, the nodes are on the same level, so we store int array as "used"
 *			 If a node has been used and this one is the same, then this one will not be used again
 *
 */
class Solution {
    private List<List<Integer>> result = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();
    
    public List<List<Integer>> findSubsequences(int[] nums) {
        backTrack(0, nums);
        return result;
    }
    
    private void backTrack(int index, int[] nums) {
        /*
         * Update the result every node
         */
        if (path.size() > 1) {
            // Insert the path
            result.add(new ArrayList<>(path));
        }
        
        int[] inserted = new int[201]; // number interval : [-100, 100]
        for (int i = index; i < nums.length; i++) {
            if (!path.isEmpty() && nums[i] < path.get(path.size() - 1) || 
                (inserted[100 + nums[i]] == 1)) continue; // inserted or reject the order
            inserted[nums[i] + 100] = 1;
            path.add(nums[i]);
            backTrack(i + 1, nums);
            path.remove(path.size() - 1);
        }
    }
}



