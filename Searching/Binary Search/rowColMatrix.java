// Matrix is sorted row wise and col wise
import java.util.Arrays;

public class rowColMatrix {
    public static void main(String[] args) {
        int[][] arr = {         
            {10, 20, 30, 41},
            {15, 25, 35, 45},
            {28, 29, 37, 49},
            {33, 34, 38, 50}
        };

        System.out.println(Arrays.toString(search(arr, 37)));
    }

    public static int[] search(int[][] arr, int target){
        int r = 0;
        int c = arr.length-1;
        while (r < arr.length && c >= 0) {
            if (arr[r][c]==target) {
                return new int[]{r,c};
            }

            else if (arr[r][c]<target) {
                r++;
            }
            else if (arr[r][c]>target) {
                c--;
            }
        }
        return new int[]{-1,-1};
    }
}
