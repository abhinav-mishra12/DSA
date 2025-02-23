// Given an array nums. We define a running sum of an array as runningSum[i] = sum(nums[0]…nums[i]).

// Return the running sum of nums.

 

// Example 1:

// Input: nums = [1,2,3,4]
// Output: [1,3,6,10]
// Explanation: Running sum is obtained as follows: [1, 1+2, 1+2+3, 1+2+3+4].
// Example 2:

// Input: nums = [1,1,1,1,1]
// Output: [1,2,3,4,5]
// Explanation: Running sum is obtained as follows: [1, 1+1, 1+1+1, 1+1+1+1, 1+1+1+1+1].
// Example 3:

// Input: nums = [3,1,2,10,1]
// Output: [3,4,6,16,17]


import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
public class runningSum {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Integer> nums = new ArrayList<>(5);
        for (int i = 0; i < 5; i++) {
            nums.add(input.nextInt());
        }

        //Convert ArrayList into int[] array 
        int[] numsArray = new int[nums.size()];
        for (int i = 0; i < nums.size(); i++) {
            numsArray[i]=nums.get(i);
        }

        //Call the method
        int[] ans = runningSum(numsArray);
        System.out.print(Arrays.toString(ans));
        
        input.close();
    }

    public static int[] runningSum(int[] nums){
        int[] runningSum = new int[nums.length];
        runningSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            runningSum[i] = runningSum[i - 1] + nums[i];
        }
        
        return runningSum;
        
    }
}
