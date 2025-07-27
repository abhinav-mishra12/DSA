// Given a string s consisting only of characters a, b and c.

// Return the number of substrings containing at least one occurrence of all these characters a, b and c.

 

// Example 1:

// Input: s = "abcabc"
// Output: 10
// Explanation: The substrings containing at least one occurrence of the characters a, b and c are "abc", "abca", "abcab", "abcabc", "bca", "bcab", "bcabc", "cab", "cabc" and "abc" (again). 
// Example 2:

// Input: s = "aaacb"
// Output: 3
// Explanation: The substrings containing at least one occurrence of the characters a, b and c are "aaacb", "aacb" and "acb". 
// Example 3:

// Input: s = "abc"
// Output: 1
public class numberOfSubstringsContainingAllThreeCharacters {
    public static void main(String[] args) {
        class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int lSum = 0;
        int rSum = 0;
        int maxSum = 0;
        int n = cardPoints.length;
        for(int l = 0; l<k; l++){
            lSum = lSum + cardPoints[l];
            maxSum = lSum;
        }

        int rightIndex = n-1;
        for(int l = k-1; l>=0; l--){
            lSum = lSum - cardPoints[l];
            rSum = rSum + cardPoints[rightIndex];
            rightIndex--;
            maxSum = Math.max(maxSum,lSum+rSum);
        }

        return maxSum;
    }
}
    }
}
