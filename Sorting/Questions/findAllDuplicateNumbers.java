// Given an integer array nums of length n where all the integers of nums are in the range [1, n] and each integer appears at most twice, return an array of all the integers that appears twice.

// You must write an algorithm that runs in O(n) time and uses only constant auxiliary space, excluding the space needed to store the output

 

// Example 1:

// Input: nums = [4,3,2,7,8,2,3,1]
// Output: [2,3]
// Example 2:

// Input: nums = [1,1,2]
// Output: [1]
// Example 3:

// Input: nums = [1]
// Output: []

import java.util.ArrayList;
import java.util.List;

public class findAllDuplicateNumbers {
    public static void main(String[] args) {
    class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int[] hash = new int[nums.length];
        for(int i=0; i<hash.length; i++){
            hash[nums[i]-1]+=1;
        }

        int j=0;
        while(j!=hash.length){
            if(hash[j]>1){
                result.add(j+1);
            }
            j++;
        }
        return result;
        }
    }
    }
}
