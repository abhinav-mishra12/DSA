// Given a string s, return the longest palindromic substring in s.

 

// Example 1:

// Input: s = "babad"
// Output: "bab"
// Explanation: "aba" is also a valid answer.
// Example 2:

// Input: s = "cbbd"
// Output: "bb"

import java.util.Scanner;

public class longestPalindromicSubstring {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the string: ");
        String s = input.nextLine();

        System.out.println("The longest palindrome substring: "+ longestPalindromic(s));
    }

    public static String longestPalindromic(String s){
        int start = 0;
        int end = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (isValidPalindromicString(s, i, j)==true) {
                    if ((j-i+1)>max) {
                        max=j-i+1;
                        start=i;
                        end=j;
                    }
                }
            }
        }

        return s.substring(start, end+1);
        
    }

    public static boolean isValidPalindromicString(String s, int i, int j){
        while(i<j){
            char ch1 = s.charAt(i);
            char ch2 = s.charAt(j);
            if (ch1!=ch2) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
