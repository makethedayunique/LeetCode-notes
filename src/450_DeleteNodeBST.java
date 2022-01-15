/*
 * 450. Delete Node in a BST
 *
 * Given a root node reference of a BST and a key, delete the node with the given key in the BST. 
 * Return the root node reference (possibly updated) of the BST.
 *
 * Basically, the deletion can be divided into two stages:
 *
 * Search for a node to remove.
 * If the node is found, delete the node.
 *
 * Example 1:
 *
 * Input: root = [5,3,6,2,4,null,7], key = 3
 * Output: [5,4,6,2,null,null,7]
 * Explanation: Given key to delete is 3. So we find the node with value 3 and delete it.
 * One valid answer is [5,4,6,2,null,null,7], shown in the above BST.
 * Please notice that another valid answer is [5,2,6,null,4,null,7] and it's also accepted.
 *
 * Example 2:
 *
 * Input: root = [5,3,6,2,4,null,7], key = 0
 * Output: [5,3,6,2,4,null,7]
 * Explanation: The tree does not contain a node with value = 0.
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
    public TreeNode deleteNode(TreeNode root, int key) {
        // If it has left and right nodes, find the left most of the right subtree and use it
        boolean isLeftChild = true;
        TreeNode node = root;
        TreeNode prev = null;
        while (node != null) {
            if (node.val > key) {prev=node;node=node.left;isLeftChild=true;}
            else if (node.val < key) {prev=node;node=node.right;isLeftChild=false;}
            else break;
        }
        if (node == null) {
            return root;
        }
        
        // what if it is the root
        if (prev == null) {
            if (root.right == null) {
                return root.left;
            }
            TreeNode sc = root.right;
            TreeNode scp = root;
            while (sc.left != null) {
                scp = sc;
                sc = sc.left;
            }
            if (scp == root) {
                sc.left = root.left;
                return sc;
            } else {
                scp.left = sc.right;
                sc.left = root.left;
                sc.right = root.right;
                return sc;
            }
        }
        
        // if it is not the root
        if (node.left == null && node.right == null) {
            if (isLeftChild) prev.left = null;
            else prev.right = null;
        } else if (node.left != null && node.right == null) {
            if (isLeftChild) prev.left = node.left;
            else prev.right = node.left;
        } else if (node.left == null && node.right != null) {
            if (isLeftChild) prev.left = node.right;
            else prev.right = node.right;
        } else {
            TreeNode successor = node.right;
            TreeNode successorParent = node;
            while (successor.left != null) {
                successorParent = successor;
                successor = successor.left;
            }
            if (successorParent == node) {
                if (isLeftChild) {
                    prev.left = node.right;
                    node.right.left = node.left;
                } else {
                    prev.right = node.right;
                    node.right.left = node.left;
                }
            } else {
                successorParent.left = successor.right;
                successor.left = node.left;
                successor.right = node.right;
                if (isLeftChild) {
                    prev.left = successor;
                } else {
                    prev.right = successor;
                }
            }
        }
        return root;
    }
}



