public class houseRobber2 {
    public static void main(String[] args) {
        class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==0) return 0;
        if(n==1) return nums[0];

        //From 0 to n-2
        int[] dp1 = new int[n];
        for(int i=0; i<n; i++){
            dp1[i]=-1;
        }
        int max1 = helper(nums, dp1, 0, n-2);


        //From 1 to n-1
        int[] dp2 = new int[n];
        for(int i=0; i<n; i++){
            dp2[i]=-1;
        }
        int max2 = helper(nums, dp2, 1, n-1);

        return Math.max(max1,max2);
    }   

    public int helper(int[] nums, int[] dp, int start, int end){
        if(end==start) return nums[end];
        if(end<start) return 0;

        if(dp[end]!=-1){
            return dp[end];
        }

        int pick = nums[end]+helper(nums, dp, start, end-2);
        int notPick = helper(nums, dp, start, end-1);

        dp[end] = Math.max(pick, notPick);
        return dp[end];
    }
}
    }
}
