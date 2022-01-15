"""
1425. Constrained Subsequence Sum

Given an integer array nums and an integer k, return the maximum sum of a 
non-empty subsequence of that array such that for every two consecutive integers 
in the subsequence, nums[i] and nums[j], where i < j, the condition j - i <= k is satisfied.

A subsequence of an array is obtained by deleting some number of elements 
(can be zero) from the array, leaving the remaining elements in their original order.

Example 1:

Input: nums = [10,2,-10,5,20], k = 2
Output: 37
Explanation: The subsequence is [10, 2, 5, 20].

Example 2:

Input: nums = [-1,-2,-3], k = 1
Output: -1
Explanation: The subsequence must be non-empty, so we choose the largest number.

Example 3:

Input: nums = [10,-2,-10,-5,20], k = 2
Output: 23
Explanation: The subsequence is [10, -2, -5, 20].
"""
class Solution:
    def constrainedSubsetSum(self, nums: List[int], k: int) -> int:
        """
            Use the Dynamic Programming
            Time Complexity is high which will exceed the time limit
            For dp[i], dp[i] = nums[i] + max(dp[i-1], dp[i-2],...,dp[i-k], 0)
            Use the monotonic queue to maintain the maximum value in a sliding window
        """
        dp = nums.copy()
        res = nums[0]
        
        monotonic = []
        
        for i in range(len(nums)):
            startindex = max(0, i - k)
            if startindex == 0:
                if monotonic and dp[monotonic[0]] > 0:
                    dp[i] = nums[i] + dp[monotonic[0]]
                else:
                    dp[i] = nums[i]
            else:     
                if monotonic[0] < startindex:
                    monotonic.pop(0)

                if monotonic and dp[monotonic[0]] > 0:
                    dp[i] = nums[i] + dp[monotonic[0]]
                else:
                    dp[i] = nums[i]
                
            while monotonic and dp[monotonic[-1]] < dp[i]:
                monotonic.pop(-1)
            monotonic.append(i)
            
            if dp[i] > res:
                res = dp[i]
        
        return res
