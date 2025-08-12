import java.util.*;

public class primsAlgorithm {

    static class Edge {
        int weight;
        int vertex;
        int parent;

        Edge(int weight, int vertex, int parent) {
            this.weight = weight;
            this.vertex = vertex;
            this.parent = parent;
        }
    }

    public static void primMST(int[][] graph) {
        int V = graph.length;
        boolean[] visited = new boolean[V];
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));

        // Start from vertex 0 (weight = 0, vertex = 0, parent = -1)
        pq.offer(new Edge(0, 0, -1));

        int totalWeight = 0;

        while (!pq.isEmpty()) {
            Edge curr = pq.poll();

            if (visited[curr.vertex]) continue; // Skip if already visited

            visited[curr.vertex] = true;
            totalWeight += curr.weight;

            // Print edge if it's not the starting node
            if (curr.parent != -1) {
                System.out.println(curr.parent + " - " + curr.vertex + "  weight: " + curr.weight);
            }

            // Add all adjacent vertices to PQ
            for (int v = 0; v < V; v++) {
                if (graph[curr.vertex][v] != 0 && !visited[v]) {
                    pq.offer(new Edge(graph[curr.vertex][v], v, curr.vertex));
                }
            }
        }

        System.out.println("Total Weight of MST: " + totalWeight);
    }

    public static void main(String[] args) {
        int[][] graph = {
            {0, 2, 0, 6, 0},
            {2, 0, 3, 8, 5},
            {0, 3, 0, 0, 7},
            {6, 8, 0, 0, 9},
            {0, 5, 7, 9, 0}
        };

        primMST(graph);
    }
}
