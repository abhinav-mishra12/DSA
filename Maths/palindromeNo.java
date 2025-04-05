// Given an integer x, return true if x is a palindrome, and false otherwise.

 

// Example 1:

// Input: x = 121
// Output: true
// Explanation: 121 reads as 121 from left to right and from right to left.
// Example 2:

// Input: x = -121
// Output: false
// Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
// Example 3:

// Input: x = 10
// Output: false
// Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
import java.util.Scanner;

public class palindromeNo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        System.out.println(checkPalindrome(n));
        input.close();

    }
    public static boolean checkPalindrome(int n){

       
        int originalNo=n;
        int lastdigit=0;
        int revNo=0;
        if (n<0) {
            return false;
        }
        else{
            while (n!=0) {
                lastdigit=n%10;
                revNo=(revNo*10)+lastdigit;
                n=n/10;
            }
        }
        if (revNo==originalNo) {
            return true;
        }
        else{
            return false;
        }
    }
}
