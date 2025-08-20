// Given an array arr of n integers and an integer target, determine if there is a subset of the given array with a sum equal to the given target.


// Examples:
// Input: arr = [1, 2, 7, 3], target = 6

// Output: True

// Explanation: There is a subset (1, 2, 3) with sum 6.

// Input: arr = [2, 3, 5], target = 6

// Output: False

// Explanation: There is no subset with sum 6.
public class subsetSumEqualsToTarget {
    public static void main(String[] args) {
        class Solution {
    public boolean isSubsetSum(int[] arr, int target) {
        int n = arr.length;
        // dp[i][t] = -1 (not calculated), 0 (false), 1 (true)
        int[][] dp = new int[n][target + 1];

        // initialize with -1
        for (int i = 0; i < n; i++) {
            for (int t = 0; t <= target; t++) {
                dp[i][t] = -1;
            }
        }

        return helper(n - 1, target, arr, dp);
    }

    private boolean helper(int idx, int target, int[] arr, int[][] dp) {
        // Base cases
        if (target == 0) return true;               // found subset
        if (idx == 0) return arr[0] == target;      // only one element left

        if (dp[idx][target] != -1) {
            return dp[idx][target] == 1;            // return memoized result
        }

        // Not take
        boolean notTake = helper(idx - 1, target, arr, dp);

        // Take (if element <= target)
        boolean take = false;
        if (arr[idx] <= target) {
            take = helper(idx - 1, target - arr[idx], arr, dp);
        }

        boolean result = take || notTake;
        dp[idx][target] = result ? 1 : 0;
        return result;
    }
}

    }
}
