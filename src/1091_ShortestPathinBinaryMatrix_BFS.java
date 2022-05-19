/**
 * 1091. Shortest Path in Binary Matrix
 * 
 * Given an n x n binary matrix grid, return the length of the shortest clear path in the matrix. 
 * If there is no clear path, return -1.
 *
 * A clear path in a binary matrix is a path from the top-left cell (i.e., (0, 0)) 
 * to the bottom-right cell (i.e., (n - 1, n - 1)) such that:
 *
 * All the visited cells of the path are 0.
 * All the adjacent cells of the path are 8-directionally connected (i.e., they are different and they share an edge or a corner).
 * 
 * The length of a clear path is the number of visited cells of this path.
 * 
 * Example 1:
 * 
 * Input: grid = [[0,1],[1,0]]
 * Output: 2
 * 
 * Example 2:
 * 
 * Input: grid = [[0,0,0],[1,1,0],[1,1,0]]
 * Output: 4
 * 
 **/ 
class Solution {
    /**
        If using the DFS method, it will take too long time to compute
        For this kind of question which is intended to find the shortest path in a lattice graph
        We should use BFS to find the shortest path
        Starting from the first point, populate all the rest reachable points and set the shortest path
    **/
    // Use the DFS method to calculate the shortest path
    private boolean[][] visited; // This is the visited array of a path
    private int[][] dirs = new int[][]{{1,1}, {-1,-1}, {-1,0}, {-1,1}, {0,-1}, {0,1}, {1,-1}, {1,0}};
    
    public int shortestPathBinaryMatrixBFS(int[][] grid) {
        // For the first node, if it is 1, return -1        
        if (grid[0][0] == 1 || grid[grid.length-1][grid.length-1] == 1) {
            return -1;
        }
        int matrixLen = grid.length;
        int layer = 0; // This is the length of the current path
        visited = new boolean[matrixLen][matrixLen];
        Queue<int[]> nodesQue = new LinkedList<int[]>();
        // Insert the top-left cell
        nodesQue.offer(new int[]{0,0});
        visited[0][0] = true;
        // Start go through
        while (!nodesQue.isEmpty()) {
            int size = nodesQue.size();
            layer++;
            // Go through the current layer
            for (int i = 0; i < size; i++) {
                int[] node = nodesQue.poll();
                if (node[0] == matrixLen - 1 && node[1] == matrixLen - 1) {
                    // Reach the bottom-right cell
                    return layer;
                }
                // Otherwise add the neighbors of the current node
                for (int[] dir: dirs) {
                    if (!ifValid(node[0]+dir[0], node[1]+dir[1], matrixLen, grid)) {
                        // Continue
                        continue;
                    }
                    // Set the visited matrix values before adding to the queue
                    // This can help avoid visiting more useless nodes than necessary
                    visited[node[0]+dir[0]][node[1]+dir[1]] = true;
                    nodesQue.offer(new int[]{node[0]+dir[0], node[1]+dir[1]});
                }
            }
        }
        // Not found
        return -1;
    }

    public int shortestPathBinaryMatrixDFS(int[][] grid) {
        int matrixLen = grid.length;
        visited = new boolean[matrixLen][matrixLen];
        visited[0][0] = true;
        // If the top-left cell is 1, return -1
        if (grid[0][0] == 1) {
            return -1;
        }
        int result = findShortestLen(0, 0, matrixLen, grid);
        if (result == Integer.MAX_VALUE) {
            return -1;
        }
        return result;
    }
    
    public int findShortestLen(int i, int j, int matrixLen, int[][] grid) {
        /**
            i: x coordinate of the current point
            j: y coordinate of the current point
            grid: the original grid
            matrixLen: target length of the matrix
            Precondition: the current point is 0
        **/
        // If the current point is the bottom-right cell
        if (i == matrixLen - 1 && j == matrixLen - 1) {
            return 1;
        }
        // If the current point is not the bottom-right cell
        int minLen = Integer.MAX_VALUE;
        for (int[] dir: dirs) {
            if (!ifValid(i+dir[0], j+dir[1], matrixLen, grid)) {
                continue;
            }
            // Else go recursively to the next point
            visited[i+dir[0]][j+dir[1]] = true;
            int restLen = findShortestLen(i+dir[0], j+dir[1], matrixLen, grid);
            visited[i+dir[0]][j+dir[1]] = false;
            if (restLen < minLen) {
                minLen = restLen;
            }
        }
        // minLen could be INTEGER.MAX_VALUE
        if (minLen == Integer.MAX_VALUE) {
            return minLen;
        }
        // else return 1 + minLen
        return 1 + minLen;
    }
    
    private boolean ifValid(int i, int j, int matrixLen, int[][] grid) {
        /**
            This function will check if the (i,j) is valid
            Check if it is inside the boundary and value is 0 and not visited
        **/
        if (i < 0 || i >= matrixLen || j < 0 || j >= matrixLen) {
            return false;
        }
        if (grid[i][j] == 1) {
            return false;
        }
        if (visited[i][j]) {
            // If visited, skip this point
            return false;
        }
        // Otherwise return true
        return true;
    }
}

