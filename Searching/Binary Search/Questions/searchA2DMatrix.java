// You are given an m x n integer matrix matrix with the following two properties:

// Each row is sorted in non-decreasing order.
// The first integer of each row is greater than the last integer of the previous row.
// Given an integer target, return true if target is in matrix or false otherwise.

// You must write a solution in O(log(m * n)) time complexity.

 

// Example 1:


// Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
// Output: true
// Example 2:


// Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
// Output: false
public class searchA2DMatrix {
    public static void main(String[] args) {
        class Solution {
            public boolean searchMatrix(int[][] matrix, int target) {
                int row = matrix.length;
                int col = matrix[0].length;  // be cautious, matrix may be empty
        
                if(row==1){
                    return binarySearch(matrix, 0, 0, col-1, target);
                }
        
                int rStart = 0;
                int rEnd = row-1;
                int cMid = col/2;
        
                // Run the loop till two rows are remaining
                while(rStart<(rEnd-1)){  // While this is true it will have more than two rows
                    int mid = rStart+(rEnd-rStart)/2;
                    if(matrix[mid][cMid]==target){
                        return true;
                    }
                    else if(matrix[mid][cMid]<target){
                    rStart=mid;
                    }
                    else if(matrix[mid][cMid]>target){
                    rEnd=mid;
                    }
                }
        
                //Now we have 2 rows 
                //Check whether the target is in the cols of 2 rows
                if(matrix[rStart][cMid]==target){
                    return true;
                }
        
                if(matrix[rStart+1][cMid]==target){
                    return true;
                }
        
                // Search in 1st half
                if(cMid - 1 >= 0 && target <= matrix[rStart][cMid - 1]){
                    return binarySearch(matrix, rStart, 0, cMid - 1, target);
                }
                // Search in 2nd half
                if(cMid + 1 < col && target >= matrix[rStart][cMid + 1] && target <= matrix[rStart][col - 1]){
                    return binarySearch(matrix, rStart, cMid + 1, col - 1, target);
                }
                // Search in 3rd half
                if(cMid - 1 >= 0 && target <= matrix[rStart + 1][cMid - 1]){
                    return binarySearch(matrix, rStart + 1, 0, cMid - 1, target);
                }
                // Search in 4th half
                if(cMid + 1 < col && target >= matrix[rStart + 1][cMid + 1]){
                    return binarySearch(matrix, rStart + 1, cMid + 1, col - 1, target);
                }
        
        
                return false;
        
            }
        
            // Search in the row provided in between the colums
            static boolean binarySearch(int[][] matrix, int row, int cStart, int cEnd, int target){
                while(cStart<=cEnd){
                    int mid = cStart+(cEnd-cStart)/2;
                    if(matrix[row][mid]==target){
                        return true;
                    }
                    if(matrix[row][mid]<target){
                        cStart=mid+1;
                    }
                    else{
                        cEnd=mid-1;
                    }
                }
                return false;
            }
        }
    }
}
