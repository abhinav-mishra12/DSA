// Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.

 

// Example 1:

// Input: nums = [1,2,3,4,5,6,7], k = 3
// Output: [5,6,7,1,2,3,4]
// Explanation:
// rotate 1 steps to the right: [7,1,2,3,4,5,6]
// rotate 2 steps to the right: [6,7,1,2,3,4,5]
// rotate 3 steps to the right: [5,6,7,1,2,3,4]
// Example 2:

// Input: nums = [-1,-100,3,99], k = 2
// Output: [3,99,-1,-100]
// Explanation: 
// rotate 1 steps to the right: [99,-1,-100,3]
// rotate 2 steps to the right: [3,99,-1,-100]

import java.util.Arrays;
import java.util.Scanner;

public class rotate {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the size of the array: ");
        int n = input.nextInt();
        System.out.println("Enter the elements of the matriz: ");
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i]=input.nextInt();
        }
        System.out.println("Enter the no of times you want to rotate: ");
        int k=input.nextInt();
        rotate(nums, k);
    }
    public static void rotate(int[] nums, int k){
        // To handle the case when k is greater than the length of the array
        k = k % nums.length;
       
        reverse(nums, 0, nums.length-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length-1);
        System.out.print(Arrays.toString(nums));

    }
    public static void reverse(int[] nums, int start, int end){
        while (start<end) {
            int temp = nums[start];
            nums[start]=nums[end];
            nums[end]=temp;
            start++;
            end--;
        }
    }
}
