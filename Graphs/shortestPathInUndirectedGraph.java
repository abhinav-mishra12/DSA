import java.util.*;

public class shortestPathInUndirectedGraph {

    public static void main(String[] args) {
        int n = 7; // number of nodes
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // Add edges (undirected)
        addEdge(adj, 0, 1);
        addEdge(adj, 0, 2);
        addEdge(adj, 1, 3);
        addEdge(adj, 2, 4);
        addEdge(adj, 3, 5);
        addEdge(adj, 4, 5);
        addEdge(adj, 5, 6);

        int source = 0;
        int[] dist = shortestPathBFS(n, adj, source);

        System.out.println("Shortest distances from node " + source + ":");
        for (int i = 0; i < n; i++) {
            System.out.println("To node " + i + " = " + dist[i]);
        }
    }

    static void addEdge(List<List<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u); // since the graph is undirected
    }

    static int[] shortestPathBFS(int n, List<List<Integer>> adj, int source) {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;

        Queue<Integer> q = new LinkedList<>();
        q.offer(source);

        while (!q.isEmpty()) {
            int node = q.poll();

            for (int neighbor : adj.get(node)) {
                if (dist[neighbor] == Integer.MAX_VALUE) {
                    dist[neighbor] = dist[node] + 1;
                    q.offer(neighbor);
                }
            }
        }

        return dist;
    }
}
