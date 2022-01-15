/*
 * 383. Ransom Note
 *
 * Given two stings ransomNote and magazine, return true if ransomNote can be constructed 
 * from magazine and false otherwise.
 *
 * Each letter in magazine can only be used once in ransomNote.
 *
 * Example 1:
 *
 * Input: ransomNote = "a", magazine = "b"
 * Output: false
 *
 * Example 2:
 *
 * Input: ransomNote = "aa", magazine = "ab"
 * Output: false
 *
 * Example 3:
 *
 * Input: ransomNote = "aa", magazine = "aab"
 * Output: true
 *
 * Meyhod1: Use Array with length 26 as the hashtable -- Way more faster
 * Method2: Use Hashtable
 *
 */
import java.util.Hashtable;
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
    	//-------------------------------------Method 1----------------------------
        /*
         * Method: Use array with length 26
         */
        int[] charCount = new int[26];
        for (char c: magazine.toCharArray()) {
            charCount[c - 'a'] += 1;
        }
        for (char c: ransomNote.toCharArray()) {
            if (charCount[c - 'a'] <= 0) {
                return false;
            } else {
                charCount[c - 'a'] -= 1;
            }
        }
        return true;
        
        //-------------------------------------Method 2----------------------------
        /* 
         * Method: Use Hashtable
         */
        Hashtable<Character, Integer> charCount = new Hashtable<>();
        for (char c: magazine.toCharArray()) {
            if (charCount.containsKey(c)) {
                charCount.put(c, charCount.get(c) + 1);
            } else {
                charCount.put(c, 1);
            }
        }
        for (char c: ransomNote.toCharArray()) {
            if (!charCount.containsKey(c)) {
                return false;
            } else if (charCount.get(c) == 0) {
                return false;
            } else {
                charCount.put(c, charCount.get(c) - 1);
            }
        }
        return true;
    }
}

