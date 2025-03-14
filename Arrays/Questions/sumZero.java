// Given an integer n, return any array containing n unique integers such that they add up to 0.

 

// Example 1:

// Input: n = 5
// Output: [-7,-1,1,3,4]
// Explanation: These arrays also are accepted [-5,-1,1,2,3] , [-3,-1,2,-2,4].
// Example 2:

// Input: n = 3
// Output: [-1,0,1]
// Example 3:

// Input: n = 1
// Output: [0]
import java.util.Arrays;
import java.util.Scanner;

public class sumZero {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the size of the array: ");
        int n = input.nextInt();
        int[] arr = new int[n];        
        arr=sumZero(n);
        System.out.println(Arrays.toString(arr));
        input.close();
        

    }

    public static int[] sumZero(int n){
        System.out.println("Enter the elements of the array: ");
        int arr[]=new int[n];
        arr[0]=n/2;
        int sum=arr[0];
        for (int i = 1; i < n-1; i++) {
            arr[i]=n/2+arr[i-1];
            sum+=arr[i];
        }
        arr[n-1]=-sum;

        return arr;
    }
}

