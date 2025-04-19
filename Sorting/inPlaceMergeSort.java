import java.util.Arrays;
import java.util.Scanner;

public class inPlaceMergeSort {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the size of the array: ");
        int n = input.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i]=input.nextInt();
        }
        mergeSort(arr, 0, arr.length);
        System.out.println(Arrays.toString(arr));
        input.close();
    }
    public static void mergeSort(int[] arr, int s, int e){
        if (e-s==1) {
            return;
        }
        int mid = (s+e)/2;

        mergeSort(arr, s, mid);
        mergeSort(arr, mid, e);

        merge(arr, s, mid, e);
    }

    private static void merge(int[] arr, int s, int m, int e){
        int[] mix = new int[e-s];

        int i=s;
        int j=m;
        int k=0;

        while (i<m && j<e) {
            if (arr[i]<arr[j]) {
                mix[k]=arr[i];
                i++;
            }
            else{
                mix[k]=arr[j];
                j++;
            }
            k++;
        }

        // It may be possible that one of the arrays is not complete
        while (i<m) {
            mix[k]=arr[i];
            i++;
            k++;
        }

        while (j<e) {
            mix[k]=arr[j];
            j++;
            k++;
        }

        for (int k2 = 0; k2 < mix.length; k2++) {
            arr[s+k2]=mix[k2];
        }

    }
}
