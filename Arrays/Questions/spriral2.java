// Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.

 

// Example 1:


// Input: n = 3
// Output: [[1,2,3],[8,9,4],[7,6,5]]
// Example 2:

// Input: n = 1
// Output: [[1]]

import java.util.Arrays;
import java.util.Scanner;

public class spriral2 {
    public static void main(String[] args) {
       Scanner input = new Scanner(System.in);
       System.out.println("Enter the value of n: ");
       int n = input.nextInt();
       int[][] natrix = generateMatrix(n);
       for (int i = 0; i < n; i++) {
        System.out.print(Arrays.toString(natrix[i]));    
       }    
       input.close();;

    }

    public static int[][] generateMatrix(int n){
        int[][] matrix = new int[n][n];
        int rowBegin=0;
        int colBegin=0;
        int colEnd=n-1;
        int rowEnd=n-1;
        int element = 1;

        while (rowBegin<=rowEnd && colBegin<=colEnd){
            
            //Traverse Right
            for (int i = colBegin; i <= colEnd; i++) {
                matrix[rowBegin][i]=element;
                element++;
            }
            rowBegin++;

             //Traverse Down
            for (int i = rowBegin; i <= rowEnd; i++) {
                matrix[i][colEnd]=element;
                element++;
            }
            colEnd--;

            //Traverse Left
            if (rowBegin<=rowEnd) {
                for (int i = colEnd; i >= colBegin; i--) {
                    matrix[rowEnd][i]=element;
                    element++;
                }
            }
            rowEnd--;

            //Traverse up
            if (colBegin<=colEnd) {
                for (int i = rowEnd; i >= rowBegin; i--){
                    matrix[i][colBegin]=element;
                    element++;
                }
            }
            colBegin++;

        }

        return matrix;
    }
}
