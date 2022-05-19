/**
 * 366. Find Leaves of Binary Tree
 * 
 * Given the root of a binary tree, collect a tree's nodes as if you were doing this:
 *
 * Collect all the leaf nodes.
 * Remove all the leaf nodes.
 * Repeat until the tree is empty.
 * 
 * Example 1:
 * 
 * Input: root = [1,2,3,4,5]
 * Output: [[4,5,3],[2],[1]]
 * Explanation:
 * [[3,5,4],[2],[1]] and [[3,4,5],[2],[1]] are also considered correct answers since per each level 
 * it does not matter the order on which elements are returned.
 * 
 * Example 2:
 *
 * Input: root = [1]
 * Output: [[1]]
 * 
 * Solution: Use recursive method to traverse the tree to find all the leaves and remove them.
 * 			 Repeat this operation until the root is the only node in the tree
 * 			 Finally add the root to the returned list.
 **/
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
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        while (root.left != null || root.right != null) {
            // At least has one branch
            ArrayList<Integer> leaves = new ArrayList<>();
            addAndDeleteLeaf(root, null, true, leaves);
            result.add(leaves);
        }
        // Finally add the root level into the result list
        ArrayList<Integer> rootLevel = new ArrayList<>();
        rootLevel.add(root.val);
        result.add(rootLevel);
        return result;
    }
    
    public void addAndDeleteLeaf(TreeNode node, TreeNode parent, boolean isLeft, List<Integer> leaves) {
        if (node.left == null && node.right == null) {
            // If the current node is leaf
            leaves.add(node.val);
            if (parent != null) {
                // If parent is not null
                if (isLeft) {
                    parent.left = null;
                } else {
                    parent.right = null;
                }
            }
        } else {
            // If the current node is not leaf
            if (node.left != null) {
                addAndDeleteLeaf(node.left, node, true, leaves);
            }
            if (node.right != null) {
                addAndDeleteLeaf(node.right, node, false, leaves);
            }
        }
    }
}


