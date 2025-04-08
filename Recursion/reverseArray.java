import java.util.Arrays;
import java.util.Scanner;


public class reverseArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i]=input.nextInt();
        }
        reverse(arr, 0, arr.length-1);
        System.out.print(Arrays.toString(arr));
    }
    public static void reverse(int[] arr, int i, int j){
        if(i<j){
            int temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
            i++;
            j--;
            reverse(arr, i, j);
        }
        else{
            return;
        }
    }
}
