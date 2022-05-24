/**
 * 1110. Delete Nodes And Return Forest
 * 
 * Given the root of a binary tree, each node in the tree has a distinct value.
 *
 * After deleting all nodes with a value in to_delete, we are left with a forest (a disjoint union of trees).
 *
 * Return the roots of the trees in the remaining forest. You may return the result in any order.
 * 
 * Example 1:
 * 
 * Input: root = [1,2,3,4,5,6,7], to_delete = [3,5]
 * Output: [[1,2,null,4],[6],[7]]
 * 
 * Example 2:
 *
 * Input: root = [1,2,4,null,3], to_delete = [3]
 * Output: [[1,2,4]]
 * 
 * Solution: Use binary tree traversal and node delete method. While the children are not in deleting list, 
 * 			 add them in the deleting list, otherwise use the recursive function to traverse.
 * 
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
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> result = new ArrayList<TreeNode>();
        HashSet<Integer> toDelete = new HashSet<Integer>();
        for (int value: to_delete) {
            toDelete.add(value);
        }
        if (root != null && !toDelete.contains(root.val)) {
            result.add(root);
        }
        deleteNodes(toDelete, true, null, root, result);
        return result;
    }
    
    private void deleteNodes(HashSet toDelete, boolean isLeft, TreeNode prev, TreeNode curr, List<TreeNode> result) {
        // Check if this is the node and do some operation
        if (!toDelete.contains(curr.val)) {
            if (curr.left != null) deleteNodes(toDelete, true, curr, curr.left, result);
            if (curr.right != null) deleteNodes(toDelete, false, curr, curr.right, result);
            return;
        }
        // If this is a node to be deleted
        if (prev != null) {
            // Has a parent
            if (isLeft) {
                prev.left = null;
            } else {
                prev.right = null;
            }
        }
        // Go through left and right children
        if (curr.left != null && !toDelete.contains(curr.left.val)) {
            result.add(curr.left);
        }
        if (curr.right != null && !toDelete.contains(curr.right.val)) {
            result.add(curr.right);
        }
        if (curr.left != null) deleteNodes(toDelete, true, null, curr.left, result);
        if (curr.right != null) deleteNodes(toDelete, true, null, curr.right, result);
    }
}

