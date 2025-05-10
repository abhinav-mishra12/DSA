// Given two strings s and t, return true if t is an anagram of s, and false otherwise.

 

// Example 1:

// Input: s = "anagram", t = "nagaram"

// Output: true

// Example 2:

// Input: s = "rat", t = "car"

// Output: false

import java.util.Arrays;

public class validAnagram {
    public static void main(String[] args) {
        class Solution {
    public boolean isAnagram(String s, String t) {
        //Pre compute
        int[] hash = new int[26];
        int[] hash1 = new int[26];
        
        for(int i=0; i<s.length(); i++){
            hash[s.charAt(i)-'a']++;
        }

        for(int j=0; j<t.length(); j++){
            hash1[t.charAt(j)-'a']++;
        }

        return Arrays.equals(hash, hash1) ? true : false;
    }
}
    }
}
