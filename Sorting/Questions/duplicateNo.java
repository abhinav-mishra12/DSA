// Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.

// There is only one repeated number in nums, return this repeated number.

// You must solve the problem without modifying the array nums and using only constant extra space.

 

// Example 1:

// Input: nums = [1,3,4,2,2]
// Output: 2
// Example 2:

// Input: nums = [3,1,3,4,2]
// Output: 3
// Example 3:

// Input: nums = [3,3,3,3,3]
// Output: 3
public class duplicateNo {
    public static void main(String[] args) {
        class Solution {
            public int findDuplicate(int[] nums) {
                int[] hash = new int[nums.length];
                for(int i=0; i<nums.length; i++){
                    hash[nums[i]-1]+=1;
                }
                for(int i=0; i<nums.length; i++){
                    if(hash[i]>1){
                        return i+1;
                    }
                }
                return -1;
            }
        }
    }
}
