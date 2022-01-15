/*
 * 530. Minimum Absolute Difference in BST
 *
 * Given the root of a Binary Search Tree (BST), return the minimum absolute difference between the values of 
 * any two different nodes in the tree.
 *
 * Example 1:
 *
 * Input: root = [4,2,6,1,3]
 * Output: 1
 *
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
//-------------------------------Recursion-------------------------------
class Solution {
    private int minVal = Integer.MAX_VALUE;
    private int prev = -1;
    public int getMinimumDifference(TreeNode root) {
        updateMinDiff(root);
        return minVal;
    }
    
    private void updateMinDiff(TreeNode node) {
        if (node == null) {
            return;
        }
        updateMinDiff(node.left);
        if (prev != -1) {
            if (node.val - prev < minVal) {
                minVal = node.val - prev;
            }
        }
        prev = node.val;
        updateMinDiff(node.right);
    }
}
//-------------------------------Iteration-------------------------------
class Solution {
    TreeNode pre;
    Stack<TreeNode> stack;
    public int getMinimumDifference(TreeNode root) {
        if (root == null) return 0;
        stack = new Stack<>();
        TreeNode cur = root;
        int result = Integer.MAX_VALUE;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur); // Put current node in the stack
                cur = cur.left; // Continue to the left child node
            }else {
                cur = stack.pop(); 
                if (pre != null) { // Check if this is the first node
                    result = Math.min(result, cur.val - pre.val);
                }
                pre = cur;
                cur = cur.right; // Set the current node to its right child
            }
        }
        return result;
    }
}



