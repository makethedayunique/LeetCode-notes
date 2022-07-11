/*
 * 236. Lowest Common Ancestor of a Binary Tree
 *
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 *
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q 
 * as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 *
 * Example 1:
 *
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * Output: 3
 * Explanation: The LCA of nodes 5 and 1 is 3.
 *
 * Solution: Recursion
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        /** Solution 1: Use recursive method to find out the LCA
        if (root == p || root == q || root == null) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) return root;
        if (left == null) return right;
        else return left;
        **/
        
        /** Solution 2: Use DFS to find the path from root to target node and compare the paths
         * And find out the LCA
         **/ 
        List<TreeNode> pathP = new ArrayList<>();
        List<TreeNode> pathQ = new ArrayList<>();
        pathP.add(root);
        pathQ.add(root);
        dfs(root, p, pathP);
        dfs(root, q, pathQ);
        int k = 0;
        while (k < pathP.size() && k < pathQ.size() && pathP.get(k) == pathQ.get(k)) {
            k++;
        }
        return pathP.get(k-1);
    }

    private boolean dfs(TreeNode node, TreeNode target, List<TreeNode> path) {
        /** Skip the root **/
        if (node == null) return false;
        if (node == target) return true;
        
        if (node.left != null) {
            path.add(node.left);
            if (dfs(node.left, target, path)) {
                return true;
            }
            path.remove(path.size() - 1);
        }
        
        if (node.right != null) {
            path.add(node.right);
            if (dfs(node.right, target, path)) {
                return true;
            }
            path.remove(path.size() - 1);
        }
        
        return false;
    }
}






