// Given an integer array nums that may contain duplicates, return all possible subsets (the power set).

// The solution set must not contain duplicate subsets. Return the solution in any order.

 

// Example 1:

// Input: nums = [1,2,2]
// Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
// Example 2:

// Input: nums = [0]
// Output: [[],[0]]

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class subset2 {
    public static void main(String[] args) {
        class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // Step 1: sort to handle duplicates
        backtrack(0, nums, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int index, int[] nums, List<Integer> path, List<List<Integer>> result) {
        result.add(new ArrayList<>(path)); // Always add current subset

        for (int i = index; i < nums.length; i++) {
            // Step 2: Skip duplicates
            if (i > index && nums[i] == nums[i - 1]) continue;

            path.add(nums[i]);
            backtrack(i + 1, nums, path, result); // i + 1: no reuse of element
            path.remove(path.size() - 1); // Backtrack
        }
    }
}

    }
}
