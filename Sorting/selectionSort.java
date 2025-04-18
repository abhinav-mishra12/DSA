import java.util.Arrays;
import java.util.Scanner;

public class selectionSort {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the size of the array: ");
        int n = input.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i]=input.nextInt();
        }
        selection(arr);
        System.out.println(Arrays.toString(arr));
        input.close();
    }

    public static void selection(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            // Find the max item in the remaining array and swap it with the correct index
            int last = arr.length-i-1;
            int max = getMaxIndex(arr,0,last);
            int temp = arr[max];
            arr[max]=arr[last];
            arr[last]=temp;
        }
    }

    private static int getMaxIndex(int[] arr, int start, int end){
        int max = start;
        for (int i = 0; i <= end; i++) {
            if (arr[max]< arr[i]) {
                max = i;
            }
        }
        return max;
    } 
}
