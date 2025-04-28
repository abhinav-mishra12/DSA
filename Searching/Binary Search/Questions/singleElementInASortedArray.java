// You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once.

// Return the single element that appears only once.

// Your solution must run in O(log n) time and O(1) space.

 

// Example 1:

// Input: nums = [1,1,2,3,3,4,4,8,8]
// Output: 2
// Example 2:

// Input: nums = [3,3,7,7,10,11,11]
// Output: 10
public class singleElementInASortedArray {
    public static void main(String[] args) {
        class Solution {
            public int singleNonDuplicate(int[] nums) {
                int start = 0;
                int end = nums.length-1;
                while(start<end){
                    int mid=start+(end-start)/2;
                    // Make sure mid is even
                    if (mid % 2 == 1) {
                        mid--; // always make mid even
                    }
                    if (nums[mid] == nums[mid + 1]) {
                        start = mid + 2; // Single element must be on the right
                    } else {
                        end = mid; // Single element is at mid or on the left
                    }
                }
                return nums[start];
            }
        }
    }
}
