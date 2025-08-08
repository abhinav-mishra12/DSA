// Given an n x n binary matrix grid, return the length of the shortest clear path in the matrix. If there is no clear path, return -1.

// A clear path in a binary matrix is a path from the top-left cell (i.e., (0, 0)) to the bottom-right cell (i.e., (n - 1, n - 1)) such that:

// All the visited cells of the path are 0.
// All the adjacent cells of the path are 8-directionally connected (i.e., they are different and they share an edge or a corner).
// The length of a clear path is the number of visited cells of this path.

 

// Example 1:


// Input: grid = [[0,1],[1,0]]
// Output: 2
// Example 2:


// Input: grid = [[0,0,0],[1,1,0],[1,1,0]]
// Output: 4
// Example 3:

// Input: grid = [[1,0,0],[1,1,0],[1,1,0]]
// Output: -1
import java.util.LinkedList;
import java.util.Queue;

public class shortestPathInBinaryMaze {
    public static void main(String[] args) {
        class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {

        int n = grid.length;
        
        //If start or end is blocked
        if(grid[0][0]!=0 || grid[n-1][n-1]!=0) return -1;

        //Directions: 8 possible directions
        int[][] directions = {{-1,-1},{-1,0},{-1,1},
                              {0,-1},         {0,1},
                              {1,-1},{1,0},{1,1}};

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0,0,1}); //{row, col, pathLength}
        grid[0][0]=1;//Mark as visited

        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            int row = curr[0];
            int col = curr[1];
            int length = curr[2];

            //Reached the destination
            if(row==n-1 && col==n-1) return length;

            for(int[] dir : directions){
                int newRow = row+dir[0];
                int newCol = col+dir[1];

                if(isValid(newRow, newCol, n) && grid[newRow][newCol]==0){
                    queue.offer(new int[]{newRow, newCol, length + 1});
                    grid[newRow][newCol] = 1; // mark as visited
                }
            }
        }

        return -1;
    }
    private boolean isValid(int row, int col, int n) {
        return row >= 0 && col >= 0 && row < n && col < n;
    }
}
    }
}
