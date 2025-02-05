import java.util.Arrays;
import java.util.Scanner;

public class Max {
    public static void main(String[] args) {
        int[] arr = new int[5];
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < arr.length; i++) {
            arr[i]=input.nextInt();
        }
        System.out.println(Arrays.toString(arr));
        input.close();

        // int length = arr.length;
        // System.out.println(length);

        int max = Maxx(arr);
        System.out.println(max);
        
    }

    static int Maxx(int[] arr){
        int maximum = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]>maximum) {
                maximum=arr[i];
            }
                       
        }
        return maximum;

    }
}
