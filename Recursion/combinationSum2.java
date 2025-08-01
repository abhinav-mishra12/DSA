// Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.

// Each number in candidates may only be used once in the combination.

// Note: The solution set must not contain duplicate combinations.

 

// Example 1:

// Input: candidates = [10,1,2,7,6,1,5], target = 8
// Output: 
// [
// [1,1,6],
// [1,2,5],
// [1,7],
// [2,6]
// ]
// Example 2:

// Input: candidates = [2,5,2,1,2], target = 5
// Output: 
// [
// [1,2,2],
// [5]
// ]
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class combinationSum2 {
    public static void main(String[] args) {
        class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates); // Step 1: sort to handle duplicates
        backtrack(0, candidates, target, new ArrayList<>(), ans);
        return ans;
    }

    private void backtrack(int index, int[] candidates, int target, List<Integer> path, List<List<Integer>> ans) {
        if (target == 0) {
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            // Step 2: Skip duplicates
            if (i > index && candidates[i] == candidates[i - 1]) continue;

            if (candidates[i] > target) break; // Early pruning

            path.add(candidates[i]);
            backtrack(i + 1, candidates, target - candidates[i], path, ans); // Move to next index
            path.remove(path.size() - 1); // Backtrack
        }
    }
}

    }
}
