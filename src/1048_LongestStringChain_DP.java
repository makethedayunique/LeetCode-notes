/**
 * 1048. Longest String Chain
 * 
 * You are given an array of words where each word consists of lowercase English letters.
 *
 * wordA is a predecessor of wordB if and only if we can insert exactly one letter anywhere in wordA 
 * without changing the order of the other characters to make it equal to wordB.
 *
 * For example, "abc" is a predecessor of "abac", while "cba" is not a predecessor of "bcad".
 * A word chain is a sequence of words [word1, word2, ..., wordk] with k >= 1, where word1 is a predecessor of word2, 
 * word2 is a predecessor of word3, and so on. A single word is trivially a word chain with k == 1.
 * 
 * Return the length of the longest possible word chain with words chosen from the given list of words.
 * 
 * 
 * Example 1:
 *
 * Input: words = ["a","b","ba","bca","bda","bdca"]
 * Output: 4
 * Explanation: One of the longest word chains is ["a","ba","bda","bdca"].
 * 
 * Example 2:
 *
 * Input: words = ["xbc","pcxbcf","xb","cxbc","pcxbc"]
 * Output: 5
 * Explanation: All the words can be put in a word chain ["xb", "xbc", "cxbc", "pcxbc", "pcxbcf"].
 * 
 * Example 3:
 *
 * Input: words = ["abcd","dbqca"]
 * Output: 1
 * Explanation: The trivial word chain ["abcd"] is one of the longest word chains.
 * ["abcd","dbqca"] is not a valid word chain because the ordering of the letters is changed.
 * 
 **/
class Solution {
    public int longestStrChain(String[] words) {
        /**
            Since if word1 is predecessor or word2, word1 must have length of word2's length - 1
            To check the maximum length of word chain ending at wordx, we could try to delete one
            character to see if the word exists in hashmap
            length(word) = max(1, length(word - char) + 1)
        **/
        HashMap<String, Integer> chainLength = new HashMap<>();
        Arrays.sort(words, (a,b)-> a.length()-b.length()); // Sort words based on length
        int result = 0;
        int maxLen = 0;
        for (String word: words) {
            // Try to delete one character from the word and update
            maxLen = 0;
            for (int i = 0; i < word.length(); i++) {
                StringBuilder currWord = new StringBuilder(word);
                maxLen = Math.max(maxLen, chainLength.getOrDefault(currWord.deleteCharAt(i).toString(), 0));
            }
            chainLength.put(word, maxLen+1);
            result = Math.max(result, maxLen+1);
            
            // Another Way to build the new word
            /*
            if (word.length() == 1) {
                chainLength.put(word, 1);
                result = Math.max(1, result);
            } else {
                maxLen = Math.max(maxLen, chainLength.getOrDefault(word.substring(1), 0)); // Remove 1st
                for (int i = 1; i < word.length() - 1; i++) {
                    maxLen = Math.max(maxLen, chainLength.getOrDefault(word.substring(0,i)+word.substring(i+1), 0)); // Remove the middle characters
                }
                maxLen = Math.max(maxLen, chainLength.getOrDefault(word.substring(0,word.length()-1), 0)); // Remove the last character
                
                // Add the word into hashmap
                chainLength.put(word, maxLen+1);
                result = Math.max(result, maxLen+1);
            }
            */
        }
        return result;
    }
} 

