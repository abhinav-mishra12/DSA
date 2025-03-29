// You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

// Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.

 

// Example 1:

// Input: nums = [1,2,3,1]
// Output: 4
// Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
// Total amount you can rob = 1 + 3 = 4.
// Example 2:

// Input: nums = [2,7,9,3,1]
// Output: 12
// Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
// Total amount you can rob = 2 + 9 + 1 = 12.
import java.util.Scanner;
public class houseRobber {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i]=input.nextInt();
        }
        int ans=rob(nums);
        System.out.println(ans);
    }

    public static int rob(int[] nums){

        // If only 1 element, just return it
        if (nums.length<2) {
            return nums[0];
        }

        // Create array to store the maximum loot at each index
        int[] dp = new int[nums.length];

        // Memoize maximum loots at first 2 indexes
        dp[0]=nums[0];
        dp[1]=Math.max(nums[0], nums[1]);

        
        // Use them to fill complete array
        for (int i = 2; i < dp.length; i++) {

            //Logic
            dp[i]=Math.max(dp[i-2]+nums[i], dp[i-1]);
        }

        return dp[nums.length-1];
    }
}
