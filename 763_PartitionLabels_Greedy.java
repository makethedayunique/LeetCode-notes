/**
 * 763. Partition Labels
 * 
 * You are given a string s. We want to partition the string into as many parts as possible 
 * so that each letter appears in at most one part.
 *
 * Return a list of integers representing the size of these parts.
 * 
 * Example 1:
 *
 * Input: s = "ababcbacadefegdehijhklij"
 * Output: [9,7,8]
 * Explanation:
 * The partition is "ababcbaca", "defegde", "hijhklij".
 * This is a partition so that each letter appears in at most one part.
 * A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits s into less parts.
 * 
 * Example 2:
 *
 * Input: s = "eccbbbbdec"
 * Output: [10]
 * 
 * Solution: find the last position of every letter, and loop again to find the result
 * 
 */
class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] lastPos = new int[26];
        for (int i = 0; i < s.length(); i++) {
            lastPos[s.charAt(i) - 'a'] = i;
        }
        int last = 0;
        ArrayList<Integer> result = new ArrayList<>(s.length());
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            last = Math.max(last, lastPos[s.charAt(i) - 'a']);
            if (i < last) {
                count++;
            } else {
                count++;
                result.add(count);
                count = 0;
            }
        }
        return result;
    }
}




