/*
 * 110. Balanced Binary Tree
 *
 * Given a binary tree, determine if it is height-balanced.
 *
 * For this problem, a height-balanced binary tree is defined as:
 *
 * a binary tree in which the left and right subtrees of every node differ in height by no more than 1.
 *
 * Example 1:
 *
 * Input: root = [3,9,20,null,null,15,7]
 * Output: true
 *
 * Example 2:
 *
 * Input: root = [1,2,2,3,3,null,null,4,4]
 * Output: false
 *
 * Solution 1: Strict according to the definition of balanced tree
 * Solution 2: DFS and return the imbalanced signals downstairs to the top
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
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        //------------------------------O(nlogn)-method------------------
        // for each node, find the height of its left and right node and compare
        if (Math.abs(getHeight(root.left) - getHeight(root.right)) > 1) {
            return false;
        }
        // If heights of left and right nodes are balanced, we still need to check if
        // it is balanced for its left and right node
        return isBalanced(root.left) && isBalanced(root.right);
        //-----------------------------O(n)-method------------------------
        // when we are heading down to the bottom, we may return height with -1 if 
        // we find that the heights of some subtree has been imbalanced
        // This can help avoid extra computing for height of subtrees
        return helper(root) != -1;
    }
    
    private int helper(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftH = helper(node.left);
        int rightH = helper(node.right);
        if (leftH == -1 || rightH == -1 || Math.abs(leftH - rightH) > 1) {
            return -1;
        }
        return Math.max(leftH, rightH) + 1;
    }
    
    private int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(getHeight(node.left), getHeight(node.right));
    }
}


