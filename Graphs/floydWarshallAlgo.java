public class floydWarshallAlgo {

    static final int INF = 99999; // Large number representing "infinite" distance

    static void floydWarshall(int[][] graph, int V) {
        int[][] dist = new int[V][V];

        // Step 1: Initialize the solution matrix same as the input graph
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                dist[i][j] = graph[i][j];
            }
        }

        // Step 2: Update dist[][] for each possible intermediate vertex k
        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (dist[i][k] != INF && dist[k][j] != INF &&
                        dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        // Step 3: Print the final shortest path matrix
        printSolution(dist, V);
    }

    static void printSolution(int[][] dist, int V) {
        System.out.println("Shortest distances between every pair of vertices:");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (dist[i][j] == INF)
                    System.out.print("INF ");
                else
                    System.out.print(dist[i][j] + "   ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int V = 4; // number of vertices
        int[][] graph = {
            {0,   5,  INF, 10},
            {INF, 0,   3,  INF},
            {INF, INF, 0,   1},
            {INF, INF, INF, 0}
        };

        floydWarshall(graph, V);
    }
}
