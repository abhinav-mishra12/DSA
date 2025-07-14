// Given a circular integer array nums (i.e., the next element of nums[nums.length - 1] is nums[0]), return the next greater number for every element in nums.

// The next greater number of a number x is the first greater number to its traversing-order next in the array, which means you could search circularly to find its next greater number. If it doesn't exist, return -1 for this number.

 

// Example 1:

// Input: nums = [1,2,1]
// Output: [2,-1,2]
// Explanation: The first 1's next greater number is 2; 
// The number 2 can't find next greater number. 
// The second 1's next greater number needs to search circularly, which is also 2.
// Example 2:

// Input: nums = [1,2,3,4,3]
// Output: [2,3,4,-1,4]
public class nextGreaterElementII {
    public static void main(String[] args) {
        

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] newArr = new int[n * 2];  // 'new' is a reserved word, renamed to newArr

        // Copy original array twice into newArr
        for (int i = 0; i < n; i++) {
            newArr[i] = nums[i];
            newArr[i + n] = nums[i];
        }

        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            boolean assigned = false;

            // Search from i+1 to i+n for next greater element
            for (int j = i + 1; j < i + n; j++) {
                if (newArr[j] > nums[i]) {
                    ans[i] = newArr[j];
                    assigned = true;
                    break;
                }
            }

            // If no greater element is found
            if (!assigned) {
                ans[i] = -1;
            }
        }

        return ans;
    }
}

    }
}
