// You are given an m x n binary matrix grid, where 0 represents a sea cell and 1 represents a land cell.

// A move consists of walking from one land cell to another adjacent (4-directionally) land cell or walking off the boundary of the grid.

// Return the number of land cells in grid for which we cannot walk off the boundary of the grid in any number of moves.

 

// Example 1:


// Input: grid = [[0,0,0,0],[1,0,1,0],[0,1,1,0],[0,0,0,0]]
// Output: 3
// Explanation: There are three 1s that are enclosed by 0s, and one 1 that is not enclosed because its on the boundary.
// Example 2:


// Input: grid = [[0,1,1,0],[0,0,1,0],[0,0,1,0],[0,0,0,0]]
// Output: 0
// Explanation: All 1s are either on the boundary or can reach the boundary.
public class numberOfEnclaves {
    public static void main(String[] args) {
        class Solution {
    public int numEnclaves(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        // Step 1: DFS from all border cells
        for (int i = 0; i < rows; i++) {
            dfs(grid, i, 0);           // left column
            dfs(grid, i, cols - 1);    // right column
        }
        for (int j = 0; j < cols; j++) {
            dfs(grid, 0, j);           // top row
            dfs(grid, rows - 1, j);    // bottom row
        }

        // Step 2: Count remaining land cells (1s)
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) count++;
            }
        }

        return count;
    }
     private void dfs(int[][] grid, int r, int c) {
        int rows = grid.length;
        int cols = grid[0].length;

        // Out of bounds or already water
        if (r < 0 || c < 0 || r >= rows || c >= cols || grid[r][c] != 1) return;

        // Mark this cell as water (visited)
        grid[r][c] = 0;

        // Explore in 4 directions
        dfs(grid, r + 1, c);
        dfs(grid, r - 1, c);
        dfs(grid, r, c + 1);
        dfs(grid, r, c - 1);
    }
}
    
    }
}
