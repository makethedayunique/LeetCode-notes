/*
 * 46. Permutations
 *
 * Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
 *
 * Example 1:
 *
 * Input: nums = [1,2,3]
 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 *
 * Example 2:
 *
 * Input: nums = [0,1]
 * Output: [[0,1],[1,0]]
 *
 * Example 3:
 *
 * Input: nums = [1]
 * Output: [[1]]
 * 
 * Solution: BackTrack, use an array to maintain the visited status of the numbers
 *
 */
class Solution {
    private List<List<Integer>> result = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();
    
    public List<List<Integer>> permute(int[] nums) {
        int[] used = new int[nums.length];
        backTrack(used, nums);
        return result;
    }
    
    private void backTrack(int[] used, int[] nums) {
        if (path.size() == nums.length) {
            // Reach a combination
            result.add(new ArrayList<>(path));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (used[i] == 1) continue;
            used[i] = 1;
            path.add(nums[i]);
            backTrack(used, nums);
            path.remove(path.size() - 1);
            used[i] = 0;
        }
    }
}



