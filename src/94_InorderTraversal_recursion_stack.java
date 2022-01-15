/*
 * 94. Binary Tree Inorder Traversal
 *
 * Given the root of a binary tree, return the inorder traversal of its nodes' values.
 *
 * Method 1: traverse the nodes recursively
 * Method 2: use the stack and pointer
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
//------------------------------Method-1-------------------------------------
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        traversal(root, result);
        return result;
    }
    private void traversal(TreeNode node, ArrayList<Integer> intList) {
        if (node == null) {
            return;
        }
        traversal(node.left, intList);
        intList.add(node.val);
        traversal(node.right, intList);
    }
}
//------------------------------Method-2-------------------------------------
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        Stack<TreeNode> nodes = new Stack<TreeNode>();
        TreeNode cur = root;
        while (cur != null || !nodes.empty()) {
            if (cur != null) {
                nodes.push(cur); // push into the left nodes
                cur = cur.left;
            } else {
                // cur = null
                cur = nodes.pop();
                result.add(cur.val);
                cur = cur.right;
            }
        }
        return result;
    }
}



