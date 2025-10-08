public class houseRobber {
    public static void main(String[] args) {
        class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        for(int i=0; i<n; i++){
            dp[i]=-1;
        }
        int i = n-1;
        return helper(nums, i, dp);
    }

    public int helper(int[] nums, int i, int[] dp){
        if(i==0){
            return nums[i];
        }
        if(i<0){
            return 0;
        }

        if(dp[i]!=-1){
            return dp[i];
        }

        int pick = nums[i]+helper(nums, i-2, dp);
        int notPick = 0+ helper(nums, i-1, dp);
        dp[i]=Math.max(pick, notPick);
        return dp[i];
    }
}
    }
}
