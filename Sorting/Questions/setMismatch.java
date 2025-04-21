// You have a set of integers s, which originally contains all the numbers from 1 to n. Unfortunately, due to some error, one of the numbers in s got duplicated to another number in the set, which results in repetition of one number and loss of another number.

// You are given an integer array nums representing the data status of this set after the error.

// Find the number that occurs twice and the number that is missing and return them in the form of an array.

 

// Example 1:

// Input: nums = [1,2,2,4]
// Output: [2,3]
// Example 2:

// Input: nums = [1,1]
// Output: [1,2]
public class setMismatch {
    public static void main(String[] args) {
        class Solution {
            public int[] findErrorNums(int[] nums) {
                int[] result = new int[2];
                int[] hash = new int[nums.length];
                for(int i=0; i<hash.length; i++){
                    hash[nums[i]-1]+=1;
                }
        
                 // Find duplicate and missing
                for (int i = 0; i < hash.length; i++) {
                    if (hash[i] == 2) {
                        result[0] = i + 1; // duplicate
                    } else if (hash[i] == 0) {
                        result[1] = i + 1; // missing
                    }
                }
                return result;
            }
        }
    }
}
