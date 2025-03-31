// Given an unsorted integer array nums. Return the smallest positive integer that is not present in nums.

// You must implement an algorithm that runs in O(n) time and uses O(1) auxiliary space.

 

// Example 1:

// Input: nums = [1,2,0]
// Output: 3
// Explanation: The numbers in the range [1,2] are all in the array.
// Example 2:

// Input: nums = [3,4,-1,1]
// Output: 2
// Explanation: 1 is in the array but 2 is missing.
// Example 3:

// Input: nums = [7,8,9,11,12]
// Output: 1
// Explanation: The smallest positive integer 1 is missing.

import java.util.Scanner;

public class firstMissingPositive {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the size of the matrix: ");
        int n = input.nextInt();
        int[] nums = new int[n];
        System.out.println("Enter the elements of the matrix: ");
        for (int i = 0; i < n; i++) {
            nums[i]=input.nextInt();
        }
        int ans = firstMissingPositive(nums);
        System.out.println(ans);
    }
    private static void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
    public static int firstMissingPositive(int[] nums){


        //Optimize way 
        int n = nums.length;
        int i = 0;
        while (i < n) {
            int correctIndex = nums[i] - 1;
            if (nums[i] > 0 && nums[i] <= n && nums[i] != nums[correctIndex]) {
                swap(nums, i, correctIndex);
            } 
            else {
                i++;
            }
        }
        for (i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return n + 1;
       
    }

    
}


//Time limit is exceeding with this approach
        // int n = nums.length;
        // int ans=Integer.MIN_VALUE;
        
        // for(int i=1; i<=n; i++){
        //     boolean found=false;
        //     for(int j=0; j<n; j++){
        //         if(i==nums[j]){
        //             found=true;
        //             break;
        //         }
        //     }

        //     if(!found){
        //         ans=i;
        //         break;
        //     }
        // }
        // if(ans==Integer.MIN_VALUE){
        //     ans=n+1;
        // }

        // return ans;