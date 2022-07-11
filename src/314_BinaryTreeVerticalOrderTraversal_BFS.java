/**
 * 314. Binary Tree Vertical Order Traversal
 * 
 * Given the root of a binary tree, return the vertical order traversal of its nodes' values. 
 * (i.e., from top to bottom, column by column).
 *
 * If two nodes are in the same row and column, the order should be from left to right.
 * 
 * Example 1:
 * 
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [[9],[3,15],[20],[7]]
 * 
 * Example 2:
 * 
 * Input: root = [3,9,8,4,0,1,7]
 * Output: [[4],[9],[3,0,1],[8],[7]]
 * 
 * Example 3:
 * 
 * Input: root = [3,9,8,4,0,1,7,null,null,null,2,5]
 * Output: [[4],[9,5],[3,0,1],[8,2],[7]]
 * 
 * Solution: Use integer as position value to store the relative position. Traverse using BFS to build a position-nodes values hashmap.
 * Update the minimum position and maximum position while traversing and iterate by the range.
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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        // Use number to maintain the relative positions
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Queue<Pair<TreeNode, Integer>> que = new LinkedList<>(); // Use BFS to traverse
        HashMap<Integer,ArrayList<Integer>> positionVals = new HashMap<>(); // Used to maintain position and values
        int minimumVal = 0; // Minimum position
        int maximumVal = 0; // Maximum position
        Pair<TreeNode, Integer> rootPair = new Pair<>(root, 0);
        ArrayList<Integer> zeroList = new ArrayList<>();
        zeroList.add(root.val);
        positionVals.put(0, zeroList);
        
        que.offer(rootPair);
        while (!que.isEmpty()) {
            int size = que.size();
            for (int i = 0; i < size; i++) {
                Pair<TreeNode,Integer> temp = que.poll();
                int position = temp.getValue();
                TreeNode tempNode = temp.getKey();
                // Left node
                if (tempNode.left != null) {
                    int leftPos = position - 1;
                    que.offer(new Pair<>(tempNode.left, leftPos));
                    ArrayList<Integer> posList;
                    if (positionVals.containsKey(leftPos)) {
                        posList = positionVals.get(leftPos);
                    } else {
                        posList = new ArrayList<>();
                    }
                    posList.add(tempNode.left.val);
                    positionVals.put(leftPos, posList);
                    minimumVal = Math.min(minimumVal, leftPos);
                    maximumVal = Math.max(maximumVal, leftPos);
                }
                // Right node
                if (tempNode.right != null) {
                    int rightPos = position + 1;
                    que.offer(new Pair<>(tempNode.right, rightPos));
                    ArrayList<Integer> posList;
                    if (positionVals.containsKey(rightPos)) {
                        posList = positionVals.get(rightPos);
                    } else {
                        posList = new ArrayList<>();
                    }
                    posList.add(tempNode.right.val);
                    positionVals.put(rightPos, posList);
                    minimumVal = Math.min(minimumVal, rightPos);
                    maximumVal = Math.max(maximumVal, rightPos);
                }
            }
        }
        
        for (int i = minimumVal; i <= maximumVal; i++) {
            if (positionVals.containsKey(i)) {
                result.add(positionVals.get(i));
            }
        }
        return result;
        
    }
}


