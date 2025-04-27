// There is an integer array nums sorted in ascending order (with distinct values).

// Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].

// Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.

// You must write an algorithm with O(log n) runtime complexity.

 

// Example 1:

// Input: nums = [4,5,6,7,0,1,2], target = 0
// Output: 4
// Example 2:

// Input: nums = [4,5,6,7,0,1,2], target = 3
// Output: -1
// Example 3:

// Input: nums = [1], target = 0
// Output: -1
public class searchInRotatedSortedArray {
    public static void main(String[] args) {
        class Solution {
            public int search(int[] nums, int target) {
                // If the array has only one element, directly compare it with the target
                if (nums.length == 1) {
                    return nums[0] == target ? 0 : -1;
                }
        
                // If the array is sorted (not rotated), just perform binary search
                if (nums[0] <= nums[nums.length - 1]) {
                    return binarySearch(nums, target, 0, nums.length - 1);
                }
        
                // Find the pivot element (the smallest element in a rotated sorted array)
                int pivot = findPivotElement(nums);  
        
                // If the pivot element is the target, return the pivot index
                if (nums[pivot] == target) {
                    return pivot;
                }
        
                // Perform binary search on the left side (ascending part)
                if (nums[0] <= target) {
                    return binarySearch(nums, target, 0, pivot - 1);
                }
                // Perform binary search on the right side (ascending part)
                else {
                    return binarySearch(nums, target, pivot + 1, nums.length - 1);
                }
            }
        
            // Find the pivot element in the rotated sorted array
            public int findPivotElement(int[] nums) { 
                int start = 0;
                int end = nums.length - 1;
        
                while (start < end) {
                    int mid = start + (end - start) / 2;
                    if (nums[mid] > nums[end]) {
                        // Pivot is on the right side
                        start = mid + 1;
                    } else {
                        // Pivot is on the left side
                        end = mid;
                    }
                }
                return start;  // Return the index of the pivot element
            }
        
            // Binary search method to find the target in the specified range
            public int binarySearch(int[] nums, int target, int start, int end) {
                while (start <= end) {
                    int mid = start + (end - start) / 2;
                    if (nums[mid] < target) {
                        start = mid + 1;
                    } else if (nums[mid] > target) {
                        end = mid - 1;
                    } else {
                        return mid;  // Target found
                    }
                }
                return -1;  // Target not found
            }
        }
        
    }
}
