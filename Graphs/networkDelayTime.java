// You are given a network of n nodes, labeled from 1 to n. You are also given times, a list of travel times as directed edges times[i] = (ui, vi, wi), where ui is the source node, vi is the target node, and wi is the time it takes for a signal to travel from source to target.

// We will send a signal from a given node k. Return the minimum time it takes for all the n nodes to receive the signal. If it is impossible for all the n nodes to receive the signal, return -1.

 

// Example 1:


// Input: times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
// Output: 2
// Example 2:

// Input: times = [[1,2,1]], n = 2, k = 1
// Output: 1
// Example 3:

// Input: times = [[1,2,1]], n = 2, k = 2
// Output: -1
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class networkDelayTime {
    public static void main(String[] args) {
        class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // Step 1: Build adjacency list
        List<List<int[]>> graph = new ArrayList<>();
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<>());
        }

        for(int[] t : times){
            int u=t[0];
            int v=t[1];
            int w=t[2];

            graph.get(u).add(new int[]{v,w});
        }

        // Step 2: Distance array

        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0; //Start node distance is 0

        // Step 3: Min-heap (PQ) -> [distance, node]
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0]-b[0]);
        pq.offer(new int[]{0,k});

        //Step 4: Dijkstra
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int currDist = curr[0];
            int node = curr[1];

            // If already found better distance, skip
            if (dist[node]<currDist) continue;

            for(int[] nei : graph.get(node)){
                int next = nei[0];
                int weight = nei[1];
                if (dist[node] + weight < dist[next]) {
                    dist[next] = dist[node] + weight;
                    pq.offer(new int[]{dist[next], next});
                }
            }
        }

         // Step 5: Find max distance
        int maxTime = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) return -1; // unreachable node
            maxTime = Math.max(maxTime, dist[i]);
        }

        return maxTime;
        
    }
}
    }
}
