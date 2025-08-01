// Find all valid combinations of k numbers that sum up to n such that the following conditions are true:

// Only numbers 1 through 9 are used.
// Each number is used at most once.
// Return a list of all possible valid combinations. The list must not contain the same combination twice, and the combinations may be returned in any order.

 

// Example 1:

// Input: k = 3, n = 7
// Output: [[1,2,4]]
// Explanation:
// 1 + 2 + 4 = 7
// There are no other valid combinations.
// Example 2:

// Input: k = 3, n = 9
// Output: [[1,2,6],[1,3,5],[2,3,4]]
// Explanation:
// 1 + 2 + 6 = 9
// 1 + 3 + 5 = 9
// 2 + 3 + 4 = 9
// There are no other valid combinations.
// Example 3:

// Input: k = 4, n = 1
// Output: []
// Explanation: There are no valid combinations.
// Using 4 different numbers in the range [1,9], the smallest sum we can get is 1+2+3+4 = 10 and since 10 > 1, there are no valid combination.
import java.util.ArrayList;
import java.util.List;

public class combinationSum3 {

    public static void main(String[] args) {
        class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(1, k, n, new ArrayList<>(), ans);
        return ans;
    }

    private void backtrack(int start, int k, int target, List<Integer> path, List<List<Integer>> ans) {
        if (target == 0 && path.size() == k) {
            ans.add(new ArrayList<>(path));
            return;
        }
        if (target < 0 || path.size() > k) {
            return;
        }

        for (int i = start; i <= 9; i++) {
            path.add(i);
            backtrack(i + 1, k, target - i, path, ans);
            path.remove(path.size() - 1);
        }
    }
}

    }
}