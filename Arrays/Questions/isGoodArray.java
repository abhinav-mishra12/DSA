// Given an array nums of positive integers. Your task is to select some subset of nums, multiply each element by an integer and add all these numbers. The array is said to be good if you can obtain a sum of 1 from the array by any possible subset and multiplicand.

// Return True if the array is good otherwise return False.

 

// Example 1:

// Input: nums = [12,5,7,23]
// Output: true
// Explanation: Pick numbers 5 and 7.
// 5*3 + 7*(-2) = 1
// Example 2:

// Input: nums = [29,6,10]
// Output: true
// Explanation: Pick numbers 29, 6 and 10.
// 29*1 + 6*(-3) + 10*(-1) = 1
// Example 3:

// Input: nums = [3,6]
// Output: false

import java.util.Scanner;

public class isGoodArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the size of the nums: ");
        int n = input.nextInt();
        int[] nums = new int[n];
        System.out.println("Enter the elements of the nums: ");
        for (int i = 0; i < n; i++) {
            nums[i]=input.nextInt();
        }
        isGoodArray(nums);
        
    }
    public static void isGoodArray(int[] nums){
        boolean ans=false;
        int result=nums[0];
        for(int i=1; i<nums.length; i++){
            result=gcd(result,nums[i]);
        }
        if (result==1) {
            ans=true;
        }
        System.out.println(ans);
    }

    public static int gcd(int a, int b){
        if (a==0) {
            return b;
        }
        else{
            return gcd(b%a, a);
        }
    }
}
