import java.util.Arrays;
import java.util.Scanner;

public class bubbleSort{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the size of the array: ");
        int n = input.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i]=input.nextInt();
        }

        bubble(arr);
        System.out.println(Arrays.toString(arr));
        input.close();
    }

    public static void bubble(int[] arr){
        boolean swapped;

        //run the step n-1 times
        for (int i = 0; i < arr.length; i++) {
            swapped=false;
            //for each step, max item will come at last respective index
            for (int j = 1; j < arr.length-1; j++) {
                //swap if the item is smaller than the previous item
                if (arr[j]<arr[j-1]) {
                    //swap
                    int temp=arr[j];
                    arr[j]=arr[j-1];
                    arr[j-1]=temp;
                    swapped=true;
                }
            }
            //if we did not swap for a particular value of i(pass), it means the array is sorted hence stop the program
            if (swapped!=true) {
                break;
            }
        }
    }
}