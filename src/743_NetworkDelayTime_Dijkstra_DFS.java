/**
 * 743. Network Delay Time
 * 
 * You are given a network of n nodes, labeled from 1 to n. You are also given times, 
 * a list of travel times as directed edges times[i] = (ui, vi, wi), where ui is the source node, 
 * vi is the target node, and wi is the time it takes for a signal to travel from source to target.
 *
 * We will send a signal from a given node k. Return the time it takes for all the n nodes to receive the signal.
 * If it is impossible for all the n nodes to receive the signal, return -1.
 * 
 * Example 1:
 * 
 * Input: times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
 * Output: 2
 * 
 * Example 2:
 * 
 * Input: times = [[1,2,1]], n = 2, k = 1
 * Output: 1
 * 
 * Example 3:
 *
 * Input: times = [[1,2,1]], n = 2, k = 2
 * Output: -1
 * 
 * Solution:
 * Dijkstra - Find the shortest path to every node in a directed graph from one starting node
 * 			- Use minimum heap
 * 			- While the heap is not empty, take the edge with smallest cumulated time
 * 			- Update the result time and add all the adjacent nodes and related time to the heap
 * 
 * DFS - Traverse the nodes using DFS to update a signal reaching time array of all the nodes
 * 
 **/
class Solution {
    /**
        Use DFS to find the answer
        Go through the current node and DFS it
        Updating the signalReceivedAt array when accumulated time less than previous value
    */
    Map<Integer, List<Pair<Integer, Integer>>> edges = new HashMap<>();
    
    private void DFS(int[] signalReceivedAt, int currNode, int currTime) {
        // signReceivedAt: array of time received for each of the nodes
        // currNode: current node to be iterated
        // currTime: accumulated time when reaching the node
        // If the currTime is greater or equal than the previous time
        // Just skip the node
        if (currTime >= signalReceivedAt[currNode]) {
            return;
        }
        
        // If new time is less than the previous time, update it and traverse
        // adjacent nodes of current node
        signalReceivedAt[currNode] = currTime;
        // If there is no adjacent node of the current node
        if (!edges.containsKey(currNode)) {
            return;
        }
        // Traverse all its adjacent nodes
        for (Pair<Integer, Integer> edge: edges.get(currNode)) {
            int travelTime = edge.getKey();
            int neighborNode = edge.getValue();
            // Use the new time in DFS to traverse
            DFS(signalReceivedAt, neighborNode, travelTime+currTime);
        }
    }
    
    public int networkDelayTime(int[][] times, int n, int k) {
        /**
            Use DFS method
            Go through all the nodes, everytime go from the path with smallest time
            Save time for future to avoid wasteful traversing
        */
        // Populate the adjacency map
        for (int[] time: times) {
            int source = time[0];
            int dest = time[1];
            int travelTime = time[2];
            
            edges.putIfAbsent(source, new ArrayList<>());
            edges.get(source).add(new Pair(travelTime, dest));
        }
        // Sort the edges conencting to each node
        for (int node: edges.keySet()) {
            Collections.sort(edges.get(node), (a,b) -> a.getKey() - b.getKey());
            // Sort by travel time in a certain edge
        }
        int[] signalReceivedAt = new int[n+1];
        Arrays.fill(signalReceivedAt, Integer.MAX_VALUE);
        
        DFS(signalReceivedAt, k, 0);
        int answer = Integer.MIN_VALUE;
        for (int node = 1; node <= n; node++) {
            answer = Math.max(answer, signalReceivedAt[node]);
        }
        // If answer is MAX_VALUE, return -1
        return answer == Integer.MAX_VALUE ? -1 : answer; 
        
        /**
            Use the dijkstra's algorithm
            Use a minimum heap (which is a priority queue) to maintain
            the smallest time and the next nodes in the heap
            Everytime take the top of the heap as the next node
            Always check the visited array
        **/
        /**
        boolean[] visited = new boolean[n]; // Initialized with all false, non-visited
        int result = -1;
        // In the array there is pair of [x,y], x is the node, y is the cumulated length
        PriorityQueue<int[]> nextNodes = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        int[] initialPoint = new int[]{k, 0};
        nextNodes.add(initialPoint);
        // Edges hashmap
        HashMap<Integer, ArrayList<int[]>> edges = new HashMap<>();
        // Populate the edges map
        for (int i = 0; i < times.length; i++) {
            int[] newEdge = new int[]{times[i][1], times[i][2]};
            if (edges.containsKey(times[i][0])) {
                edges.get(times[i][0]).add(newEdge);
            } else {
                ArrayList<int[]> vEdges = new ArrayList<>();
                vEdges.add(newEdge);
                edges.put(times[i][0], vEdges);
            }
        }
        // Start iteration
        while (!nextNodes.isEmpty()) {
            int[] next = nextNodes.poll();
            int node = next[0];
            int time = next[1];
            if (visited[node-1]) {
                // If this node has been visited, just continue
                continue;
            }
            // Otherwise, go through all the adjacent nodes and add to the min heap
            if (edges.containsKey(node)) {
                for (int[] edge: edges.get(node)) {
                    int[] newPath = new int[]{edge[0], edge[1] + time};
                    nextNodes.offer(newPath); // Add the new path to the priority queue
                }
            }
            result = time; // Update the result time
            visited[node-1] = true; // Set the node to be visited
        }
        // Check if all nodes have been visited
        for (boolean visit: visited) {
            if (!visit) {
                return -1;
            }
        }
        return result;
        **/
    }
} 