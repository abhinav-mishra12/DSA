// You start at the cell (rStart, cStart) of an rows x cols grid facing east. The northwest corner is at the first row and column in the grid, and the southeast corner is at the last row and column.

// You will walk in a clockwise spiral shape to visit every position in this grid. Whenever you move outside the grid's boundary, we continue our walk outside the grid (but may return to the grid boundary later.). Eventually, we reach all rows * cols spaces of the grid.

// Return an array of coordinates representing the positions of the grid in the order you visited them.

 

// Example 1:


// Input: rows = 1, cols = 4, rStart = 0, cStart = 0
// Output: [[0,0],[0,1],[0,2],[0,3]]
// Example 2:


// Input: rows = 5, cols = 6, rStart = 1, cStart = 4
// Output: [[1,4],[1,5],[2,5],[2,4],[2,3],[1,3],[0,3],[0,4],[0,5],[3,5],[3,4],[3,3],[3,2],[2,2],[1,2],[0,2],[4,5],[4,4],[4,3],[4,2],[4,1],[3,1],[2,1],[1,1],[0,1],[4,0],[3,0],[2,0],[1,0],[0,0]]

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class spiral3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the size of the array: ");
        int r = input.nextInt();
        int c = input.nextInt();
        System.out.println("Enter rStart and cStart: ");
        int rStart = input.nextInt();
        int cStart = input.nextInt();

        int[][] mat = spiralMatrixIII(r,c,rStart,cStart);
        System.out.print(mat);
        input.close();

    }

    public static int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart){
        int n = rows*cols;
        int[][] res = new int[n][2];
        int directions[][] = {{0,1}, {1,0}, {0,-1}, {-1,0}};
        res[0][0]=rStart;
        res[0][1]=cStart;
        int step=1;
        int index=0;
        int count=1;
        while (count<n) {
            for (int times = 0; times < 2; times++) {
                int dr = directions[index%4][0];
                int dc = directions[index%4][1];
                for (int i = 0; i < step; i++) {
                    rStart+=dr;
                    cStart+=dc;
                    if (rStart>=0 && rStart<rows && cStart>=0 && cStart<cols) {
                        res[count][0]=rStart;
                        res[count][1]=cStart;
                        count++;
                    }
                }
                index++;
            }
            step++;
        }
        return res;
    }


    
}
