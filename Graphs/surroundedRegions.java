// You are given an m x n matrix board containing letters 'X' and 'O', capture regions that are surrounded:

// Connect: A cell is connected to adjacent cells horizontally or vertically.
// Region: To form a region connect every 'O' cell.
// Surround: The region is surrounded with 'X' cells if you can connect the region with 'X' cells and none of the region cells are on the edge of the board.
// To capture a surrounded region, replace all 'O's with 'X's in-place within the original board. You do not need to return anything.

 

// Example 1:

// Input: board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]

// Output: [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]

// Explanation:


// In the above diagram, the bottom region is not captured because it is on the edge of the board and cannot be surrounded.

// Example 2:

// Input: board = [["X"]]

// Output: [["X"]]
public class surroundedRegions {
    public static void main(String[] args) {
        class Solution {
    public void solve(char[][] board) {
        if(board==null || board.length==0) return;
        int rows = board.length;
        int cols = board[0].length;

        // Step 1: Mark safe regions from borders
        for(int i=0; i<rows; i++){
            dfs(board, i, 0);
            dfs(board,i, cols-1);
        }
        for(int j=0; j<cols; j++){
            dfs(board, 0, j);
            dfs(board, rows-1, j);
        }
        // Step 2: Flip all remaining 'O' to 'X', and 'T' back to 'O'
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';  // Surrounded region
                } else if (board[i][j] == 'T') {
                    board[i][j] = 'O';  // Safe region
                }
            }
        }

    }

    private void dfs(char[][] board, int r, int c) {
        int rows = board.length;
        int cols = board[0].length;

        // Boundary + check
        if (r < 0 || c < 0 || r >= rows || c >= cols || board[r][c] != 'O') return;

        board[r][c] = 'T';  // Mark safe

        // Recurse in 4 directions
        dfs(board, r + 1, c);
        dfs(board, r - 1, c);
        dfs(board, r, c + 1);
        dfs(board, r, c - 1);
    }
}
    }
}
