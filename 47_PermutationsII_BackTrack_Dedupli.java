/*
 * 47. Permutations II
 *
 * Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.
 *
 * Example 1:
 *
 * Input: nums = [1,1,2]
 * Output:
 * [[1,1,2],
 *  [1,2,1],
 *  [2,1,1]]
 *
 * Solution: BackTrack and deduplicates. Attention: Sort the array first, then check if the previous used if its the same
 *			 If the previous is not used, which means it is used in the same level as this node, so skip the node
 *
 */
class Solution {
    private List<List<Integer>> result = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();
    
    public List<List<Integer>> permuteUnique(int[] nums) {
        int[] used = new int[nums.length];
        // ----------------------Point-1-Sort-first-------------------------------
        Arrays.sort(nums); // When related to deduplication, sort the array first
        backTrack(nums, used);
        return result;
    }
    
    private void backTrack(int[] nums, int[] used) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<Integer>(path));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
        	//-------------------Point-2-If-previous-equals-false----------------
            if (i > 0 && nums[i] == nums[i - 1] && used[i - 1] == 0) continue;
            if (used[i] == 1) continue;
            used[i] = 1;
            path.add(nums[i]);
            backTrack(nums, used);
            path.remove(path.size() - 1);
            used[i] = 0;
        }
    }
}



