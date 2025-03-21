// Given a square matrix mat, return the sum of the matrix diagonals.

// Only include the sum of all the elements on the primary diagonal and all the elements on the secondary diagonal that are not part of the primary diagonal.

// Example 1:

// Input: mat = [[1,2,3],
//               [4,5,6],
//               [7,8,9]]
// Output: 25
// Explanation: Diagonals sum: 1 + 5 + 9 + 3 + 7 = 25
// Notice that element mat[1][1] = 5 is counted only once.
// Example 2:

// Input: mat = [[1,1,1,1],
//               [1,1,1,1],
//               [1,1,1,1],
//               [1,1,1,1]]
// Output: 8
// Example 3:

// Input: mat = [[5]]
// Output: 5

import java.util.Arrays;
import java.util.Scanner;

public class diagonalSum {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the length of the matriz:");
        int n = input.nextInt();
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j]=input.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.print(Arrays.toString(matrix[i])+", ");
        }

        int ans = diagonalSum(matrix);
        System.out.println("The diagonal sum of the matrix is: "+ ans);
        input.close();
    }

    static int diagonalSum(int[][] mat){
        int sum = 0;
        int n = mat.length;
        for (int i = 0; i < n; i++) {
            //Add primary elements
            // mat[i][i] → Primary diagonal element. Same row and col elemetns
            sum += mat[i][i];

            // Add secondary diagonal element (if it's not the same as primary diagonal)
            if (i != n-1-i) {
                sum+=mat[i][n-1-i];
            }
        }
        return sum;
    }
}
