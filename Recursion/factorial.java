import java.util.Scanner;

public class factorial {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int ans = factorial(n, 1); // Start recursion with m = 1
        System.out.println(ans);
        input.close();
    }

    public static int factorial(int n, int m) {
        if (n == m) { // Base case: when n equals m, return 1 (factorial of 1 is 1)
            return 1;
        } else {
            return n * factorial(n - 1, m); // Recursively calculate factorial
        }
    }
}
