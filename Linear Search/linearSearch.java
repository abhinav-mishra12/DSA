import java.util.Scanner;

public class linearSearch{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the size of the array: ");
        int n = input.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i]=input.nextInt();
        }
        System.out.println("Enter the target element: ");
        int target = input.nextInt();
        int ans = linerSearch(arr, target);
        System.out.println(ans);
        input.close();
    }

    public static int linerSearch(int[] arr, int target){
        for (int i = 0; i < arr.length; i++) {
            int element = arr[i];
            if (element==target) {
                return i;
            }
        }
        return -1;
    }
}



