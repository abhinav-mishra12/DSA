import java.util.HashSet;
import java.util.Set;

public class makingALargeIsland {
    public static void main(String[] args) {
        class Solution {
    class DSU {
        int[] parent, size;

        DSU(int n) {
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        int find(int x) {
            if (parent[x] != x) parent[x] = find(parent[x]);
            return parent[x];
        }

        void union(int x, int y) {
            int px = find(x);
            int py = find(y);
            if (px == py) return;
            if (size[px] < size[py]) {
                parent[px] = py;
                size[py] += size[px];
            } else {
                parent[py] = px;
                size[px] += size[py];
            }
        }

        int getSize(int x) {
            return size[find(x)];
        }
    }

    public int largestIsland(int[][] grid) {
        int n = grid.length;
        DSU dsu = new DSU(n * n);

        // Directions
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

        // Step 1: Union all adjacent 1's
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == 1) {
                    for (int[] d : dirs) {
                        int nr = r + d[0];
                        int nc = c + d[1];
                        if (nr >= 0 && nr < n && nc >= 0 && nc < n && grid[nr][nc] == 1) {
                            dsu.union(r * n + c, nr * n + nc);
                        }
                    }
                }
            }
        }

        // Step 2: Find max island size without flipping
        int maxIsland = 0;
        for (int i = 0; i < n * n; i++) {
            if (grid[i / n][i % n] == 1) {
                maxIsland = Math.max(maxIsland, dsu.getSize(i));
            }
        }

        // Step 3: Try flipping each 0 and calculate possible island size
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == 0) {
                    Set<Integer> seen = new HashSet<>();
                    int newSize = 1; // the flipped cell
                    for (int[] d : dirs) {
                        int nr = r + d[0];
                        int nc = c + d[1];
                        if (nr >= 0 && nr < n && nc >= 0 && nc < n && grid[nr][nc] == 1) {
                            int parentId = dsu.find(nr * n + nc);
                            if (!seen.contains(parentId)) {
                                seen.add(parentId);
                                newSize += dsu.size[parentId];
                            }
                        }
                    }
                    maxIsland = Math.max(maxIsland, newSize);
                }
            }
        }

        return maxIsland;
    }
}

    }
}
