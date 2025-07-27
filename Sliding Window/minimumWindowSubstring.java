// Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".

// The testcases will be generated such that the answer is unique.

 

// Example 1:

// Input: s = "ADOBECODEBANC", t = "ABC"
// Output: "BANC"
// Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
// Example 2:

// Input: s = "a", t = "a"
// Output: "a"
// Explanation: The entire string s is the minimum window.
// Example 3:

// Input: s = "a", t = "aa"
// Output: ""
// Explanation: Both 'a's from t must be included in the window.
// Since the largest window of s only has one 'a', return empty string.

import java.util.HashMap;

public class minimumWindowSubstring {
    public static void main(String[] args) {
class Solution {
    public String minWindow(String s, String t) {
        if(s.length()==0 || t.length()==0) return "";

        HashMap<Character, Integer> tCount = new HashMap<>();
        for(int i = 0; i<t.length(); i++){
            char ch = t.charAt(i);
            tCount.put(ch, tCount.getOrDefault(ch,0)+1);
        }

        int have = 0; //how many characters in the window meet the required count.
        int left = 0;
        int need = tCount.size();
        int minLen = Integer.MAX_VALUE;
        int resLeft = 0; // start index of the minimum window.
        HashMap<Character, Integer> window = new HashMap<>();

        for(int right = 0; right<s.length(); right++){
            char c = s.charAt(right);
            window.put(c, window.getOrDefault(c,0)+1);

            // If c is a required character, and we now have the required number of it in the window, we increment have

            if(tCount.containsKey(c) && window.get(c).intValue() == tCount.get(c).intValue()){
                have++;
            }

            while(have==need){
                if((right-left+1)<minLen){
                    minLen = right-left+1;
                    resLeft=left;
                }

                //Shrink from left
                char leftChar = s.charAt(left);
                window.put(leftChar, window.getOrDefault(leftChar, 0)-1);
                if(tCount.containsKey(leftChar) && window.get(leftChar)<tCount.get(leftChar)){
                    have--;
                }

                left++;
            }

        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(resLeft, resLeft+minLen);

    }
}
    }
}
