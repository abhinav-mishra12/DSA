// Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.

// Assume the environment does not allow you to store 64-bit integers (signed or unsigned).

 

// Example 1:

// Input: x = 123
// Output: 321
// Example 2:

// Input: x = -123
// Output: -321
// Example 3:

// Input: x = 120
// Output: 21
import java.util.Scanner;

public class reverseInteger {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int n=input.nextInt();
        System.out.println(reverseInteger(n));
        input.close();
    }
    public static int reverseInteger(int n){
        int revNo = 0;
        while (n != 0) {
            int lastDigit = n % 10;
            // Check if revNo will overflow when multiplied by 10 and added lastDigit
            if (revNo > Integer.MAX_VALUE / 10 || (revNo == Integer.MAX_VALUE / 10 && lastDigit > 7)) {
                return 0;
            }
            if (revNo < Integer.MIN_VALUE / 10 || (revNo == Integer.MIN_VALUE / 10 && lastDigit < -8)) {
                return 0;
            }
            revNo = revNo * 10 + lastDigit;
            n = n / 10;
        }
        return revNo;
    }
}
