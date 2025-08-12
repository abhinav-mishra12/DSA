import java.util.*;

class Edge implements Comparable<Edge> {
    int src, dest, weight;

    Edge(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge other) {
        return this.weight - other.weight; // Sort by weight
    }
}

class DisjointSet {
    int[] parent, rank;

    DisjointSet(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    int find(int node) {
        if (parent[node] != node) {
            parent[node] = find(parent[node]); // Path compression
        }
        return parent[node];
    }

    void unionByRank(int u, int v) {
        int pu = find(u);
        int pv = find(v);

        if (pu == pv) return; // Already in same set

        if (rank[pu] < rank[pv]) {
            parent[pu] = pv;
        } else if (rank[pu] > rank[pv]) {
            parent[pv] = pu;
        } else {
            parent[pv] = pu;
            rank[pu]++;
        }
    }
}

public class kruskalAlgo {
    public static void main(String[] args) {
        int V = 5; // Number of vertices
        List<Edge> edges = new ArrayList<>();

        // Graph Edges (src, dest, weight)
        edges.add(new Edge(0, 1, 2));
        edges.add(new Edge(0, 3, 6));
        edges.add(new Edge(1, 2, 3));
        edges.add(new Edge(1, 3, 8));
        edges.add(new Edge(1, 4, 5));
        edges.add(new Edge(2, 4, 7));
        edges.add(new Edge(3, 4, 9));

        // Sort edges by weight
        Collections.sort(edges);

        DisjointSet ds = new DisjointSet(V);

        List<Edge> mst = new ArrayList<>();
        int totalWeight = 0;

        for (Edge edge : edges) {
            if (ds.find(edge.src) != ds.find(edge.dest)) {
                ds.unionByRank(edge.src, edge.dest);
                mst.add(edge);
                totalWeight += edge.weight;
            }
        }

        System.out.println("Edges in MST:");
        for (Edge e : mst) {
            System.out.println(e.src + " - " + e.dest + " : " + e.weight);
        }
        System.out.println("Total Weight of MST: " + totalWeight);
    }
}
