package Arrays;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] arr = new int[5];
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < arr.length; i++) {
            arr[i]=input.nextInt();
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]+" ");
        }
        input.close();
    }
}
