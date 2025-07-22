// You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.

// Return the max sliding window.

 

// Example 1:

// Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
// Output: [3,3,5,5,6,7]
// Explanation: 
// Window position                Max
// ---------------               -----
// [1  3  -1] -3  5  3  6  7       3
//  1 [3  -1  -3] 5  3  6  7       3
//  1  3 [-1  -3  5] 3  6  7       5
//  1  3  -1 [-3  5  3] 6  7       5
//  1  3  -1  -3 [5  3  6] 7       6
//  1  3  -1  -3  5 [3  6  7]      7
// Example 2:

// Input: nums = [1], k = 1
// Output: [1]
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;
public class slidingWindowMaximum {
    public static void main(String[] args) {
        class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if(n==0 || k==0) return new int[0];

        int[] result = new int[n-k+1];
        Deque<Integer> dq = new LinkedList<>();
        for(int i=0; i<n; i++){
            if(!dq.isEmpty() && dq.peekFirst()<= i-k){
                dq.pollFirst();
            }
            while(!dq.isEmpty() && nums[dq.peekLast()]<=nums[i]){
                dq.pollLast();
            }
            dq.offerLast(i);

            if (i >= k - 1) {
                result[i - k + 1] = nums[dq.peekFirst()];
            }

        }

        return result;
    }
}
    }
}
