// Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.

// The distance between two cells sharing a common edge is 1.

 

// Example 1:


// Input: mat = [[0,0,0],[0,1,0],[0,0,0]]
// Output: [[0,0,0],[0,1,0],[0,0,0]]
// Example 2:


// Input: mat = [[0,0,0],[0,1,0],[1,1,1]]
// Output: [[0,0,0],[0,1,0],[1,2,1]]
import java.util.LinkedList;
import java.util.Queue;

public class zeroOneMatrix {

    public static void main(String[] args) {
        class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;

        Queue<int[]> queue = new LinkedList<>();
        // Step 1: Add all 0s to queue and mark 1s as "infinite"
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(mat[i][j]==0){
                    queue.offer(new int[]{i,j});
                }
                else {
                    mat[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        int[][] directions = {{0,1},{1,0},{-1,0},{0,-1}};

        // Step 2: BFS
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int r = current[0];
            int c = current[1];

            for(int[] dir : directions){
                int nr = r+dir[0];
                int nc = c+dir[1];

                if(nr>=0 && nc>=0 && nc<cols && nr<rows){
                    //If new distance is shorter
                    if(mat[nr][nc]>mat[r][c]+1){
                        mat[nr][nc] = mat[r][c]+1;
                        queue.offer(new int[]{nr,nc});
                    }
                }
            }
        }

        return mat;
        


    }
}
    }
}