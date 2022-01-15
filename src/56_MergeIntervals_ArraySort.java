/*
 * 56. Merge Intervals
 *
 * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, 
 * and return an array of the non-overlapping intervals that cover all the intervals in the input.
 *
 * Example 1:
 *
 * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 *
 * Example 2:
 *
 * Input: intervals = [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 *
 * 
 */
class Solution {
    public int[][] merge(int[][] intervals) {
        ArrayList<int[]> result = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);  // Lambda expression
        // Or
        // Arrays.sort(intervals, Integer.compare(a[0], b[0]));
        int index = 0;
        while (index < intervals.length) {
            int start = intervals[index][0];
            int end = intervals[index][1];
            index++;
            while (index < intervals.length && intervals[index][0] <= end) {
                end = Math.max(end, intervals[index][1]);
                index++;
            }
            int[] pair = {start, end};
            result.add(pair);
        }
        return result.toArray(new int[result.size()][]);
    }
}