// Given an array nums of integers, return how many of them contain an even number of digits.

 

// Example 1:

// Input: nums = [12,345,2,6,7896]
// Output: 2
// Explanation: 
// 12 contains 2 digits (even number of digits). 
// 345 contains 3 digits (odd number of digits). 
// 2 contains 1 digit (odd number of digits). 
// 6 contains 1 digit (odd number of digits). 
// 7896 contains 4 digits (even number of digits). 
// Therefore only 12 and 7896 contain an even number of digits.
// Example 2:

// Input: nums = [555,901,482,1771]
// Output: 1 
// Explanation: 
// Only 1771 contains an even number of digits.

import java.util.Arrays;
import java.util.Scanner;

public class findNumbers {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the size of the matrix: ");
        int n = input.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < nums.length; i++) {
            nums[i]=input.nextInt();
        }
        System.out.print(Arrays.toString(nums));
        int ans = findNumbers(nums);
        System.out.println("No of elements with even digit: "+ ans );
    }

    public static int findNumbers(int[] nums){
        int even = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int n = NoOfDigits(num);
            if (n%2==0) {
                even+=1;
            }

        }
        return even;
    }

    public static int NoOfDigits(int n){
        int count = 0;
        while (n!=0) {
            n = n/10;
            count++;
        }
        return count;
    }
}
