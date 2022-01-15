/*
 * 538. Convert BST to Greater Tree
 *
 * Given the root of a Binary Search Tree (BST), convert it to a Greater Tree such that every key of 
 * the original BST is changed to the original key plus the sum of all keys greater than the original key in BST.
 *
 * As a reminder, a binary search tree is a tree that satisfies these constraints:
 *
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 *
 * Example 1:
 *
 * Input: root = [4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
 * Output: [30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]
 *
 * Solution: Traversal with right-middle-left and maintain a variable storing the previous value
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
    private int prev = 0;
    
    public TreeNode convertBST(TreeNode root) {
        helper(root);
        return root;
    }
    
    private void helper(TreeNode node) {
        /*
         * a BST can be transfered to an ascending array
         * So greater BST is just the result of accumulating from the rear
         * The traversal order would be right, middle, left
         * Use a int value to store the previous value
         */
        if (node == null) return;
        helper(node.right);
        node.val = node.val + prev;
        prev = node.val;
        helper(node.left);
    }
}



