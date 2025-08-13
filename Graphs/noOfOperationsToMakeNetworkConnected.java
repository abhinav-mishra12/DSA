// There are n computers numbered from 0 to n - 1 connected by ethernet cables connections forming a network where connections[i] = [ai, bi] represents a connection between computers ai and bi. Any computer can reach any other computer directly or indirectly through the network.

// You are given an initial computer network connections. You can extract certain cables between two directly connected computers, and place them between any pair of disconnected computers to make them directly connected.

// Return the minimum number of times you need to do this in order to make all the computers connected. If it is not possible, return -1.

 

// Example 1:


// Input: n = 4, connections = [[0,1],[0,2],[1,2]]
// Output: 1
// Explanation: Remove cable between computer 1 and 2 and place between computers 1 and 3.
// Example 2:


// Input: n = 6, connections = [[0,1],[0,2],[0,3],[1,2],[1,3]]
// Output: 2
// Example 3:

// Input: n = 6, connections = [[0,1],[0,2],[0,3],[1,2]]
// Output: -1
// Explanation: There are not enough cables.
import java.util.*;
public class noOfOperationsToMakeNetworkConnected {

    public static void main(String[] args) {
        class Solution {
    class DisjointSet {
        List<Integer> rank = new ArrayList<>();
        List<Integer> parent = new ArrayList<>();
        List<Integer> size = new ArrayList<>();

        public DisjointSet(int n) {
            for (int i = 0; i < n; i++) {
                rank.add(0);        // Initially, rank is 0
                parent.add(i);      // Each node is its own parent
                size.add(1);        // Each component size = 1
            }
        }

        public int findParent(int node) {
            if (node == parent.get(node)) {
                return node; // Ultimate parent found
            }
            int par = findParent(parent.get(node)); // Recursively find ultimate parent
            parent.set(node, par); // Path compression
            return parent.get(node);
        }

        public void unionBySize(int u, int v) {
            int pu = findParent(u);
            int pv = findParent(v);
            if (pu == pv) return; // Already in the same component

            // Attach smaller tree under bigger tree
            if (size.get(pu) < size.get(pv)) {
                parent.set(pu, pv);
                size.set(pv, size.get(pv) + size.get(pu));
            } else {
                parent.set(pv, pu);
                size.set(pu, size.get(pu) + size.get(pv));
            }
        }
    }

    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) return -1; // Not enough cables

        DisjointSet ds = new DisjointSet(n);
        int extraEdges = 0;

        // Step 1: Process connections
        for (int[] edge : connections) {
            int u = edge[0];
            int v = edge[1];
            if (ds.findParent(u) == ds.findParent(v)) {
                extraEdges++; // This is an extra edge (already connected)
            } else {
                ds.unionBySize(u, v); // Merge sets
            }
        }

        // Step 2: Count components
        int components = 0;
        for (int i = 0; i < n; i++) {
            if (ds.findParent(i) == i) {
                components++;
            }
        }

        // Step 3: We need (components - 1) cables to connect all
        if (extraEdges >= components - 1) {
            return components - 1;
        }
        return -1;
    }
}

    }
}