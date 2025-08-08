import java.util.*;

public class shortestPathInDAG {
    
    static class Pair {
        int node;
        int weight;
        Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {
        int n = 6; // number of nodes
        List<List<Pair>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // Add edges (from, to, weight)
        addEdge(adj, 0, 1, 2);
        addEdge(adj, 0, 4, 1);
        addEdge(adj, 1, 2, 3);
        addEdge(adj, 4, 2, 2);
        addEdge(adj, 4, 5, 4);
        addEdge(adj, 2, 3, 6);
        addEdge(adj, 5, 3, 1);

        int source = 0;
        int[] dist = shortestPathDAG(n, adj, source);

        System.out.println("Shortest distances from node " + source + ":");
        for (int i = 0; i < n; i++) {
            System.out.println("To node " + i + " = " + (dist[i] == Integer.MAX_VALUE ? "INF" : dist[i]));
        }
    }

    static void addEdge(List<List<Pair>> adj, int u, int v, int weight) {
        adj.get(u).add(new Pair(v, weight));
    }

    static int[] shortestPathDAG(int n, List<List<Pair>> adj, int source) {
        boolean[] visited = new boolean[n];
        Stack<Integer> stack = new Stack<>();

        // Topological sort using DFS
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, adj, visited, stack);
            }
        }

        // Initialize distances
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;

        // Process nodes in topological order
        while (!stack.isEmpty()) {
            int node = stack.pop();

            if (dist[node] != Integer.MAX_VALUE) {
                for (Pair neighbor : adj.get(node)) {
                    if (dist[node] + neighbor.weight < dist[neighbor.node]) {
                        dist[neighbor.node] = dist[node] + neighbor.weight;
                    }
                }
            }
        }

        return dist;
    }

    static void dfs(int node, List<List<Pair>> adj, boolean[] visited, Stack<Integer> stack) {
        visited[node] = true;

        for (Pair neighbor : adj.get(node)) {
            if (!visited[neighbor.node]) {
                dfs(neighbor.node, adj, visited, stack);
            }
        }

        stack.push(node);
    }
}
