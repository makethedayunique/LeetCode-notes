/*
 * 106. Construct Binary Tree from Inorder and Postorder Traversal
 *
 * Given two integer arrays inorder and postorder where inorder is the inorder traversal of a binary tree 
 * and postorder is the postorder traversal of the same tree, construct and return the binary tree.
 *
 * Example 1:
 *
 * Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
 * Output: [3,9,20,null,null,15,7]
 *
 * Example 2:
 *
 * Input: inorder = [-1], postorder = [-1]
 * Output: [-1]
 *
 * We can build a unique binary tree with postorder and inorder or preorder and inorder,
 * but we cannot build a unique binary tree with preorder and postorder
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        /*
         * The method is first find the last element A as the current element in postorder
         * split the inorder array by the element A into one, split postorder except for the
         * last one as the same length as the splitted inorder array, then use the recursion 
         * function on these two subarrays
         */
        if (postorder.length == 0) {
            return null;
        }
        // ------------------------Method-uses-only-indexes---------------------------------
        return helper(inorder, 0, inorder.length - 1, postorder, 0, inorder.length - 1);
        // ------------------------Method-requires-lots-of-memory-and-time------------------
        // int len = postorder.length;
        // int inSplitPoint = 0;
        // // System.out.println(len + "," + inorder.length + "," + postorder.length);
        // for (int i = 0; i < len; i++) {
        //     if (inorder[i] == postorder[len - 1]) {
        //         inSplitPoint = i;
        //         break;
        //     }
        // }
        // int[] leftInorder = new int[inSplitPoint];
        // int[] rightInorder = new int[Math.max(len - inSplitPoint - 1, 0)];
        // // Split inorder array into one
        // System.arraycopy(inorder, 0, leftInorder, 0, inSplitPoint);
        // System.arraycopy(inorder, inSplitPoint + 1, 
        //                  rightInorder, 0, Math.max(len - inSplitPoint - 1, 0));
        // // Split postorder into two arrays same length as the inorder arrays
        // int[] leftPostorder = new int[inSplitPoint];
        // int[] rightPostorder = new int[Math.max(len - inSplitPoint - 1, 0)];
        // System.arraycopy(postorder, 0, leftPostorder, 0, inSplitPoint);
        // System.arraycopy(postorder, inSplitPoint, 
        //                  rightPostorder, 0, Math.max(len - inSplitPoint - 1, 0));        
        // // Add a new node
        // TreeNode root = new TreeNode(postorder[len - 1]);
        // root.left = buildTree(leftInorder, leftPostorder);
        // root.right = buildTree(rightInorder, rightPostorder);
        // return root;
    }
    
    private TreeNode helper(int[] inorder, int inLeft, int inRight,
                            int[] postorder, int postLeft, int postRight) {
        if (postRight - postLeft < 0) {
            return null;
        }
        if (postRight - postLeft == 0) {
            return new TreeNode(postorder[postLeft]);
        }
        int sp = 0;
        for (int i = inLeft; i < inRight + 1; i++) {
            if (inorder[i] == postorder[postRight]) {
                sp = i;
                break;
            }
        }
        TreeNode root = new TreeNode(postorder[postRight]);
        root.left = helper(inorder, inLeft, sp - 1, 
                           postorder, postLeft, postLeft + sp - inLeft - 1);
        root.right = helper(inorder, sp + 1, inRight,
                            postorder, postLeft + sp - inLeft, postRight - 1);
        return root;
    }
}


