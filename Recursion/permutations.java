// Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.

 

// Example 1:

// Input: nums = [1,2,3]
// Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// Example 2:

// Input: nums = [0,1]
// Output: [[0,1],[1,0]]
// Example 3:

// Input: nums = [1]
// Output: [[1]]
import java.util.ArrayList;
import java.util.List;

public class permutations {
    public static void main(String[] args) {
        class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length]; // to mark used elements
        backtrack(nums, new ArrayList<>(), used, result);
        return result;
    }

    private void backtrack(int[] nums, List<Integer> path, boolean[] used, List<List<Integer>> result) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path)); // found a permutation
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue; // skip if already used

            path.add(nums[i]);
            used[i] = true;
            backtrack(nums, path, used, result);
            used[i] = false;
            path.remove(path.size() - 1); // backtrack
        }
    }
}

    }
}
