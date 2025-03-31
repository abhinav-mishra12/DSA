// You are given an array points containing the coordinates of points on a 2D plane, sorted by the x-values, where points[i] = [xi, yi] such that xi < xj for all 1 <= i < j <= points.length. You are also given an integer k.

// Return the maximum value of the equation yi + yj + |xi - xj| where |xi - xj| <= k and 1 <= i < j <= points.length.

// It is guaranteed that there exists at least one pair of points that satisfy the constraint |xi - xj| <= k.

 

// Example 1:

// Input: points = [[1,3],[2,0],[5,10],[6,-10]], k = 1
// Output: 4
// Explanation: The first two points satisfy the condition |xi - xj| <= 1 and if we calculate the equation we get 3 + 0 + |1 - 2| = 4. Third and fourth points also satisfy the condition and give a value of 10 + -10 + |5 - 6| = 1.
// No other pairs satisfy the condition, so we return the max of 4 and 1.
// Example 2:

// Input: points = [[0,0],[3,0],[9,2]], k = 3
// Output: 3
// Explanation: Only the first two points have an absolute difference of 3 or less in the x-values, and give the value of 0 + 0 + |0 - 3| = 3.
import java.util.Scanner;

public class maxValueOfEquation {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the size of the matrix: ");
        int n = input.nextInt();
        int m = input.nextInt();
        int[][] points = new int[n][m];
        System.out.println("Enter the elements of the matrix: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                points[i][j]=input.nextInt();
            }
        }

        System.out.println("Enter the value of k: ");
        int k = input.nextInt();

        int ans = findMaxValueOfEquation(points, k);
        System.out.println(ans);

    }
    

    //Time limit is exceeding with this approach.
    public static int findMaxValueOfEquation(int[][] points, int k){
        int ans=Integer.MIN_VALUE; // Initialize to a very low value
        
        // Nested loops to check every pair of points
        for (int i = 0; i < points.length; i++) {
            for (int j = i+1; j < points.length; j++) {
                if (Math.abs(points[i][0]-points[j][0])<=k) {
                    if (points[i][1]+points[j][1]+Math.abs(points[i][0]-points[j][0])>ans) {
                        ans=points[i][1]+points[j][1]+Math.abs(points[i][0]-points[j][0]);
                    }
                }
            }
        }
        return ans;
    }
}


// The optimize solution
class Solution {
    public int findMaxValueOfEquation(int[][] points, int k) {
        int ans=Integer.MIN_VALUE;// Initialize the answer to the smallest possible value.
		int i=0;// Pointer for the first point in the pair.
        int f=1;// Pointer for the second point in the pair.
        while(i < points.length) {  // Loop through all points
            if(f<i+1)  //f is updated to ensure that the inner loop starts from the next index after i. This avoids revisiting points that have already been considered for the current i.
                f=i+1;
            for (int j = f; j <= points.length-1; j++) {
                if(points[j][0]>(points[i][0]+k))
					break; //This line checks if the x-coordinate difference |xi - xj| is greater than k. If it is, we break out of the loop because further values of j will only increase the x-coordinate difference. This helps reduce unnecessary calculations when the pair (i, j) does not satisfy the constraint |xi - xj| <= k.
                if((points[i][1]+points[j][1]+points[j][0]-points[i][0])>ans){
                    ans=points[i][1]+points[j][1]+points[j][0]-points[i][0];
                    f=j-1;// Update `f` to `j - 1` (for the next iteration of `i`).

                }
            }
            i++;// Move to the next point.
        }
        return ans; // Return the maximum value found.
    }
}

// Math.abs() works on all numeric types (like int, long, float, and double) and returns the absolute value, which is the positive version of the number.