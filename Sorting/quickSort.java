import java.util.Arrays;
import java.util.Scanner;

public class quickSort {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the size of the array: ");
        int n = input.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i]=input.nextInt();
        }
        quickSorting(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
        input.close();
    }

    public static void quickSorting(int[] arr, int low, int high){
        if (low>=high) {
            return;
        }

        int s = low;
        int e = high;
        int mid = s+(e-s)/2;
        int pivot = arr[mid];

        while (s<=e) {
            while (arr[s]<pivot) {
                s++;
            }
            while (arr[e]>pivot) {
                e--;
            }

            if (s<=e) {
                int temp = arr[s];
                arr[s]=arr[e];
                arr[e]=temp;
                s++;
                e--;
            }
        }
        // Now my pivot is at correct position so we sort it into two halves
        quickSorting(arr, low, e);
        quickSorting(arr, s, high);
    }
}
