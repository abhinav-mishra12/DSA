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
import java.util.Stack;
public class sumOfSubarrayMinimums {
    public static void main(String[] args) {

class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int mod = 1_000_000_007;

        int[] prevLess = new int[n];
        int[] nextLess = new int[n];
        Stack<Integer> st = new Stack<>();

        // Previous Less Element
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }
            prevLess[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        st.clear();

        // Next Less Element
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            nextLess[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        // Calculate contribution
        long result = 0;
        for (int i = 0; i < n; i++) {
            int left = i - prevLess[i];
            int right = nextLess[i] - i;
            long contrib = (long) left * right * arr[i];
            result = (result + contrib % mod) % mod;
        }

        return (int) result;
    }
}


    }
}
