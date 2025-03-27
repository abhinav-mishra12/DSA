// Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.

// You must do it in place.


// Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
// Output: [[1,0,1],[0,0,0],[1,0,1]]

// Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
// Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]



import java.util.Scanner;

public class setZeroes {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the size of the matrix: ");
        int n = input.nextInt();
        int m = input.nextInt();
        int[][] matrix = new int[n][m];
        setZeroes(matrix);
        input.close();

    }
    public static void setZeroes(int[][] matrix){
        int rows = matrix.length;
        int cols = matrix[0].length;

        boolean firstRowHasZero = false;
        boolean firstColHasZero = false;

        //Check if the first row has zero
        for (int i = 0; i < cols; i++) {
            if (matrix[0][i]==0) {
                firstRowHasZero=true;
                break;
            }
        }

        //Check if the first col has zero
        for (int i = 0; i < rows; i++) {
            if (matrix[i][0]==0) {
                firstColHasZero=true;
                break;
            }
        }

        // Use the first row and col as markers
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j]==0) {
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
            }
        }

        //Set the marked rows to zero
        for (int i = 1; i < rows; i++) {
            if (matrix[i][0]==0) {
                for (int j = 1; j < cols; j++) {
                    matrix[i][j]=0;
                }
            }
        }

        //Set the marked cols to zero
        for (int i = 1; i < cols; i++) {
            if (matrix[0][i]==0) {
                for (int j = 1; j < rows ; j++) {
                    matrix[j][i]=0;
                }
            }
        }

        //Set the first row to zero if needed
        if (firstRowHasZero) {
            for (int i = 0; i < cols; i++) {
                matrix[0][i]=0;
            }
        }

        //Set the first col to zero if needed
        if (firstColHasZero) {
            for (int i = 0; i < rows; i++) {
                matrix[i][0]=0;
            }
        }
    }
}
