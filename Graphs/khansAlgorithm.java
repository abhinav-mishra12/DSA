import java.util.*;

public class khansAlgorithm {

    public static void main(String[] args) {
        int V = 6; // Number of vertices
        int[][] edges = {
            {5, 2},
            {5, 0},
            {4, 0},
            {4, 1},
            {2, 3},
            {3, 1}
        };

        // Build adjacency list
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        // In-degree array
        int[] indegree = new int[V];

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            indegree[v]++;
        }

        // Kahn's algorithm
        Queue<Integer> queue = new LinkedList<>();

        // Add all nodes with indegree 0
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        List<Integer> topoOrder = new ArrayList<>();

        while (!queue.isEmpty()) {
            int node = queue.poll();
            topoOrder.add(node);

            for (int neighbor : graph.get(node)) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        // Check if topological sort is possible (i.e., no cycle)
        if (topoOrder.size() != V) {
            System.out.println("Cycle detected! Topological sort not possible.");
        } else {
            System.out.print("Topological Sort (Kahn's): ");
            for (int node : topoOrder) {
                System.out.print(node + " ");
            }
        }
    }
}
