// Given a valid parentheses string s, return the nesting depth of s. The nesting depth is the maximum number of nested parentheses.

 

// Example 1:

// Input: s = "(1+(2*3)+((8)/4))+1"

// Output: 3

// Explanation:

// Digit 8 is inside of 3 nested parentheses in the string.

// Example 2:

// Input: s = "(1)+((2))+(((3)))"

// Output: 3

// Explanation:

// Digit 3 is inside of 3 nested parentheses in the string.

// Example 3:

// Input: s = "()(())((()()))"

// Output: 3
public class maximumNestingDepthOfTheParentheses {
    public static void main(String[] args) {
        class Solution {
    public int maxDepth(String s) {
        int counter = 0;
        int maxCounter = 0;
        for(char ch : s.toCharArray()){
            if(ch=='('){
                counter++;
                maxCounter = Math.max(maxCounter, counter);
            }
            else if(ch==')'){
                counter--;
            }
            else{
                continue;
            }
        }
        return maxCounter;
    }
}
    }
}
