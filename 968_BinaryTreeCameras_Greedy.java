/**
 * 968. Binary Tree Cameras
 * 
 * You are given the root of a binary tree. We install cameras on the tree nodes where each camera 
 * at a node can monitor its parent, itself, and its immediate children.
 *
 * Return the minimum number of cameras needed to monitor all nodes of the tree.
 * 
 * Example 1:
 * 
 * Input: root = [0,0,null,0,0]
 * Output: 1
 * Explanation: One camera is enough to monitor all nodes if placed as shown.
 * 
 * Example 2:
 * 
 * Input: root = [0,0,null,0,null,0,null,null,0]
 * Output: 2
 * Explanation: At least two cameras are needed to monitor all nodes of the tree. 
 * The above image shows one of the valid configurations of camera placement.
 * 
 ****** Solution: Status Label, Post-Order Traversal, Greedy *********
 * 
 * Link: https://leetcode.com/problems/binary-tree-cameras/
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
    private int camera = 0;
    public int minCameraCover(TreeNode root) {
        /**
         * Start from the leaf nodes, make their parents camera
         * We need to monitor the states of the nodes
         * 0: non-coverd, 1:camera 2: covered
         * Post-order traversal
         */
        if (helper(root) == 0) {
            camera++; // If root node is not coverd, we need to add a camera
        }
        
        return camera;
    }
    
    private int helper(TreeNode node) {
        if (node == null) {
            return 2; // if null node, return covered;
        }
        int left = helper(node.left);
        int right = helper(node.right);
        if (left == 2 && right == 2) return 0; // If left and right are all covered, then this node is not covered
        if (left == 0 || right == 0) { camera++; return 1; } // If one of the children is not covered, this node needs a camera
        if (left == 1 || right == 1) return 2; // If one of the children is a camera, then this one is covered
        return -1; // impossible
    }
}


