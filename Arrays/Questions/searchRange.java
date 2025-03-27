// Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.

// If target is not found in the array, return [-1, -1].

// You must write an algorithm with O(log n) runtime complexity.

 

// Example 1:

// Input: nums = [5,7,7,8,8,10], target = 8
// Output: [3,4]
// Example 2:

// Input: nums = [5,7,7,8,8,10], target = 6
// Output: [-1,-1]
// Example 3:

// Input: nums = [], target = 0
// Output: [-1,-1]

import java.util.Arrays;
import java.util.Scanner;

public class searchRange {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter size of the array: ");
        int n = input.nextInt();
        int[] nums = new int[n];
        System.out.println("Enter elements: ");
        for (int i = 0; i < n; i++) {
            nums[i]=input.nextInt();
        }
        System.out.println("Enter the target element: ");
        int target = input.nextInt();

        int[] ans = searchRange(nums, target);
        System.out.println(Arrays.toString(ans));
    }

    public static int[] searchRange(int[] nums, int target){
        int ans[] = new int[2];
        ans[0]=-1;
        ans[1]=-1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]==target) {
                ans[0]=i;
                break;                
            }  
        }

        if (ans[0]!=-1) {
            for (int j = nums.length-1; j >= 0; j--) {
                if (nums[j]==target) {
                    ans[1]=j;
                    break;
                    
                }
                
            }
        }
        return ans;
    }
}
