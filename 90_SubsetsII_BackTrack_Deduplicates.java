/*
 * 90. Subsets II
 *
 * Given an integer array nums that may contain duplicates, return all possible subsets (the power set).
 *
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 *
 * Example 1:
 *
 * Input: nums = [1,2,2]
 * Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
 *
 * Example 2:
 *
 * Input: nums = [0]
 * Output: [[],[0]]
 *
 * Solution: To make no duplicate in the same level, we need to sort the numbers first so that same numbers
 *           are next to each other. Then we need to maintain an array recording if the previous value is added
 *           If the previous value is the same and not inserted, this one should not be inserted, or there will
 *           be duplicated combinations.
 *
 */
class Solution {
    private List<List<Integer>> result = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();
    private int[] visited;
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        visited = new int[nums.length];
        Arrays.sort(nums); // This step is very important
        backTrack(0, nums);
        return result;
    }
    
    private void backTrack(int index, int[] nums) {
        if (index == nums.length) {
            List<Integer> temp = new ArrayList<>();
            for (int num: path) { temp.add(num); }
            result.add(temp);
            return;
        }
        if (index > 0 && nums[index] == nums[index - 1] && visited[index - 1] == 0) {
            backTrack(index + 1, nums);
        } else {
            path.add(nums[index]);
            visited[index] = 1;
            backTrack(index + 1, nums);
            path.remove(path.size() - 1);
            visited[index] = 0;

            backTrack(index + 1, nums);
        }
    }
}



