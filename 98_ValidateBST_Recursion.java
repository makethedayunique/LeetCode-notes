/*
 * 98. Validate Binary Search Tree
 *
 * Given the root of a binary tree, determine if it is a valid binary search tree (BST).
 *
 * A valid BST is defined as follows:
 *
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 *
 * Example 1:
 *
 * Input: root = [2,1,3]
 * Output: true
 *
 * Example 2:
 *
 * Input: root = [5,1,4,null,null,3,6]
 * Output: false
 * Explanation: The root node's value is 5 but its right child's value is 4.
 *
 * Solution: Use recursion with Inorder traversal, BST will become ascending order with inorder traversal
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
    private long maxVal = Long.MIN_VALUE; // In case there is Integer.MIN_VALUE existing
    public boolean isValidBST(TreeNode root) {
        // inorder traversal could generate a ascending order array for bst
        // ------------------Recursion-------------------------------
        if (root == null) return true;
        boolean left = isValidBST(root.left);
        if (maxVal < root.val) maxVal = root.val; // no duplicated value allowed
        else return false;
        boolean right = isValidBST(root.right);
        return left && right;
    }
}




