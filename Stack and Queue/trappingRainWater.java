// Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

 

// Example 1:


// Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
// Output: 6
// Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
// Example 2:

// Input: height = [4,2,0,3,2,5]
// Output: 9
public class trappingRainWater {
    public static void main(String[] args) {
        
class Solution {
    public int trap(int[] height) {
        int[] prefixMax = new int[height.length]; //To find the left max
        int[] suffixMax = new int[height.length]; //To find the right max
        int n = height.length;

        prefixMax[0] = height[0];
        suffixMax[n-1] = height[n-1];

        for(int i=1; i<prefixMax.length; i++){
            prefixMax[i] = Math.max(height[i], prefixMax[i-1]);
        }

        for(int i = n-2; i>=0; i--){
            suffixMax[i] = Math.max(height[i], suffixMax[i+1]);
        }

        int total = 0;
        for(int i=0; i<n; i++){
            int leftMax = prefixMax[i];
            int rightMax = suffixMax[i];
            if(height[i]<leftMax && height[i]<rightMax){
                total += Math.min(leftMax, rightMax) - height[i];
            }
        }

        return total;
    }
}
    }
}
