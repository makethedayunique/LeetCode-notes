/**
 * 418. Sentence Screen Fitting
 * 
 * Given a rows x cols screen and a sentence represented as a list of strings, 
 * return the number of times the given sentence can be fitted on the screen.
 *
 * The order of words in the sentence must remain unchanged, and a word cannot be split into two lines. 
 * A single space must separate two consecutive words in a line.
 * 
 * Example 1:
 *
 * Input: sentence = ["hello","world"], rows = 2, cols = 8
 * Output: 1
 * Explanation:
 * hello---
 * world---
 * The character '-' signifies an empty space on the screen.
 * 
 * Example 2:
 *
 * Input: sentence = ["a", "bcd", "e"], rows = 3, cols = 6
 * Output: 2
 * Explanation:
 * a-bcd- 
 * e-a---
 * bcd-e-
 * The character '-' signifies an empty space on the screen.
 * 
 * Solution: We could simulate the filling as rows grow. But in fact it will cause time limit exceed issue.
 * One way to optimize is that we could use a memory array to store number of words in the row starting with a 
 * certain word. Then for every new row, we just check if the leading word is in the array, if so, we just use
 * the stored value as the number of words and update.
 * 
 **/
class Solution {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        if (sentence[0].length() > cols) {
            return 0;
        }
        int result = 0;
        
        int wordIdx = 0;
        int currRow = 0;
        int currLeft = cols;
        
        // Store the number of words could be stored on the current row
        int[] memory = new int[sentence.length];
        
        int firstWordIdx = 0; // First word index
        int cumulatedWords = 0; // Maintain the cumulated word starting with first word
        
        while (currRow < rows) {
            wordIdx = wordIdx % sentence.length;
            int required = sentence[wordIdx].length();
            if (currLeft == cols) {
                // New line
                firstWordIdx = wordIdx; // Update the first word
                cumulatedWords = 0; // Clear the cumulated count
                if (memory[firstWordIdx] > 0) {
                    int container = memory[firstWordIdx];
                    if (container >= sentence.length - wordIdx) {
                        result += 1;
                        result += ((container - sentence.length + wordIdx) / sentence.length);
                    }
                    wordIdx += memory[firstWordIdx] % sentence.length;
                    currRow += 1;
                    currLeft = cols;
                    continue;
                }
            }
            if (currLeft < cols) {
                // Not new line
                required += 1;
            }
            if (required <= currLeft) {
                cumulatedWords++;
                wordIdx++;
                currLeft -= required;
                // After successfully fit in, check if update the result
                if (wordIdx == sentence.length) result++;
            } else {
                memory[firstWordIdx] = cumulatedWords; // Store in memory
                currRow += 1;
                currLeft = cols;
            }
        }
        
        return result;
    }
}


 