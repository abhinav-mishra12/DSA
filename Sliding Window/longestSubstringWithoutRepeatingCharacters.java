// Given a string s, find the length of the longest substring without duplicate characters.

 

// Example 1:

// Input: s = "abcabcbb"
// Output: 3
// Explanation: The answer is "abc", with the length of 3.
// Example 2:

// Input: s = "bbbbb"
// Output: 1
// Explanation: The answer is "b", with the length of 1.
// Example 3:

// Input: s = "pwwkew"
// Output: 3
// Explanation: The answer is "wke", with the length of 3.
// Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
import java.util.HashMap;
public class longestSubstringWithoutRepeatingCharacters{
    public static void main(String[] args) {
       
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int left = 0;
        int maxLen = 0;
        
        HashMap<Character, Integer> map = new HashMap<>();

        for(int right = 0; right < n; right++){
            char c = s.charAt(right);
            if(map.containsKey(c) && map.get(c)>=left){
                left = map.get(c)+1; //We check if the last time we saw character c is inside the current window or not. if it is insiide then we need to update the window or if not then c is not relevant to this window and we will continue.
            }
            map.put(c, right);
            maxLen = Math.max(maxLen, right-left+1);
        }
        return maxLen;
    }
}
    }
}