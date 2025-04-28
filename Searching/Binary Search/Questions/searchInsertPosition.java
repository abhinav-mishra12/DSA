// Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

// You must write an algorithm with O(log n) runtime complexity.

 

// Example 1:

// Input: nums = [1,3,5,6], target = 5
// Output: 2
// Example 2:

// Input: nums = [1,3,5,6], target = 2
// Output: 1
// Example 3:

// Input: nums = [1,3,5,6], target = 7
// Output: 4
public class searchInsertPosition{
    public static void main(String[] args) {
        class Solution {
            public int searchInsert(int[] nums, int target) {
                int ans = search(nums, target);
                if (ans == -1) {
                    return insertIndex(nums, target);
                }
                return ans;
            }
        
            // Binary search to find if target exists
            public int search(int[] nums, int target) {
                int start = 0;
                int end = nums.length - 1;
                while (start <= end) {
                    int mid = start + (end - start) / 2;
                    if (nums[mid] == target) {
                        return mid; // Target found
                    } else if (nums[mid] > target) {
                        end = mid - 1;
                    } else {
                        start = mid + 1;
                    }
                }
                return -1; // Target not found
            }
        
            // Binary search to find where the target should be inserted
            public int insertIndex(int[] nums, int target) {
                int start = 0;
                int end = nums.length - 1;
                while (start <= end) { // Standard binary search loop condition
                    int mid = start + (end - start) / 2;
                    if (nums[mid] == target) {
                        return mid; // If target is found
                    } else if (nums[mid] > target) {
                        end = mid - 1; // Move to the left side
                    } else {
                        start = mid + 1; // Move to the right side
                    }
                }
                return start; // The correct insertion point is where start is after the loop
            }
        }
        
    }
}