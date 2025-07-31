// Implement pow(x, n), which calculates x raised to the power n (i.e., xn).

 

// Example 1:

// Input: x = 2.00000, n = 10
// Output: 1024.00000
// Example 2:

// Input: x = 2.10000, n = 3
// Output: 9.26100
// Example 3:

// Input: x = 2.00000, n = -2
// Output: 0.25000
// Explanation: 2-2 = 1/22 = 1/4 = 0.25
public class powxn{
    public static void main(String[] args) {
        class Solution {
    public double myPow(double x, int n) {
         //Handling edge cases 
         long N = n;
         if(N<0){
            x=1/x;
            N=-N;
         }
         return power(x,N);
    }

    private double power(double x, long n){
        if(n==0) return 1.0;
        double half = power(x, n / 2);
        if(n%2==0){
            return half*half;
        }
        else{
            return half*half*x;
        }


    }
}
    }
}