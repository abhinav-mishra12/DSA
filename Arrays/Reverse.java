import java.util.Arrays;
import java.util.Scanner;

public class Reverse {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] arr = new int[5];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=input.nextInt();
        }
        System.out.println(Arrays.toString(arr));
        reverse(arr);
        System.out.println(Arrays.toString(arr));

        
        input.close();
    }
    static void reverse(int[] arr){
        int start = 0;
        int end = arr.length-1;
        while (start<end) {
            swap(arr,start,end);
            start++;
            end--;
        }
    }
    static void swap(int[] arr, int index1, int index2){
        int temp = arr[index1];
        arr[index1]=arr[index2];
        arr[index2]=temp;
        
    }

    //Shortcut way
    // static void reverse(int[] arr){
    //     for (int i = arr.length-1; i >= 0; i--) {
    //         System.out.println(arr[i]);
    //     }
    // }
            
}

