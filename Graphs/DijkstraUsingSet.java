import java.util.*;

public class DijkstraUsingSet {

    static class Pair implements Comparable<Pair> {
        int node;
        int dist;

        Pair(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }

        @Override
        public int compareTo(Pair other) {
            if (this.dist == other.dist) {
                return this.node - other.node; // tie-breaker
            }
            return this.dist - other.dist;
        }
    }

    public static void main(String[] args) {
        int n = 6; // number of nodes
        List<List<Pair>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // Add edges: addEdge(adj, from, to, weight)
        addEdge(adj, 0, 1, 4);
        addEdge(adj, 0, 2, 1);
        addEdge(adj, 2, 1, 2);
        addEdge(adj, 1, 3, 1);
        addEdge(adj, 2, 3, 5);
        addEdge(adj, 3, 4, 3);
        addEdge(adj, 4, 5, 1);

        int source = 0;
        int[] dist = dijkstra(n, adj, source);

        System.out.println("Shortest distances from node " + source + ":");
        for (int i = 0; i < n; i++) {
            System.out.println("To node " + i + " = " + (dist[i] == Integer.MAX_VALUE ? "INF" : dist[i]));
        }
    }

    static void addEdge(List<List<Pair>> adj, int u, int v, int weight) {
        adj.get(u).add(new Pair(v, weight));
        adj.get(v).add(new Pair(u, weight)); // for undirected graph
    }

    static int[] dijkstra(int n, List<List<Pair>> adj, int source) {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;

        TreeSet<Pair> set = new TreeSet<>();
        set.add(new Pair(source, 0));

        while (!set.isEmpty()) {
            Pair current = set.pollFirst();
            int u = current.node;

            for (Pair neighbor : adj.get(u)) {
                int v = neighbor.node;
                int weight = neighbor.dist;

                if (dist[u] + weight < dist[v]) {
                    // If v is already in the set with an outdated distance, remove it
                    set.remove(new Pair(v, dist[v]));
                    dist[v] = dist[u] + weight;
                    set.add(new Pair(v, dist[v]));
                }
            }
        }

        return dist;
    }
}
