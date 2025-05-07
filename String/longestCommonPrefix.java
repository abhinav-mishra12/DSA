// Write a function to find the longest common prefix string amongst an array of strings.

// If there is no common prefix, return an empty string "".

 

// Example 1:

// Input: strs = ["flower","flow","flight"]
// Output: "fl"
// Example 2:

// Input: strs = ["dog","racecar","car"]
// Output: ""
// Explanation: There is no common prefix among the input strings.
public class longestCommonPrefix {
    public static void main(String[] args) {
        class Solution {
            public String longestCommonPrefix(String[] strs) {
                StringBuilder result = new StringBuilder();
        
                if (strs.length == 0) {
                    return "";
                }
        
                // Loop through characters of the first string
                for (int i = 0; i < strs[0].length(); i++) {
                    char currentChar = strs[0].charAt(i);
        
                    // Check this char against the same position in all other strings
                    for (int j = 1; j < strs.length; j++) {
                        // If index i is out of bounds or characters do not match
                        if (i >= strs[j].length() || strs[j].charAt(i) != currentChar) {
                            return result.toString();
                        }
                    }
        
                    // If all strings had the same char at index i, add to result
                    result.append(currentChar);
                }
        
                return result.toString();
            }
        }
        
    }
}
