// Given an m x n matrix of distinct numbers, return all lucky numbers in the matrix in any order.

// A lucky number is an element of the matrix such that it is the minimum element in its row and maximum in its column.

 

// Example 1:

// Input: matrix = [[3,7,8],[9,11,13],[15,16,17]]
// Output: [15]
// Explanation: 15 is the only lucky number since it is the minimum in its row and the maximum in its column.
// Example 2:

// Input: matrix = [[1,10,4,2],[9,3,8,7],[15,16,17,12]]
// Output: [12]
// Explanation: 12 is the only lucky number since it is the minimum in its row and the maximum in its column.
// Example 3:

// Input: matrix = [[7,8],[1,2]]
// Output: [7]
// Explanation: 7 is the only lucky number since it is the minimum in its row and the maximum in its column.

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class luckyNumbers{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the size of the matrix (rows and columns): ");
        int n = input.nextInt();
        int m = input.nextInt();
        int[][] mat = new int[n][m];

        System.out.println("Enter the elements of the matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                mat[i][j] = input.nextInt();
            }
        }

        List<Integer> ans = luckyNumbers(mat);
        System.out.println("Lucky numbers: " + ans);
        input.close();
    }

    public static List<Integer> luckyNumbers(int[][] matrix) {
        List<Integer> luckyNumbers = new ArrayList<>();
        int r = matrix.length;
        int c = matrix[0].length;

        int[] minRow = new int[r]; // Store min values for each row
        int[] maxCol = new int[c]; // Store max values for each column

        // Find minimum in each row
        for (int i = 0; i < r; i++) {
            minRow[i] = minimumInRow(matrix[i]);
        }

        // Find maximum in each column
        for (int j = 0; j < c; j++) {
            maxCol[j] = maximumInCol(matrix, j);
        }

        // Find all common elements (lucky numbers)
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (matrix[i][j] == minRow[i] && matrix[i][j] == maxCol[j]) {
                    luckyNumbers.add(matrix[i][j]);
                }
            }
        }

        return luckyNumbers;
    }

    public static int minimumInRow(int[] row) {
        int minimum = row[0];
        for (int num : row) {
            if (num < minimum) {
                minimum = num;
            }
        }
        return minimum;
    }

    public static int maximumInCol(int[][] mat, int colIndex) {
        int maximum = mat[0][colIndex];
        for (int i = 1; i < mat.length; i++) {
            if (mat[i][colIndex] > maximum) {
                maximum = mat[i][colIndex];
            }
        }
        return maximum;
    }
}

// import java.util.ArrayList;
// import java.util.Arrays;
// import java.util.Scanner;
// import java.util.List;


// public class luckyNumbers {
//     public static void main(String[] args) {
//         Scanner input = new Scanner(System.in);
//         System.out.println("Enter the size of the array: ");
//         int n = input.nextInt();
//         int m = input.nextInt();
//         int[][] mat = new int[n][m];
//         for (int i = 0; i < n; i++) {
//             for (int j = 0; j < m; j++) {
//                 mat[i][j]=input.nextInt();
//             }
//         }

//         List<Integer> ans = luckyNumbers(mat);

//         System.out.println(ans);
//         input.close();
//     }



//     public static List<Integer> luckyNumbers(int[][] matrix){
//         List<Integer> luckyNumbers = new ArrayList<>();
//         int r = matrix.length;
//         int c = matrix[0].length;
        
//         int[] minRow = new int[r];
//         int[] maxCol = new int[c];
        
//         for (int i = 0; i < r; i++) {
//             minRow[i]=minimumInRow(matrix[i]);
//         }

//         for (int i = 0; i < c; i++) {
//             maxCol[i]=maximumInCol(matrix);
//         }

//         int ans = common(minRow, maxCol);
//         luckyNumbers.add(ans);
//         return luckyNumbers; 
        
//     }

//     public static int minimumInRow(int[] mat){
//         int minimumR=mat[0];
//         for (int i = 1; i < mat.length; i++) {
//             if (mat[i]<minimumR) {
//                 minimumR=mat[i];
//             }
//         }
//         return minimumR;
//     }

//     public static int maximumInCol(int[][] mat){
//         int n = mat[0].length;
//         int maximumC=mat[0][0];
//         for (int j = 0; j < n; j++) {
//             for (int i = 0; i < mat.length; i++) {
//                 if (mat[i][j]>maximumC) {
//                     maximumC=mat[i][j];
//                 }
//             }
            
//         }
//         return maximumC;
//     }

//     public static int common(int[] arr, int[] array){
        
//         for (int i = 0; i < arr.length; i++) {
//             for (int j = 0; j < array.length; j++) {
//                 if(arr[i]==array[j]){
//                     return arr[i];
                    
//                 }
//             }
//         }

        
        
//     }
// }
