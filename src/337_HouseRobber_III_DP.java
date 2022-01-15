/**
 * 337. House Robber III
 * 
 * The thief has found himself a new place for his thievery again. There is only one entrance to this area, called root.
 * 
 * Besides the root, each house has one and only one parent house. After a tour, 
 * the smart thief realized that all houses in this place form a binary tree. 
 * It will automatically contact the police if two directly-linked houses were broken into on the same night.
 *
 * Given the root of the binary tree, return the maximum amount of money the thief can rob without alerting the police.
 * 
 * Example 1:
 * 
 * Input: root = [3,2,3,null,3,null,1]
 * Output: 7
 * Explanation: Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
 * 
 * Example 2:
 * 
 * Input: root = [3,4,5,1,3,null,1]
 * Output: 9
 * Explanation: Maximum amount of money the thief can rob = 4 + 5 = 9.
 * 
 * Solution: Compute the maximum values when rob this node and not rob this node, then compute recursively.
 * 
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int rob(TreeNode root) {
        int[] result = helper(root);
        return Math.max(result[0], result[1]);
    }
    
    private int[] helper(TreeNode node) {
        int[] pair = new int[2]; // pair[0] is not rob this node, pair[1] is rob this node
        if (node == null) return pair;
        if (node.left == null && node.right == null) {
            pair[1] = node.val;
            return pair;
        }
        int[] left = helper(node.left);
        int[] right = helper(node.right);
        pair[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        pair[1] = left[0] + right[0] + node.val;
        return pair;
    }
}



