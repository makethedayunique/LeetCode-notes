/*
 * 77. Combinations
 *
 * Given two integers n and k, return all possible combinations of k numbers out of the range [1, n].
 *
 * You may return the answer in any order.
 *
 * Example 1:
 *
 * Input: n = 4, k = 2
 * Output:
 * [[2,4],[3,4],[2,3],[1,2],[1,3],[1,4],]
 *
 * Example 2:
 *
 * Input: n = 1, k = 1
 * Output: [[1]]
 *
 * Solution: Typical BackTrack method
 *
 */
class Solution {
    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();
    
    public List<List<Integer>> combine(int n, int k) {
        backTracking(1, n, k);
        return res;
    }
    
    private void backTracking(int s, int n, int k) {
        if (k == 0) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int num: path) { temp.add(num); }
            res.add(temp);
            return;
        }
        for (int i = s; i <= n - k + 1; i++) {
            path.add(i);
            backTracking(i + 1, n, k - 1);
            path.remove(path.size() - 1);
        }
    }
}



