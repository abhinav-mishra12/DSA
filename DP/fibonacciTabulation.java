public class fibonacciTabulation {
    public static void main(String[] args) {
        int n = 10; // Example: Fibonacci of 10
        System.out.println("Fibonacci of " + n + " is: " + fib(n));
    }

    static int fib(int n) {
        // Special cases
        if (n == 0) return 0;
        if (n == 1) return 1;

        // Create dp array
        int[] dp = new int[n + 1];

        // Base values
        dp[0] = 0;
        dp[1] = 1;

        // Fill table iteratively
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        // Final result
        return dp[n];
    }
}
