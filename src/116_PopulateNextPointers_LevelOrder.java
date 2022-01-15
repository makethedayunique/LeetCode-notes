/*
 * 116. Populating Next Right Pointers in Each Node
 *
 * You are given a perfect binary tree where all leaves are on the same level, 
 * and every parent has two children. The binary tree has the following definition:
 *
 * struct Node {
 *  int val;
 *  Node *left;
 *  Node *right;
 *  Node *next;
 * }
 * Populate each next pointer to point to its next right node. 
 * If there is no next right node, the next pointer should be set to NULL.
 *
 * Initially, all next pointers are set to NULL.
 *
 * Example 1:
 *
 * Input: root = [1,2,3,4,5,6,7]
 * Output: [1,#,2,3,#,4,5,6,7,#]
 *
 * Solution 1: Typical level-order traversal, but use O(k) extra memory space
 * Solution 2: Use O(1) memory space
 *
 */
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        //--------------------------Method-2-----------------------
        // Only use the extra O(1) memory
        Node curr = root;
        while (true) {
            if (curr.left != null) {
                curr.left.next = curr.right;
                Node head = curr.left;
                Node prev = curr.right;
                curr = curr.next;
                while (curr != null) {
                    curr.left.next = curr.right;
                    prev.next = curr.left;
                    prev = curr.right;
                    curr = curr.next;
                }
                curr = head;
            } else {
                break;
            }
        }
        return root;
        
        //--------------------------Method-1-----------------------
        // Typical way to do the level-order traversal
        Queue<Node> nodes = new LinkedList<>();
        nodes.offer(root);
        while (!nodes.isEmpty()) {
            int len = nodes.size();
            
            Node prev = nodes.poll();
            if (prev.left != null) nodes.offer(prev.left);
            if (prev.right != null) nodes.offer(prev.right);
            
            for (int i = 1; i < len; i++) {
                Node node = nodes.poll();
                if (node.left != null) nodes.offer(node.left);
                if (node.right != null) nodes.offer(node.right);
                prev.next = node;
                prev = node;
            }
        }
        return root;
    }
}



