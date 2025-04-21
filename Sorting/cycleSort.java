
//When no's are given in a range of 1 to N, then we should use cycleSort algorithm.

import java.util.Arrays;
import java.util.Scanner;

public class cycleSort {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the size of the array: ");
        int n = input.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i]=input.nextInt();
        }
        sort(arr);
        System.out.println(Arrays.toString(arr));
        input.close();
    }
    public static void sort(int[] arr){
        int i=0;
        while (i!=arr.length) {
            int correct = arr[i]-1;
            if (arr[i]!=arr[correct]) {
                swap(arr, i, correct);
            }
            else{
                i++;
            }
        }
    }

    public static void swap(int[] arr, int i, int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
