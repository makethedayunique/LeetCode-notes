/**
 * 2096. Step-By-Step Directions From a Binary Tree Node to Another
 * 
 * You are given the root of a binary tree with n nodes. Each node is uniquely assigned a value from 1 to n. 
 * You are also given an integer startValue representing the value of the start node s, 
 * and a different integer destValue representing the value of the destination node t.
 * 
 * Find the shortest path starting from node s and ending at node t. 
 * Generate step-by-step directions of such path as a string consisting of only the uppercase letters 'L', 'R', and 'U'. 
 * Each letter indicates a specific direction:
 * 
 * 'L' means to go from a node to its left child node.
 * 'R' means to go from a node to its right child node.
 * 'U' means to go from a node to its parent node.
 * 
 * Return the step-by-step directions of the shortest path from node s to node t.
 * 
 * Example 1:
 * 
 * Input: root = [5,1,2,3,null,6,4], startValue = 3, destValue = 6
 * Output: "UURL"
 * Explanation: The shortest path is: 3 → 1 → 5 → 2 → 6.
 * 
 * Example 2:
 *
 * Input: root = [2,1], startValue = 2, destValue = 1
 * Output: "L"
 * Explanation: The shortest path is: 2 → 1.
 * 
 * Solution: The shortest path from one node to another node will go through their lowest common ancestor.
 * Find the LCA while record the path from root to the starting node or detination node. Reverse the path from
 * root to the starting node and concatenate with the path from root to destination node will lead to the result.
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
    public String getDirections(TreeNode root, int startValue, int destValue) {
        /**
        Solution 1: Transform the binary tree into a graph, maintain a dictionary to store the 
        nodes and their direct connections. Use breadth-first-search to find the shortest path
        Use codes for directions:
        - L: 0
        - R: 1
        - U: 2
        Time consumed, time limit exceed
        **/
        /**
        HashMap<Integer, List<Pair<Integer,Character>>> paths = new HashMap<>();
        StringBuilder sb;
        dfs(root, paths); // Populate the paths
        // Start to find the path using BFS
        Queue<Pair<Integer,String>> que = new LinkedList<>();
        que.offer(new Pair<>(startValue,""));
        HashSet<Integer> visited = new HashSet<>();
        while (que.size() != 0) {
            Pair<Integer, String> node = que.poll();
            Integer key = node.getKey();
            String p = node.getValue();
            if (key == destValue) {
                return p;
            }
            visited.add(key);
            // Add all adjacent nodes
            if (paths.containsKey(key)) {
                for (Pair<Integer, Character> np: paths.get(key)) {
                    Integer neibor = np.getKey();
                    Character dir = np.getValue();
                    if (!visited.contains(neibor)) {
                        sb = new StringBuilder(p);
                        sb.append(dir);
                        que.offer(new Pair<>(neibor, sb.toString()));
                    }
                }
            }
        }
        return "";
        **/
        
        /**
        Solution 2: FInd the lowest common ancestor as the middle point. Reverse the path from 
        start point to LCA, and concatenate the path from LCA to end point as the result.
        **/
        ArrayList<Integer> pathStart = new ArrayList<>();
        ArrayList<Integer> pathDest = new ArrayList<>();
        ArrayList<Character> dirsStart = new ArrayList<>();
        ArrayList<Character> dirsDest = new ArrayList<>();
        // We don't need to have the root in the path
        dfs(root, startValue, pathStart, dirsStart);
        dfs(root, destValue, pathDest, dirsDest);
        
        // Debug
        // debug(pathStart, dirsStart);
        // debug(pathDest, dirsDest);
        
        // Find the lowest common ancestor
        int k = 0;
        while (k < pathStart.size() && k < pathDest.size() && pathStart.get(k).equals(pathDest.get(k))) {
            // When it is the Integer, one should use .equals to compare number which is larger than 128
            k++;
        }
        // System.out.println(k);
        StringBuilder result = new StringBuilder();
        for (int i = k; i < pathStart.size(); i++) {
            // Reverse the direction to U
            result.append("U");
        }
        for (int i = k; i < pathDest.size(); i++) {
            // Get path from LCA to dest node
            result.append(dirsDest.get(i));
        }
        // Return the concatenated path string
        return result.toString();
    }
    
    private boolean dfs(TreeNode node, int target, ArrayList<Integer> path, ArrayList<Character> dirs) {
        /**
        THis function will help depth first search the path from one node to target value node
        using recursive function. All the nodes in the path and the directions will be recorded
        in two array lists
        **/
        if (node == null) return false;
        if (node.val == target) return true;
        
        if (node.left != null) {
            path.add(node.left.val);
            dirs.add('L');
            if (dfs(node.left, target, path, dirs)) {
                return true;
            }
            path.remove(path.size() - 1);
            dirs.remove(dirs.size() - 1);
        }
        if (node.right != null) {
            path.add(node.right.val);
            dirs.add('R');
            if (dfs(node.right, target, path, dirs)) {
                return true;
            }
            path.remove(path.size() - 1);
            dirs.remove(dirs.size() - 1);
        }        
        return false;
    }
    
    private void debug(ArrayList<Integer> paths, ArrayList<Character> dirs) {
        System.out.print("Path: ");
        for (int i = 0; i < paths.size(); i++) {
            System.out.print(dirs.get(i) + String.valueOf(paths.get(i)) + " ");
        }
        System.out.print("\n");
    }
    
    /**
    private void dfs(TreeNode node, HashMap<Integer, List<Pair<Integer,Character>>> paths) {
        Pair<Integer, Character> left;
        Pair<Integer, Character> right;
        Pair<Integer, Character> parent = new Pair<>(node.val, 'U');
        List<Pair<Integer, Character>> pps;
        if (paths.containsKey(node.val)) {
            pps = paths.get(node.val);
        } else {
            pps = new ArrayList<Pair<Integer,Character>>();
        }
        if (node.left != null) {
            left = new Pair<>(node.left.val, 'L');
            pps.add(left);
            List<Pair<Integer,Character>> lchild = new ArrayList<>();
            lchild.add(parent);
            paths.put(node.left.val, lchild);
        }
        if (node.right != null) {
            right = new Pair<>(node.right.val, 'R');
            pps.add(right);
            List<Pair<Integer,Character>> rchild = new ArrayList<>();
            rchild.add(parent);
            paths.put(node.right.val, rchild);
        }
        paths.put(node.val, pps);
        if (node.left != null) dfs(node.left, paths);
        if (node.right != null) dfs(node.right, paths);
        return;
    }
    **/
}


 