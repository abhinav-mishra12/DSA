public class knapsack {

    // Function to solve 0/1 Knapsack Problem
    public static int knapsack(int W, int[] wt, int[] val, int n) {
        int[][] dp = new int[n + 1][W + 1];

        // Build DP table
        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= W; w++) {
                if (i == 0 || w == 0) {
                    dp[i][w] = 0; // base case
                } else if (wt[i - 1] <= w) {
                    // Either take the item or leave it
                    dp[i][w] = Math.max(
                            val[i - 1] + dp[i - 1][w - wt[i - 1]], // include
                            dp[i - 1][w]                           // exclude
                    );
                } else {
                    dp[i][w] = dp[i - 1][w]; // can't include item
                }
            }
        }

        // Final result is at dp[n][W]
        return dp[n][W];
    }

    public static void main(String[] args) {
        int[] val = {2, 3, 4, 5};  // profits
        int[] wt = {3, 4, 5, 6};   // weights
        int W = 8;                 // capacity
        int n = val.length;

        System.out.println("Maximum profit: " + knapsack(W, wt, val, n));
    }
}
