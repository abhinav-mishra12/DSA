import java.util.Scanner;

public class missingNo{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the size of the array: ");
        int x = input.nextInt();
        int[] arr = new int[x];
        for ( int i = 0; i < x; i++) {
            arr[i]=input.nextInt();
        }
        int ans = missingNumber(arr);
        System.out.println("The missing number from the given array is: "+ans);
        input.close();
    }
    public static int missingNumber(int[] arr){
        int n = arr.length;
        int[] hash = new int[n+1];
        for (int i = 0; i < n; i++) {
            hash[arr[i]]+=1;
        }
        for (int i = 0; i < hash.length; i++) {
            if (hash[i]==0) {
                return i;
            }
        }

        return -1; // fallback; theoretically should never hit this
    }
}


