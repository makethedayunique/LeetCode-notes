/**
 * 1650. Lowest Common Ancestor of a Binary Tree III
 * 
 * Given two nodes of a binary tree p and q, return their lowest common ancestor (LCA).
 *
 * Each node will have a reference to its parent node. The definition for Node is below:
 *
 * class Node {
 *    public int val;
 *    public Node left;
 *    public Node right;
 *    public Node parent;
 * }
 * According to the definition of LCA on Wikipedia: "The lowest common ancestor of 
 * two nodes p and q in a tree T is the lowest node that has both p and q as 
 * descendants (where we allow a node to be a descendant of itself)."
 * 
 * Example 1:
 *
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * Output: 3
 * Explanation: The LCA of nodes 5 and 1 is 3.
 * 
 * Solution: since in this question we don't know about the root but only the target nodes,
 * We need to find the root first.
 * 
 **/
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    public Node lowestCommonAncestor(Node p, Node q) {
        // ======================Solution 1=====================
        // Find the root and then find the LCA
        // Recursive function. IF meet p or q or null, return p or q or null
        // Otherwise, use recursive function on both the left and right children of the current node
        // Returned node will either be null or a node. According to the returned value of left and right
        // nodes, we could decide which to be returned
        
        // Find the root node first
        /**
        Node root = p;
        while (root.parent != null) {
            root = root.parent;
        }
        return findLCA(root, p, q);
        **/
        
        // ======================Solution 2=====================
        // Find two traces, Slower
        /**
        Stack<Node> pTrace = new Stack<>();
        Stack<Node> qTrace = new Stack<>();
        pTrace.push(p);
        qTrace.push(q);
        while (p.parent != null) {
            pTrace.push(p.parent);
            p = p.parent;
        }
        while (q.parent != null) {
            qTrace.push(q.parent);
            q = q.parent;
        }
        
        Node prev = null;
        while (!pTrace.isEmpty() && !qTrace.isEmpty() && pTrace.peek() == qTrace.peek()) {
            prev = pTrace.peek();
            pTrace.pop();
            qTrace.pop();
        }
        return prev;
        **/
        
        // ======================Solution 3=====================
        // Find one path, then store passed nodes
        // Iterate starting from the other node, and then check if node exists in the set
        // If not, return the different node (this will be the node)
        HashSet<Node> pPath = new HashSet<>();
        while (p != null) {
            pPath.add(p);
            p = p.parent;
        }
        
        while (q != null) {
            if (!pPath.contains(q)) q = q.parent;
            else break;
        }
        
        return q; // q is not in p's path, which means that q is the LCA
        
    }
    
    private Node findLCA(Node node, Node p, Node q) {
        if (node == null || node == p || node == q) return node;
        Node left = findLCA(node.left, p, q);
        Node right = findLCA(node.right, p, q);
        if (left != null && right != null) return node;
        if (left != null) return left;
        return right;
    }
}



 