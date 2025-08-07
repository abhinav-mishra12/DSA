// You are given an m x n grid where each cell can have one of three values:

// 0 representing an empty cell,
// 1 representing a fresh orange, or
// 2 representing a rotten orange.
// Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

// Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.

 

// Example 1:


// Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
// Output: 4
// Example 2:

// Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
// Output: -1
// Explanation: The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
// Example 3:

// Input: grid = [[0,2]]
// Output: 0
// Explanation: Since there are already no fresh oranges at minute 0, the answer is just 0.

import java.util.LinkedList;
import java.util.Queue;

public class rottenOranges {
    public static void main(String[] args) {
        class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0;

        //Step 1: Put all the rotten oranges in queue, and count fresh oranges
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(grid[i][j]==2){
                    queue.offer(new int[]{i,j});
                }
                else if(grid[i][j]==1){
                    fresh++;
                }
            }
        }
        // If no fresh oranges, return 0
        if(fresh==0) return 0;

        int minutes = -1; //Start from -1 because first round is minute 0
        int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};// right, down, left, up

        //Step 2 BFS
        while(!queue.isEmpty()){
            int size = queue.size();
            minutes++;

            for(int i=0; i<size; i++){
                int[] current = queue.poll();
                int r = current[0];
                int c = current[1];

                for(int[] dir : directions){
                    int nr = r+dir[0];
                    int nc = c+dir[1];

                    //Check bounds and fresh orranges
                    if(nr>=0 && nc >=0 && nr<rows && nc<cols && grid[nr][nc]==1){
                        grid[nr][nc]=2;//Rot it
                        fresh--;
                        queue.offer(new int[]{nr,nc});
                    }
                }
            }
        }

        return fresh==0? minutes: -1;

    }
}
    }
}
