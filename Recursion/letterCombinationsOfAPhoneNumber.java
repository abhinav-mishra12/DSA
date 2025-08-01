// Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

// A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.


 

// Example 1:

// Input: digits = "23"
// Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
// Example 2:

// Input: digits = ""
// Output: []
// Example 3:

// Input: digits = "2"
// Output: ["a","b","c"]
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class letterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits.length() == 0) {
            return ans;
        }

        HashMap<Character, String> hm = new HashMap<>();
        hm.put('2', "abc");
        hm.put('3', "def");
        hm.put('4', "ghi");
        hm.put('5', "jkl");
        hm.put('6', "mno");
        hm.put('7', "pqrs"); // corrected mapping for 7
        hm.put('8', "tuv");  // corrected mapping for 8
        hm.put('9', "wxyz");

        backTrack(digits, 0, hm, new StringBuilder(), ans);
        return ans;
    }

    private void backTrack(String digits, int index, HashMap<Character, String> hm, StringBuilder sb, List<String> result) {
        if (index == digits.length()) {
            result.add(sb.toString());
            return;
        }

        String curr = hm.get(digits.charAt(index));
        for (int k = 0; k < curr.length(); k++) {
            sb.append(curr.charAt(k));
            backTrack(digits, index + 1, hm, sb, result);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}

    }
}
