/**
 * 1461. Check If a String Contains All Binary Codes of Size K
 * 
 * Given a binary string s and an integer k, return true if every binary code of length k is a substring of s. Otherwise, return false.
 * 
 * Example 1:
 *
 * Input: s = "00110110", k = 2
 * Output: true
 * Explanation: The binary codes of length 2 are "00", "01", "10" and "11". 
 * They can be all found as substrings at indices 0, 1, 3 and 2 respectively.
 * 
 * Example 2:
 *
 * Input: s = "0110", k = 1
 * Output: true
 * Explanation: The binary codes of length 1 are "0" and "1", it is clear that both exist as a substring. 
 * 
 * Example 3:
 *
 * Input: s = "0110", k = 2
 * Output: false
 * Explanation: The binary code "00" is of length 2 and does not exist in the array.
 * 
 * Solution: Use rolling window to iterate through the whole string. Update the current number.
 * 
 **/
class Solution {
    public boolean hasAllCodes(String s, int k) {
        if (s.length() <= k) {
            return false;
        }
        
        HashSet<Integer> distinctValues = new HashSet<Integer>();
        
        int maximum = (int)Math.pow(2.0, Double.valueOf(k-1));
        int correct = (int)Math.pow(2.0, Double.valueOf(k));
        int curr = s.charAt(0) - '0';
        int hsb = 0;
        for (int i = 1; i < k; i++) {
            curr = curr * 2 + (s.charAt(i) - '0');
        }
        distinctValues.add(curr);
        // Start iterating
        for (int i = k; i < s.length(); i++) {
            curr -= (s.charAt(hsb) - '0') * maximum;
            curr *= 2;
            curr += (s.charAt(i) - '0');
            distinctValues.add(curr);
            hsb++;
        }
        // Check
        if (distinctValues.size() == correct) {
            return true;
        } else {
            return false;
        }
    }
}



 