// You are given an integer array nums. The range of a subarray of nums is the difference between the largest and smallest element in the subarray.

// Return the sum of all subarray ranges of nums.

// A subarray is a contiguous non-empty sequence of elements within an array.

 

// Example 1:

// Input: nums = [1,2,3]
// Output: 4
// Explanation: The 6 subarrays of nums are the following:
// [1], range = largest - smallest = 1 - 1 = 0 
// [2], range = 2 - 2 = 0
// [3], range = 3 - 3 = 0
// [1,2], range = 2 - 1 = 1
// [2,3], range = 3 - 2 = 1
// [1,2,3], range = 3 - 1 = 2
// So the sum of all ranges is 0 + 0 + 0 + 1 + 1 + 2 = 4.
// Example 2:

// Input: nums = [1,3,3]
// Output: 4
// Explanation: The 6 subarrays of nums are the following:
// [1], range = largest - smallest = 1 - 1 = 0
// [3], range = 3 - 3 = 0
// [3], range = 3 - 3 = 0
// [1,3], range = 3 - 1 = 2
// [3,3], range = 3 - 3 = 0
// [1,3,3], range = 3 - 1 = 2
// So the sum of all ranges is 0 + 0 + 0 + 2 + 0 + 2 = 4.
// Example 3:

// Input: nums = [4,-2,-3,4,1]
// Output: 59
// Explanation: The sum of all subarray ranges of nums is 59.
import java.util.Stack;
public class sumOfSubarrayRanges {
    public static void main(String[] args) {

class Solution {
    public long subArrayRanges(int[] nums) {
        int n = nums.length;

        int[] prevLess = new int[n];
        int[] nextLess = new int[n];
        int[] prevGreater = new int[n];
        int[] nextGreater = new int[n];

        Stack<Integer> st = new Stack<>();

        // Previous Less Element
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && nums[st.peek()] > nums[i]) {
                st.pop();
            }
            prevLess[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        st.clear();

        // Next Less Element
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && nums[st.peek()] >= nums[i]) {
                st.pop();
            }
            nextLess[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        st.clear();

        // Previous Greater Element
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && nums[st.peek()] < nums[i]) {
                st.pop();
            }
            prevGreater[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        st.clear();

        // Next Greater Element
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && nums[st.peek()] <= nums[i]) {
                st.pop();
            }
            nextGreater[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        long minSum = 0, maxSum = 0;

        for (int i = 0; i < n; i++) {
            long left = i - prevLess[i];
            long right = nextLess[i] - i;
            minSum += (long) nums[i] * left * right;
        }

        for (int i = 0; i < n; i++) {
            long left = i - prevGreater[i];
            long right = nextGreater[i] - i;
            maxSum += (long) nums[i] * left * right;
        }

        return maxSum - minSum;
    }
}

    }
}
