// Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible palindrome partitioning of s.

 

// Example 1:

// Input: s = "aab"
// Output: [["a","a","b"],["aa","b"]]
// Example 2:

// Input: s = "a"
// Output: [["a"]]
import java.util.ArrayList;
import java.util.List;

public class palindromePartitioning{
    public static void main(String[] args) {
        class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backTrack(s,0, new ArrayList<>(), result);
        return result;
    }

    private void backTrack(String s, int start, List<String> currentList, List<List<String>> result){
        if(start==s.length()){
            result.add(new ArrayList<>(currentList));
        }
        for (int end = start + 1; end <= s.length(); end++) {
        String substr = s.substring(start, end);
        if (isPalindrome(substr)) {
        currentList.add(substr);
        backTrack(s, end, currentList, result);
        currentList.remove(currentList.size() - 1); // backtrack
    }
}
    }

    private boolean isPalindrome(String s) {
    int left = 0, right = s.length() - 1;
    while (left < right) {
        if (s.charAt(left++) != s.charAt(right--)) return false;
    }
    return true;
}

}
    }
}