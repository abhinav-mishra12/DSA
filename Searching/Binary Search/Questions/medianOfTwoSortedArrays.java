// Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

// The overall run time complexity should be O(log (m+n)).

 

// Example 1:

// Input: nums1 = [1,3], nums2 = [2]
// Output: 2.00000
// Explanation: merged array = [1,2,3] and median is 2.
// Example 2:

// Input: nums1 = [1,2], nums2 = [3,4]
// Output: 2.50000
// Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
public class medianOfTwoSortedArrays{
    public static void main(String[] args) {
        class Solution {
            public double findMedianSortedArrays(int[] nums1, int[] nums2) {
                double median = 0;
                int[] arr = mergedArr(nums1, nums2);
                int n = arr.length;
        
                if (n % 2 == 0) {
                    median = (arr[n / 2 - 1] + arr[n / 2]) / 2.0;
                } else {
                    median = arr[n / 2];
                }
        
                return median;
            }
        
            public int[] mergedArr(int[] nums1, int[] nums2) {
                int[] ans = new int[nums1.length + nums2.length];
                int i = 0, j = 0, k = 0;
        
                while (i < nums1.length && j < nums2.length) {
                    if (nums1[i] < nums2[j]) {
                        ans[k++] = nums1[i++];
                    } else {
                        ans[k++] = nums2[j++];
                    }
                }
        
                // Add remaining elements
                while (i < nums1.length) ans[k++] = nums1[i++];
                while (j < nums2.length) ans[k++] = nums2[j++];
        
                return ans;
            }
        }
        
    }
}