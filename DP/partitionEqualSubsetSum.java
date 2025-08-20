public class partitionEqualSubsetSum {
    public static void main(String[] args) {
        class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;

        // Step 1: Find total sum
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        // Step 2: If sum is odd, partition is impossible
        if (totalSum % 2 != 0) {
            return false;
        }

        int target = totalSum / 2;

        // Step 3: Memoization table
        Boolean[][] dp = new Boolean[n][target + 1];

        // Step 4: Start recursion
        return helper(n - 1, target, nums, dp);
    }

    private boolean helper(int index, int target, int[] nums, Boolean[][] dp) {
        // Base case 1: if target == 0, subset found
        if (target == 0) {
            return true;
        }

        // Base case 2: if only one element left
        if (index == 0) {
            return nums[0] == target;
        }

        // Check memo table
        if (dp[index][target] != null) {
            return dp[index][target];
        }

        // Choice 1: Do not take current element
        boolean notTake = helper(index - 1, target, nums, dp);

        // Choice 2: Take current element (if <= target)
        boolean take = false;
        if (nums[index] <= target) {
            take = helper(index - 1, target - nums[index], nums, dp);
        }

        // Store and return
        if (take || notTake) {
            dp[index][target] = true;
        } else {
            dp[index][target] = false;
        }

        return dp[index][target];
    }
}

    }
}
