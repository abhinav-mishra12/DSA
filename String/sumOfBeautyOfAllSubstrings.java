// The beauty of a string is the difference in frequencies between the most frequent and least frequent characters.

// For example, the beauty of "abaacc" is 3 - 1 = 2.
// Given a string s, return the sum of beauty of all of its substrings.

 

// Example 1:

// Input: s = "aabcb"
// Output: 5
// Explanation: The substrings with non-zero beauty are ["aab","aabc","aabcb","abcb","bcb"], each with beauty equal to 1.
// Example 2:

// Input: s = "aabcbaa"
// Output: 17
public class sumOfBeautyOfAllSubstrings {
    public static void main(String[] args) {
        class Solution {
    public int beautySum(String s) {
        int sum = 0;
        for(int i=0; i<s.length(); i++){
            int[] freq = new int[26];
            for(int j=i; j<s.length(); j++){
                freq[s.charAt(j)-'a']++;
                int beauty = getMaxCount(freq)-getMinCount(freq);
                sum+=beauty;
            }
        }
        return sum;

    }

    public int getMinCount(int[] freq){
        int minCount = Integer.MAX_VALUE;
        for(int i=0; i<26; i++){
            if(freq[i]!=0){
                minCount = Math.min(minCount, freq[i]);
            }
        }
        return minCount;
    }

    public int getMaxCount(int [] freq){
        int maxCount = 0;
        for(int i=0; i<26; i++){
            maxCount = Math.max(maxCount, freq[i]);
        }
        return maxCount;
    }
}
    }
}
