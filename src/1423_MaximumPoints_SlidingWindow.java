/**
 * 1423. Maximum Points You Can Obtain from Cards
 * 
 * There are several cards arranged in a row, and each card has an associated number of points. 
 * The points are given in the integer array cardPoints.
 *
 * In one step, you can take one card from the beginning or from the end of the row. You have to take exactly k cards.
 *
 * Your score is the sum of the points of the cards you have taken.
 *
 * Given the integer array cardPoints and the integer k, return the maximum score you can obtain.
 * 
 * Example 1:
 *
 * Input: cardPoints = [1,2,3,4,5,6,1], k = 3
 * Output: 12
 * Explanation: After the first step, your score will always be 1. 
 * However, choosing the rightmost card first will maximize your total score. 
 * The optimal strategy is to take the three cards on the right, giving a final score of 1 + 6 + 5 = 12.
 * 
 * Example 2:
 *
 * Input: cardPoints = [2,2,2], k = 2
 * Output: 4
 * Explanation: Regardless of which two cards you take, your score will always be 4.
 * 
 * Solution: Use sliding window. 
 * 			 Think of the question as to take m cards from the left side and n cards from the right side.
 * 			 Then the remaining part would be to find the sliding window with len - k length to be minimum.
 **/
class Solution {
    public int maxScore(int[] cardPoints, int k) {
        /**
            Use sliding window to calculate the maximum sum
            Use a window starting from index 0 and move until the end
            Subtract the sum of the window form the total sum
            Update the maximum sum as steping toward the end
        **/
        int windowLen = cardPoints.length - k;
        int sumOfAll = 0; // Sum of all the points
        // If the k == cardPoints length, return the sum
        if (windowLen == 0) {
            for (int point: cardPoints) {
                sumOfAll += point;
            }
            return sumOfAll;
        }
        int leftP = 0;
        int rightP = windowLen - 1;
        int minSum = Integer.MAX_VALUE; // Minimum window sum
        int windowSum = 0; // Sum of the window
        // Calculate the sum of initial window
        for (int i = 0; i < windowLen; i++) {
            windowSum += cardPoints[i];
        }
        sumOfAll = windowSum;
        minSum = windowSum;
        // Go through rest of the array and find the minimum sum of window
        while (rightP < cardPoints.length - 1) {
            rightP++;
            sumOfAll += cardPoints[rightP]; // Add the current card point to the total sum
            windowSum = windowSum + cardPoints[rightP] - cardPoints[leftP]; // Update the window sum
            if (windowSum < minSum) {
                minSum = windowSum;
            }
            leftP++;
        }
        return sumOfAll - minSum;
    }
}


 