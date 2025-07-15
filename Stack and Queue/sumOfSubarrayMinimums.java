// Given an array of integers arr, find the sum of min(b), where b ranges over every (contiguous) subarray of arr. Since the answer may be large, return the answer modulo 109 + 7.

 

// Example 1:

// Input: arr = [3,1,2,4]
// Output: 17
// Explanation: 
// Subarrays are [3], [1], [2], [4], [3,1], [1,2], [2,4], [3,1,2], [1,2,4], [3,1,2,4]. 
// Minimums are 3, 1, 2, 4, 1, 1, 2, 1, 1, 1.
// Sum is 17.
// Example 2:

// Input: arr = [11,81,94,43,3]
// Output: 444
public class sumOfSubarrayMinimums {
    public static void main(String[] args) {
        class Solution {
    public int sumSubarrayMins(int[] arr) {
        int total = 0;
        int n = arr.length;
        int mod = 1_000_000_007;

        for (int start = 0; start < n; start++) {
            int min = arr[start];
            for (int end = start; end < n; end++) {
                min = Math.min(min, arr[end]);
                total = (total + min) % mod;
            }
        }

        return total;
    }
}

    }
}
