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
        int n = input.nextInt();
        int m = input.nextInt();
        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j]=input.nextInt();
            }
        }

        List<Integer> ans = spiralOrder(matrix);
        System.out.println(ans);

    }

    
        public static List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> res = new ArrayList<>();
            int top = 0, bottom = matrix.length - 1;
            int left = 0, right = matrix[0].length - 1;
    
            while (top <= bottom && left <= right) {
                // Top row
                for (int i = left; i <= right; i++) {
                    res.add(matrix[top][i]);
                }
                top++;
    
                // Right column
                for (int i = top; i <= bottom; i++) {
                    res.add(matrix[i][right]);
                }
                right--;
    
                if (top <= bottom) {
                    // Bottom row
                    for (int i = right; i >= left; i--) {
                        res.add(matrix[bottom][i]);
                    }
                    bottom--;
                }
    
                if (left <= right) {
                    // Left column
                    for (int i = bottom; i >= top; i--) {
                        res.add(matrix[i][left]);
                    }
                    left++;
                }
            }
            return res;
        }
    
}