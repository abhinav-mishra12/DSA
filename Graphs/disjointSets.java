// Disjoint Set – Simple Union

public class disjointSets {

    static class DisjointSet {
        int[] parent;

        DisjointSet(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i; // each node is its own parent initially
            }
        }

        // Find the root of a set
        int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]); // path compression
            }
            return parent[x];
        }

        // Union two sets (simple)
        void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX != rootY) {
                parent[rootY] = rootX; // link rootY to rootX
            }
        }
    }

    public static void main(String[] args) {
        DisjointSet ds = new DisjointSet(5);

        ds.union(0, 1);
        ds.union(1, 2);
        ds.union(3, 4);

        System.out.println(ds.find(0) == ds.find(2)); // true
        System.out.println(ds.find(0) == ds.find(4)); // false
    }
}


// // Disjoint Set – Union by Rank

// public class disjointSets {

//     static class DisjointSet {
//         int[] parent;
//         int[] rank;

//         DisjointSet(int n) {
//             parent = new int[n];
//             rank = new int[n];
//             for (int i = 0; i < n; i++) {
//                 parent[i] = i;
//                 rank[i] = 0; // rank = tree height
//             }
//         }

//         // Find with path compression
//         int find(int x) {
//             if (parent[x] != x) {
//                 parent[x] = find(parent[x]);
//             }
//             return parent[x];
//         }

//         // Union by rank
//         void union(int x, int y) {
//             int rootX = find(x);
//             int rootY = find(y);

//             if (rootX != rootY) {
//                 if (rank[rootX] < rank[rootY]) {
//                     parent[rootX] = rootY;
//                 } else if (rank[rootX] > rank[rootY]) {
//                     parent[rootY] = rootX;
//                 } else {
//                     parent[rootY] = rootX;
//                     rank[rootX]++; // increase rank if both have same rank
//                 }
//             }
//         }
//     }

//     public static void main(String[] args) {
//         DisjointSet ds = new DisjointSet(5);

//         ds.union(0, 1);
//         ds.union(1, 2);
//         ds.union(3, 4);

//         System.out.println(ds.find(0) == ds.find(2)); // true
//         System.out.println(ds.find(0) == ds.find(4)); // false
//     }
// }


// // Disjoint Set – Union by Size

// public class disjointSets {

//     static class DisjointSet {
//         int[] parent;
//         int[] size;

//         DisjointSet(int n) {
//             parent = new int[n];
//             size = new int[n];
//             for (int i = 0; i < n; i++) {
//                 parent[i] = i; // each node is its own parent initially
//                 size[i] = 1;   // initial size of each set is 1
//             }
//         }

//         // Find with path compression
//         int find(int x) {
//             if (parent[x] != x) {
//                 parent[x] = find(parent[x]);
//             }
//             return parent[x];
//         }

//         // Union by size
//         void union(int x, int y) {
//             int rootX = find(x);
//             int rootY = find(y);

//             if (rootX != rootY) {
//                 if (size[rootX] < size[rootY]) {
//                     parent[rootX] = rootY;
//                     size[rootY] += size[rootX];
//                 } else {
//                     parent[rootY] = rootX;
//                     size[rootX] += size[rootY];
//                 }
//             }
//         }
//     }

//     public static void main(String[] args) {
//         DisjointSet ds = new DisjointSet(5);

//         ds.union(0, 1);
//         ds.union(1, 2);
//         ds.union(3, 4);

//         System.out.println(ds.find(0) == ds.find(2)); // true
//         System.out.println(ds.find(0) == ds.find(4)); // false
//     }
// }
