import java.util.Arrays;
import java.util.Scanner;

public class mergeSort {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the size of the array: ");
        int n = input.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i]=input.nextInt();
        }
        int[] array = mergeSort(arr);
        System.out.println(Arrays.toString(array));
        input.close();
    }
    public static int[] mergeSort(int[] arr){
        if (arr.length==1) {
            return arr;
        }
        int mid = arr.length/2;

        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid));
        int[] right = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));

        return merge(left,right);
    }

    private static int[] merge(int[] left, int[] right){
        int[] mix = new int[left.length+right.length];

        int i=0;
        int j=0;
        int k=0;

        while (i<left.length && j<right.length) {
            if (left[i]<right[j]) {
                mix[k]=left[i];
                i++;
            }
            else{
                mix[k]=right[j];
                j++;
            }
            k++;
        }

        // It may be possible that one of the arrays is not complete
        while (i<left.length) {
            mix[k]=left[i];
            i++;
            k++;
        }

        while (j<right.length) {
            mix[k]=right[j];
            j++;
            k++;
        }

        return mix;
    }
}
