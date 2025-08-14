public class fibonacciMemoization {
    
    static int[] dp; // DP array to store results
    
    public static void main(String[] args) {
        int n = 10; // Example: find Fibonacci of 10
        dp = new int[n + 1];
        
        // Initialize dp array with -1 meaning "not calculated yet"
        for (int i = 0; i <= n; i++) {
            dp[i] = -1;
        }
        
        System.out.println("Fibonacci of " + n + " is: " + fib(n));
    }
    
    static int fib(int n) {
        // Base cases
        if (n == 0) return 0;
        if (n == 1) return 1;
        
        // If already calculated, return from dp
        if (dp[n] != -1) {
            return dp[n];
        }
        
        // Otherwise calculate and store in dp
        dp[n] = fib(n - 1) + fib(n - 2);
        return dp[n];
    }
}
