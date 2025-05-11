// Given a string s, sort it in decreasing order based on the frequency of the characters. The frequency of a character is the number of times it appears in the string.

// Return the sorted string. If there are multiple answers, return any of them.

 

// Example 1:

// Input: s = "tree"
// Output: "eert"
// Explanation: 'e' appears twice while 'r' and 't' both appear once.
// So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
// Example 2:

// Input: s = "cccaaa"
// Output: "aaaccc"
// Explanation: Both 'c' and 'a' appear three times, so both "cccaaa" and "aaaccc" are valid answers.
// Note that "cacaca" is incorrect, as the same characters must be together.
// Example 3:

// Input: s = "Aabb"
// Output: "bbAa"
// Explanation: "bbaA" is also a valid answer, but "Aabb" is incorrect.
// Note that 'A' and 'a' are treated as two different characters.
import java.util.*;

public class sortCharactersByFrequency {
    public static void main(String[] args) {
    class Solution {
    public String frequencySort(String s) {
        int[] hash = new int[62];
        StringBuilder sb  = new StringBuilder();
        List<int[]> freqList = new ArrayList<>();
        
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);

            if(Character.isLowerCase(c)){
                hash[c-'a']++;
            }

            else if(Character.isUpperCase(c)){
                hash[c-'A'+26]++;
            }
            
            else if(Character.isDigit(c)){
                hash[c-'0'+52]++;
            }
        }
         // Step 2: Build a list of [index, frequency] pairs
        for (int i = 0; i < 62; i++) {
            if (hash[i] > 0) {
                freqList.add(new int[]{i, hash[i]});
            }
        }

        //Sort it in descending order now
        freqList.sort((a, b) -> b[1] - a[1]);

        for(int[] pair : freqList){
            char c = 0;
            if(pair[0]<26){
                c = (char) ('a' + pair[0]);
            }
            else if(pair[0]<52){
                c = (char) ('A' + (pair[0]-26));
            }
            else{
                c = (char) ('0' + (pair[0]-52));
            }

            for(int i=0; i<pair[1]; i++){
                sb.append(c);
            }
        }
        
        return sb.toString();
    }
} 
    }
}
