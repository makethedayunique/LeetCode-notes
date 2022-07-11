/**
 * 792. Number of Matching Subsequences
 * 
 * Given a string s and an array of strings words, return the number of words[i] that is a subsequence of s.
 *
 * A subsequence of a string is a new string generated from the original string with some characters (can be none) 
 * deleted without changing the relative order of the remaining characters.
 *
 * For example, "ace" is a subsequence of "abcde".
 * 
 * Example 1:
 *
 * Input: s = "abcde", words = ["a","bb","acd","ace"]
 * Output: 3
 * Explanation: There are three strings in words that are a subsequence of s: "a", "acd", "ace".
 * 
 * Example 2:
 *
 * Input: s = "dsahjpjauf", words = ["ahjpjau","ja","ahbwzgqnuk","tnmlanowax"]
 * Output: 2
 * 
 * Solution:
 * 1 - If we use brute force method, we need to go through the string one time for every word in the words array.
 *     Time complexity would be O(words.length * S.length + Sum(words[i].length))
 * 2 - We store the word in buckets with each word starting with a single letter and the rest of them. WHen we go through the 
 * 	   string, we keep update the letter buckets. If there is any word comes to the end, then it could be counted as one valid substring.
 **/
class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        /**
        Make an array of 26 starting letter. Each element is related to a list of 
        remaining strings starting with that letter. Go through the original long
        string only once and continuously update the letter array
        **/
        ArrayList<String>[] letters = new ArrayList[26]; // Each letter each one
        int result = 0; // Number of substrings to return
        // Populate the words string
        for (int i = 0; i < 26; i++) {
            letters[i] = new ArrayList<>();
        }
        for (String word:words) {
            letters[word.charAt(0) - 'a'].add(word.substring(1));
        }
        // Iterate through the string s
        ArrayList<String> temp;
        for (int i = 0; i < s.length(); i++) {
            char currChar = s.charAt(i);
            temp = letters[currChar-'a'];
            int stringSize = temp.size();
            while (stringSize > 0) {
                if (temp.get(0).equals("")) {
                    result += 1;
                } else {
                    // Add the new one
                    letters[temp.get(0).charAt(0) - 'a'].add(temp.get(0).substring(1));
                }
                // Remove the first element
                temp.remove(0);
                stringSize--;
            }
        }
        return result;
    }
}



 