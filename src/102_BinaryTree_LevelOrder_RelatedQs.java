/*
 * 102. Binary Tree Level Order Traversal
 *
 * Given the root of a binary tree, return the level order traversal of its nodes' values. 
 * (i.e., from left to right, level by level).
 *
 * Example 1:
 *
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [[3],[9,20],[15,7]]
 *
 * Soution: Use a queue to maintain
 *
 * Relatede Problems: 107, 199, 637, 429, 515, 116, 117, 104, 111
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        /*
         * Use a queue to maintain the nodes in the same level
         */
        List<List<Integer>> result = new ArrayList<List<Integer>>(); // Important to notice
        // can be replaced by: List<List<Integer>> lists = new ArrayList<>();
        Queue<TreeNode> nodes = new LinkedList<>();
        if (root == null) {
            return result;
        }
        nodes.offer(root);
        while (!nodes.isEmpty()) {
            ArrayList<Integer> levelRes = new ArrayList<>();
            int len = nodes.size();
            for (int i = 0; i < len; i++) {
                TreeNode node = nodes.poll();
                levelRes.add(node.val);
                if (node.left != null) nodes.offer(node.left);
                if (node.right != null) nodes.offer(node.right);
            }
            result.add(levelRes);
        }
        return result;
    }
}



