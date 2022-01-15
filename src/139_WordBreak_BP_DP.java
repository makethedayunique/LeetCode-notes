/**
 * 139. Word Break
 * 
 * Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated 
 * sequence of one or more dictionary words.
 *
 * Note that the same word in the dictionary may be reused multiple times in the segmentation.
 * 
 * 
 * Example 1:
 *
 * Input: s = "leetcode", wordDict = ["leet","code"]
 * Output: true
 * Explanation: Return true because "leetcode" can be segmented as "leet code".
 * 
 * Example 2:
 *
 * Input: s = "applepenapple", wordDict = ["apple","pen"]
 * Output: true
 * Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
 * Note that you are allowed to reuse a dictionary word.
 * 
 * Example 3:
 *
 * Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
 * Output: false
 * 
 * Solution: backPack Problem, since all the words can be used for multiple times, it's a multiple BP problem.
 * Think of all the words in the dictionary as items.
 * 
 */
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        Arrays.fill(dp, false);
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < wordDict.size(); j++) {
                String word = wordDict.get(j);
                if (i >= word.length() && s.substring(i - word.length(), i).equals(word))  {
                    dp[i] = (dp[i - word.length()] && true) || dp[i];
                }
            }
        }
        return dp[s.length()];
    }
}




