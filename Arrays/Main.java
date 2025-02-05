import java.util.Arrays;
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
        System.out.println(Arrays.toString(arr));
        

        String[] str = new String[4];
        for (int i = 0; i < str.length; i++) {
            str[i]=input.next();
        }
        System.out.println(Arrays.toString(str));

        //Modify
        str[2]="Abhinav";
        System.out.println(Arrays.toString(str));
        input.close();

        //Passing Functions
        int[] Arr = {0,1,2,3,4,5};
        System.out.println(Arrays.toString(Arr));
        change(Arr);

        
        

    }
    static void change(int[] arr){
        arr[0]=99;
    }
}
