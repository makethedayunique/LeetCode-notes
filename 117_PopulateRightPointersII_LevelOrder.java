/*
 * 117. Populating Next Right Pointers in Each Node II
 *
 * Given a binary tree
 *
 *struct Node {
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
 * The difference between this problem and 116 is that this problem provides non-perfect binary tree
 * We need to figure out the head of the next level
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
        // Only use the extra O(1) memory
        Node cur = root; // current node in this level
        Node head = null; // first node in the next level
        Node prev = null; // node to refer to the prev node in next level
        while (cur != null) {
            // Go through this level
            while (cur != null) {
                if (cur.left != null) { // left node
                    if (prev != null) {
                        prev.next = cur.left;
                    } else {
                        head = cur.left;
                    }
                    prev = cur.left;
                }
                if (cur.right != null) { // right node
                    if (prev != null) {
                        prev.next = cur.right;
                    } else {
                        head = cur.right;
                    }
                    prev = cur.right;
                }
                cur = cur.next;
            }
            // Go to the next level
            cur = head;
            head = null;
            prev = null;
        }
        return root;
    }
}



