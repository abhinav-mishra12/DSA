// Given an array nums of n integers where nums[i] is in the range [1, n], return an array of all the integers in the range [1, n] that do not appear in nums.

 

// Example 1:

// Input: nums = [4,3,2,7,8,2,3,1]
// Output: [5,6]
// Example 2:

// Input: nums = [1,1]
// Output: [2]

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class findAllDisappearedNumbers {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the size of the array: ");
        int n = input.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i]=input.nextInt();
        }
        
        List<Integer> ans = findDisappearedNumbers(nums);
        System.out.println("The missing elements arr: "+ ans);
        input.close();
    }

    public static List<Integer> findDisappearedNumbers(int[] nums){
        List<Integer> result = new ArrayList<>();
        int i=0;
        while(i!=nums.length){
            int correct=nums[i]-1;
            if (nums[i]!=nums[correct]) {
                swap(nums, i, correct);
            }
            else{
                i++;
            }
        }

        for(int j=0; j<nums.length; j++){
            if(nums[j]!=j+1){
                result.add(j+1);
            }
        }
            return result;

    }
    
    public static void swap(int[] arr, int i, int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}

