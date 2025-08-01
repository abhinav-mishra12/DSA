// You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most k times.

// Return the length of the longest substring containing the same letter you can get after performing the above operations.

 

// Example 1:

// Input: s = "ABAB", k = 2
// Output: 4
// Explanation: Replace the two 'A's with two 'B's or vice versa.
// Example 2:

// Input: s = "AABABBA", k = 1
// Output: 4
// Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
// The substring "BBBB" has the longest repeating letters, which is 4.
// There may exists other ways to achieve this answer too.
public class longestRepeatingCharacterReplacement {
    public static void main(String[] args) {
        class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26]; //Frequency of each letter in the current window
        int maxFreq = 0; //Most frequent character count in the window
        int left = 0;
        int maxLen = 0;

        for(int right = 0; right < s.length(); right++){
            char c = s.charAt(right);
            freq[c-'A']++;

            maxFreq = Math.max(maxFreq, freq[c-'A']);

            if((right-left+1)-maxFreq>k){
                freq[s.charAt(left)-'A']--;
                left++;
            }

            maxLen = Math.max(maxLen, right-left+1);
        }

        return maxLen;
    }
}
    }
}
