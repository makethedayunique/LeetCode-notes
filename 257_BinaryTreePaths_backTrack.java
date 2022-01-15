/*
 * 257. Binary Tree Paths
 *
 * Given the root of a binary tree, return all root-to-leaf paths in any order.
 *
 * A leaf is a node with no children.
 *
 * Example 1:
 *
 * Input: root = [1,2,3,null,5]
 * Output: ["1->2->5","1->3"]
 *
 * Solution: Use backtracking and learn to update the path list, add and remove
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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        helper(root, path, result);
        return result;
    }
    
    private void helper(TreeNode node, List<Integer> path, List<String> list) {
        path.add(node.val);
        if (node.left == null && node.right == null) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < path.size(); i++) {
                sb.append(path.get(i));
                sb.append("->");
            }
            list.add(sb.substring(0, sb.length() - 2).toString());
            return;
        }
        if (node.left != null) {
            helper(node.left, path, list);
            // Need to delete the node
            path.remove(path.size() - 1);
        }
        if (node.right != null) {
            helper(node.right, path, list);
            path.remove(path.size() - 1);
        }
    }
}



