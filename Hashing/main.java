import java.util.Scanner;

public class main{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the size of the array: ");
        int n = input.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i]=input.nextInt();
        }

        //Precompute
        int[] hash = new int[13]; //Lets suppose i know that the maximum element in my array is 12
        for (int i = 0; i < hash.length; i++) {
            hash[i]=0;
        }
        for (int i = 0; i < n; i++) {
            hash[arr[i]]+=1;
        }

        int q=input.nextInt();
        while (q!=0) {
            int number = input.nextInt();
            System.out.println(hash[number]);
            q--;
        }
    }
}