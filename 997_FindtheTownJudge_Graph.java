/**
 * 997. Find the Town Judge
 * 
 * In a town, there are n people labeled from 1 to n. There is a rumor that one of these people is secretly the town judge.
 *
 * If the town judge exists, then:
 * 
 * The town judge trusts nobody.
 * Everybody (except for the town judge) trusts the town judge.
 * There is exactly one person that satisfies properties 1 and 2.
 * You are given an array trust where trust[i] = [ai, bi] representing that the person labeled ai trusts the person labeled bi.
 *
 * Return the label of the town judge if the town judge exists and can be identified, or return -1 otherwise.
 * 
 * Example 1:
 *
 * Input: n = 2, trust = [[1,2]]
 * Output: 2
 * 
 * Example 2:
 *
 * Input: n = 3, trust = [[1,3],[2,3],[3,1]]
 * Output: -1
 * 
 * SOlution: think of the nodes in a graph, only the judge has only in-degree = N-1
 *  Others have in-degree and out-degree and their difference < N-1
 * 
 */
class Solution {
    public int findJudge(int n, int[][] trust) {
        // ---------------Graph-Concept------------------------------------
        // Once this person trust others, this person--, that person++
        // Finally see if there is any one' value = n - 1
        int[] trusted = new int[n + 1];
        for (int[] pair: trust) {
            trusted[pair[0]]--;
            trusted[pair[1]]++;
        }
        for (int i = 1; i <= n; i++) {
            if (trusted[i] == n - 1) {
                return i;
            }
        }
        return -1;
    }
}




