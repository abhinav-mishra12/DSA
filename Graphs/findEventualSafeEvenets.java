// There is a directed graph of n nodes with each node labeled from 0 to n - 1. The graph is represented by a 0-indexed 2D integer array graph where graph[i] is an integer array of nodes adjacent to node i, meaning there is an edge from node i to each node in graph[i].

// A node is a terminal node if there are no outgoing edges. A node is a safe node if every possible path starting from that node leads to a terminal node (or another safe node).

// Return an array containing all the safe nodes of the graph. The answer should be sorted in ascending order.

 

// Example 1:

// Illustration of graph
// Input: graph = [[1,2],[2,3],[5],[0],[5],[],[]]
// Output: [2,4,5,6]
// Explanation: The given graph is shown above.
// Nodes 5 and 6 are terminal nodes as there are no outgoing edges from either of them.
// Every path starting at nodes 2, 4, 5, and 6 all lead to either node 5 or 6.
// Example 2:

// Input: graph = [[1,2,3,4],[1,2],[3,4],[0,4],[]]
// Output: [4]
// Explanation:
// Only node 4 is a terminal node, and every path starting at node 4 leads to node 4.
 
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class findEventualSafeEvenets {
    public static void main(String[] args) {
        class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        //Reverse Graph + Kahn’s Algorithm
        int n = graph.length;
        

        //Step 1: Build a reverse graph
        List<List<Integer>> revGraph = new ArrayList<>();
        for(int i=0; i<n; i++){
            revGraph.add(new ArrayList<>());
        }

        int[] indegree = new int[n];

        for (int u = 0; u < n; u++) {
            for (int v : graph[u]) {
                revGraph.get(v).add(u); // reverse the edge: v -> u
                indegree[u]++;          // count incoming edges in reverse graph
            }
        }

        // Step 2: Kahn's Algorithm on reversed graph
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                queue.offer(i); // terminal or safe nodes
            }
        }

        boolean[] safe = new boolean[n];

        while (!queue.isEmpty()) {
            int node = queue.poll();
            safe[node] = true;

            for (int neighbor : revGraph.get(node)) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        // Step 3: Collect all safe nodes
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (safe[i]) {
                result.add(i);
            }
        }

        return result;


    }
}
    }
}
