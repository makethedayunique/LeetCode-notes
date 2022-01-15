/**
 * 1010. Pairs of Songs With Total Durations Divisible by 60
 * 
 * You are given a list of songs where the ith song has a duration of time[i] seconds.
 *
 * Return the number of pairs of songs for which their total duration in seconds is divisible by 60. 
 * Formally, we want the number of indices i, j such that i < j with (time[i] + time[j]) % 60 == 0.
 * 
 * Example 1:
 *
 * Input: time = [30,20,150,100,40]
 * Output: 3
 * Explanation: Three pairs have a total duration divisible by 60:
 * (time[0] = 30, time[2] = 150): total duration 180
 * (time[1] = 20, time[3] = 100): total duration 120
 * (time[1] = 20, time[4] = 40): total duration 60
 * 
 * Example 2:
 *
 * Input: time = [60,60,60]
 * Output: 3
 * Explanation: All three pairs have a total duration of 120, which is divisible by 60.
 * 
 * Solution: We only care about t % 60, all the remainders can be narrowed within [0, 59]
 * So we can use an array of length of 60 as the hash table
 */
class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int[] remainder = new int[60];
        for (int t: time) {
            remainder[t % 60] += 1;
        }
        int result = 0;
        for (int i = 1; i < 30; i++) {
            result += (remainder[i] * remainder[60 - i]);
        }
        if (remainder[0] > 0) {
            result += (remainder[0] * (remainder[0] - 1) / 2);
        }
        if (remainder[30] > 0) {
            result += (remainder[30] * (remainder[30] - 1) / 2);
        }
        return result;
    }
}
