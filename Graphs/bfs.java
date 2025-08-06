import java.util.*;

public class bfs {
    public static void main(String[] args) {
        int n = 9;
        int m = 9;

        // Creating an adjacency list of size n+1
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        // Initialize each list
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        // Adding edges (undirected graph)
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

        // Create visited array
        int[] visitedArr = new int[n + 1];

        int startingNode = 1;
        visitedArr[startingNode] = 1;

        // Create a queue for traversal
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(startingNode);

        // Create a list to store the result
        List<Integer> result = new ArrayList<>();

        // BFS Logic
        while (!queue.isEmpty()) {
            int node = queue.poll();
            result.add(node);

            for (int neighbor : adj.get(node)) {
                if (visitedArr[neighbor] == 0) {
                    visitedArr[neighbor] = 1;
                    queue.offer(neighbor);
                }
            }
        }

        // Print the result
        System.out.println("BFS Traversal starting from node " + startingNode + ":");
        for (int node : result) {
            System.out.print(node + " ");
        }
    }
}
