/*
 * 416. Partition Equal Subset Sum
 *
 * Given a non-empty array nums containing only positive integers, find if the array can 
 * be partitioned into two subsets such that the sum of elements in both subsets is equal.
 *
 * Example 1:
 *
 * Input: nums = [1,5,11,5]
 * Output: true
 * Explanation: The array can be partitioned as [1, 5, 5] and [11].
 *
 * Example 2:
 *
 * Input: nums = [1,2,3,5]
 * Output: false
 * Explanation: The array cannot be partitioned into equal sum subsets.
 *
 *
*/
public boolean canPartition(int[] nums) {
    /*
     * @ Dynamic Programming
     * @ dp[i][j] represent if it can achieve target j with numbers before and including  i-th
     * @ dp[i-1][j] can represent dp[i][j]
     * @ and you can also check if dp[i-1][j-nums[i]]
     * @ dp[i][j] = true if previous two are true
    */
    int sum = 0;
    
    for (int num : nums) {
        sum += num;
    }
    
    if ((sum & 1) == 1) {
        return false;
    }
    sum /= 2;

    int n = nums.length;
    boolean[][] dp = new boolean[n+1][sum+1];
    for (int i = 0; i < dp.length; i++) {
        Arrays.fill(dp[i], false);
    }
    
    dp[0][0] = true;
    
    for (int i = 1; i < n+1; i++) {
        dp[i][0] = true;
    }
    for (int j = 1; j < sum+1; j++) {
        dp[0][j] = false;
    }
    
    for (int i = 1; i < n+1; i++) {
        for (int j = 1; j < sum+1; j++) {
            dp[i][j] = dp[i-1][j];
            if (j >= nums[i-1]) {
                dp[i][j] = (dp[i][j] || dp[i-1][j-nums[i-1]]);
            }
        }
    }
   
    return dp[n][sum];
}
/*
 * @ Optimize the function by eliminating the memory used
*/
public boolean canPartition(int[] nums) {
    int sum = 0;
    
    for (int num : nums) {
        sum += num;
    }
    
    if ((sum & 1) == 1) {
        return false;
    }
    sum /= 2;
    
    int n = nums.length;
    boolean[] dp = new boolean[sum+1];
    Arrays.fill(dp, false);
    dp[0] = true;
    
    for (int num : nums) {
        for (int i = sum; i > 0; i--) {
            if (i >= num) {
                dp[i] = dp[i] || dp[i-num];
            }
        }
    }
    
    return dp[sum];
}


/*
 * DP- 01 BackPack Problem
 * dp[i][j] represents the largest sumunder j using [0,i] numbers
 */
public boolean canPartition(int[] nums) {
    int sum = 0;
    for (int num: nums) sum += num;
    if ((sum & 1) == 1) return false;
    int target = sum / 2;
    int[] dp = new int[target + 1];
    for (int i = 0; i < nums.length; i++) {
        for (int j = target; j >= nums[i]; j--) {
            dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
        }
    }
    if (dp[target] == target) return true;
    return false;




}