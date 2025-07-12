// Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

// An input string is valid if:

// Open brackets must be closed by the same type of brackets.
// Open brackets must be closed in the correct order.
// Every close bracket has a corresponding open bracket of the same type.
 

// Example 1:

// Input: s = "()"

// Output: true

// Example 2:

// Input: s = "()[]{}"

// Output: true

// Example 3:

// Input: s = "(]"

// Output: false

// Example 4:

// Input: s = "([])"

// Output: true
import java.util.Stack;
public class validParanthesis {
    public static void main(String[] args) {
        
class Solution {

    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        char[] arr = new char[s.length()];
        for(int i = 0; i < s.length(); i++){
            arr[i] = s.charAt(i);
        }

        for(int i = 0; i < arr.length; i++){
            if(arr[i] == '(' || arr[i] == '{' || arr[i] == '['){
                st.push(arr[i]);
            }

            if(arr[i] == ')' || arr[i] == '}' || arr[i] == ']'){
                if(st.isEmpty()) {
                    return false; // no matching opening bracket
                }
                char top = st.peek();

                // Check if top matches the current closing bracket
                if((arr[i] == ')' && top == '(') ||
                   (arr[i] == '}' && top == '{') ||
                   (arr[i] == ']' && top == '[')) {
                    st.pop();
                } else {
                    return false; // mismatch
                }
            }
        }

        return st.isEmpty();
    }
}

    }
}
