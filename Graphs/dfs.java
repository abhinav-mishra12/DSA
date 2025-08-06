import java.util.*;

public class dfs {
    // DFS function
    public static void dfsUtil(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited, List<Integer> result) {
        visited[node] = true;
        result.add(node);

        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                dfsUtil(neighbor, adj, visited, result);
            }
        }
    }

    public static void main(String[] args) {
        int n = 9;

        // Creating adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        // Add edges (undirected graph)
        adj.get(1).add(2);
        adj.get(1).add(6);

        adj.get(2).add(1);
        adj.get(2).add(3);
        adj.get(2).add(4);

        adj.get(6).add(1);
        adj.get(6).add(7);
        adj.get(6).add(9);

        adj.get(3).add(2);
        adj.get(4).add(2);
        adj.get(4).add(5);


        adj.get(7).add(6);
        adj.get(7).add(8);

        adj.get(5).add(8);
        adj.get(5).add(4);

        adj.get(8).add(5);
        adj.get(8).add(7);

        boolean[] visited = new boolean[n + 1];
        List<Integer> dfsResult = new ArrayList<>();

        int startingNode = 1;
        dfsUtil(startingNode, adj, visited, dfsResult);

        System.out.println("DFS Traversal starting from node " + startingNode + ":");
        for (int node : dfsResult) {
            System.out.print(node + " ");
        }
    }
}
