// Given an array of integers heights representing the histogram's bar height where the width of each bar is 1, return the area of the largest rectangle in the histogram.

 

// Example 1:


// Input: heights = [2,1,5,6,2,3]
// Output: 10
// Explanation: The above is a histogram where width of each bar is 1.
// The largest rectangle is shown in the red area, which has an area = 10 units.
// Example 2:


// Input: heights = [2,4]
// Output: 4
import java.util.Stack;
public class largestRectangleInHistogram {
    public static void main(String[] args) {
        
class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int n = heights.length;

        int[] pse = new int[n]; //To store the index of previous smaller element
        int[] nse = new int[n]; //To store the index of next smaller element

        //pse
        for(int i = 0; i<n; i++){
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]){
                st.pop();
            }

            if(!st.isEmpty()){
                pse[i] = st.peek();
            }
            else{
                pse[i] = -1;
            }

            st.push(i);
        }

        st.clear();

        //nse
        for(int i = n-1; i>=0; i--){
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]){
                st.pop();
            }
            if(!st.isEmpty()){
                nse[i] = st.peek();
            }
            else if(st.isEmpty()){
                nse[i] = n;
            }

            st.push(i);
        }

        //To calculate the area of largest rectangle
        int maxArea = 0;
        for(int i=0 ; i<n; i++){
            maxArea = Math.max(maxArea, heights[i]*(nse[i]-pse[i]-1));
        }

        return maxArea;
    }
}
    }
}
