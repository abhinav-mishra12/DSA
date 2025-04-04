
// Given two n x n binary matrices mat and target, return true if it is possible to make mat equal to target by rotating mat in 90-degree increments, or false otherwise.

 

// Example 1:


// Input: mat = [[0,1],[1,0]], target = [[1,0],[0,1]]
// Output: true
// Explanation: We can rotate mat 90 degrees clockwise to make mat equal target.
// Example 2:


// Input: mat = [[0,1],[1,1]], target = [[1,0],[0,1]]
// Output: false
// Explanation: It is impossible to make mat equal to target by rotating mat.
// Example 3:


// Input: mat = [[0,0,0],[0,1,0],[1,1,1]], target = [[1,1,1],[0,1,0],[0,0,0]]
// Output: true
// Explanation: We can rotate mat 90 degrees clockwise two times to make mat equal target.
import java.util.Arrays;
import java.util.Scanner;

public class findRotation {

    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the size of the matrix");
        int n = input.nextInt();
        int[][] mat = new int[n][n];
        System.out.println("Enter the matrix:");
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat.length; j++) {
                mat[i][j]=input.nextInt();
            }
        }

        System.out.println("Enter the target matrix:");
        int[][] target = new int[n][n];
        for (int i = 0; i < target.length; i++) {
            for (int j = 0; j < target.length; j++) {
                target[i][j]=input.nextInt();
            }
        }

        boolean ans = findRotation(mat, target);
        System.out.println(ans);
        input.close();       
    }

    public static boolean findRotation(int[][] mat, int[][] target){
        
        //We can rotate a matrix 4 times in clockwise direction to check 90 180 270 360
        for (int i = 0; i < 4; i++) {
            if (Arrays.deepEquals(mat, target)) {  //checks if the two matrices are identical.

                return true;
            }

            mat = rotate90Degree(mat);            
        }
        return false;
    }

    private static int[][] rotate90Degree(int[][] mat){

        int n = mat.length;
        // Transpose the Matrix
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                int temp = mat[i][j];
                mat[i][j]=mat[j][i];
                mat[j][i]=temp;
            }
        }

        // Reverse Each Row

        for (int i = 0; i < n; i++) {
            int left = 0;
            int right = n-1;
            while (left<right) {
                int temp = mat[i][left];
                mat[i][left] = mat[i][right];
                mat[i][right] = temp;
                left++;
                right--;
            }
        }

        return mat;
    }
}