import java.util.Arrays;
import java.util.Scanner;

public class MultiDimension {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[][] arr = new int[3][3];
        
        //Input
        // arr.length() will give the now of rows of the matrix
        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[row].length; col++) {
                arr[row][col]=input.nextInt();                
            }        
        }


        //Output
        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[row].length; col++) {
                System.out.print(arr[row][col]+" ");
            }
            System.out.println();
        }

        for (int row = 0; row < arr.length; row++) {
               System.out.println(Arrays.toString(arr[row]));
            }
          
            


        input.close();
    }
}
