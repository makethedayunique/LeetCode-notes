/**
 * 318. Maximum Product of Word Lengths
 * 
 * Given a string array words, return the maximum value of length(word[i]) * length(word[j]) where the two words do not share common letters. 
 * If no such two words exist, return 0.
 * 
 * Example 1:
 *
 * Input: words = ["abcw","baz","foo","bar","xtfn","abcdef"]
 * Output: 16
 * Explanation: The two words can be "abcw", "xtfn".
 * 
 * Example 2:
 *
 * Input: words = ["a","ab","abc","d","cd","bcd","abcd"]
 * Output: 4
 * Explanation: The two words can be "ab", "cd".
 * 
 * Solution: Precompute the letter count using hashmap or bit mask(Use lower 26 bits in an integer to maintain letter existance.
 * Use & to check if there is common letter between two words. 
 * Compare each pair of word in the array.
 * Both time complexity are O(n^2)
 **/
class Solution {
    public int maxProduct(String[] words) {
        /** Use the hashset here **/
        // int[][] letterCount = new int[words.length][26];
        // for (int i = 0; i < words.length; i++) {
        //     String word = words[i];
        //     for (int j = 0; j < word.length(); j++) {
        //         letterCount[i][word.charAt(j) - 'a']++;
        //     }
        // }
        /** We could use bit manipulation to calculate which is faster **/
        int[] letterMask = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            for (int j = 0; j < word.length(); j++) {
                letterMask[i] = letterMask[i] | (1 << (word.charAt(j) - 'a'));
            }
        }
        
        int result = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i+1; j < words.length; j++) {
                // if (haveCommon(letterCount[i], letterCount[j])) {
                if ((letterMask[i] & letterMask[j]) != 0) {
                    continue;
                } else {
                    result = Math.max(result, words[i].length() * words[j].length());
                }
            }
        }
        return result;
    }
    
    private boolean haveCommon(int[] word1, int[] word2) {
        for (int i = 0 ; i < 26; i++) {
            if (word1[i] > 0 && word2[i] > 0) {
                return true;
            }
        }
        return false;
    }
}



