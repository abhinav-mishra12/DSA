// Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

// The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

// You must write an algorithm that runs in O(n) time and without using the division operation.

 

// Example 1:

// Input: nums = [1,2,3,4]
// Output: [24,12,8,6]
// Example 2:

// Input: nums = [-1,1,0,-3,3]
// Output: [0,0,9,0,0]



import java.util.Arrays;
import java.util.Scanner;

public class productExceptSelf {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the size of the array: ");
        int n = input.nextInt();
        System.out.println("Enter the elements of the array: ");
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i]=input.nextInt();
        }
        int[] ans = new int[n];
        ans=productExceptSelf(nums);
        System.out.println(Arrays.toString(ans));
    
    }

    public static int[] productExceptSelf(int[] nums){
        int[] ans = new int[nums.length];

        //Array to store all left multiplications
        int[] leftProduct = new int[nums.length];

        //Array to store all right multiplications
        int[] rightProduct = new int[nums.length];        
        

        //Left multiplications
        leftProduct[0]=1;
        for (int i = 1; i < rightProduct.length; i++) {
            leftProduct[i]=leftProduct[i-1]*nums[i-1];
        }

        //Right multiplication
        rightProduct[nums.length-1]=1;
        for (int i = rightProduct.length-2; i >= 0 ; i--) {
            rightProduct[i]=rightProduct[i+1]*nums[i+1];
        }

        for (int i = 0; i < ans.length; i++) {
            ans[i]=leftProduct[i]*rightProduct[i];
        }

        
        
        return ans;

    }
}
