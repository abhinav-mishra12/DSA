// Given a string s containing only three types of characters: '(', ')' and '*', return true if s is valid.

// The following rules define a valid string:

// Any left parenthesis '(' must have a corresponding right parenthesis ')'.
// Any right parenthesis ')' must have a corresponding left parenthesis '('.
// Left parenthesis '(' must go before the corresponding right parenthesis ')'.
// '*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string "".
 

// Example 1:

// Input: s = "()"
// Output: true
// Example 2:

// Input: s = "(*)"
// Output: true
// Example 3:

// Input: s = "(*))"
// Output: true
public class validParenthesis {
    public static void main(String[] args) {
        class Solution {
    public boolean checkValidString(String s) {
        int low = 0, high = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                low++;
                high++;
            } else if (c == ')') {
                low--;
                high--;
            } else { // '*'
                low--;     // if '*' is ')'
                high++;    // if '*' is '('
            }

            // Clamp low to 0 (can't have negative open brackets)
            if (low < 0) low = 0;

            // If high drops below 0, too many ')'
            if (high < 0) return false;
        }

        return low == 0;
    }
}

    }
}
