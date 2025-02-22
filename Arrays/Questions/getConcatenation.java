// Given an integer array nums of length n, you want to create an array ans of length 2n where ans[i] == nums[i] and ans[i + n] == nums[i] for 0 <= i < n (0-indexed).

// Specifically, ans is the concatenation of two nums arrays.

// Return the array ans.

 

// Example 1:

// Input: nums = [1,2,1]
// Output: [1,2,1,1,2,1]
// Explanation: The array ans is formed as follows:
// - ans = [nums[0],nums[1],nums[2],nums[0],nums[1],nums[2]]
// - ans = [1,2,1,1,2,1]
// Example 2:

// Input: nums = [1,3,2,1]
// Output: [1,3,2,1,1,3,2,1]
// Explanation: The array ans is formed as follows:
// - ans = [nums[0],nums[1],nums[2],nums[3],nums[0],nums[1],nums[2],nums[3]]
// - ans = [1,3,2,1,1,3,2,1]

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;
public class getConcatenation {
    public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      ArrayList<Integer> nums = new ArrayList<>(4);
      for (int i = 0; i < 4; i++) {
        nums.add(input.nextInt());
      }

      // Convert ArrayList to int[] (array)
      int[] numsArray = new int[nums.size()];
      for (int i = 0; i < nums.size(); i++) {
          numsArray[i] = nums.get(i);
      }
      
      // Call the concat method
      int[] ans = concat(numsArray);
      
      System.out.print(Arrays.toString(ans));        

      input.close();

    }

    public static int[] concat(int[] nums){
        int[] ans = new int[2*nums.length];
        for (int i = 0; i < nums.length; i++) {
          ans[i]=nums[i]; 
          ans[i+nums.length]=nums[i];
        }
        return ans;
    }
}
