// Given an m x n matrix, return all elements of the matrix in spiral order.

 

// Example 1:


// Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
// Output: [1,2,3,6,9,8,7,4,5]


// Example 2:


// Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
// Output: [1,2,3,4,8,12,11,10,9,5,6,7]

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class spiralOrder {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the size of the matrix: ");
        int n = input.nextInt();
        int m = input.nextInt();
        int[][] matrix = new int[n][m];
        System.out.println("Enter the elements of the matrix: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j]=input.nextInt();
            }
        }

        List<Integer> ans = spiralOrder(matrix);
        System.out.println(ans);
        input.close();
    }

    public static List<Integer> spiralOrder(int[][] matrix){
        List<Integer> ans = new ArrayList<>();
        int rowBegin=0;
        int colBegin=0;
        int colEnd=matrix[0].length-1;
        int rowEnd=matrix.length-1;

        while (rowBegin<=rowEnd && colBegin<=colEnd) {
            
            //Traverse Right
            for (int j = colBegin; j <= colEnd; j++) {
                ans.add(matrix[rowBegin][j]);
            }
            rowBegin++;

            //Traverse Down
            for (int j = rowBegin; j <= rowEnd; j++) {
                ans.add(matrix[j][colEnd]);
            }
            colEnd--;

            //Traverse Left
            if (rowBegin<=rowEnd) {
                for (int j = colEnd; j >= colBegin; j--) {
                    ans.add(matrix[rowEnd][j]);
                }
            }
            rowEnd--;

            //Traverse up
            if (colBegin<=colEnd) {
                for (int j = rowEnd; j >= rowBegin; j--) {
                    ans.add(matrix[j][colBegin]);
                }
            }
            colBegin++;
        }
        return ans;
    }
       
}