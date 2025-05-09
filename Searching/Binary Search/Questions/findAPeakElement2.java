// A peak element in a 2D grid is an element that is strictly greater than all of its adjacent neighbors to the left, right, top, and bottom.

// Given a 0-indexed m x n matrix mat where no two adjacent cells are equal, find any peak element mat[i][j] and return the length 2 array [i,j].

// You may assume that the entire matrix is surrounded by an outer perimeter with the value -1 in each cell.

// You must write an algorithm that runs in O(m log(n)) or O(n log(m)) time.

 

// Example 1:



// Input: mat = [[1,4],[3,2]]
// Output: [0,1]
// Explanation: Both 3 and 4 are peak elements so [1,0] and [0,1] are both acceptable answers.
// Example 2:



// Input: mat = [[10,20,15],[21,30,14],[7,16,32]]
// Output: [1,1]
// Explanation: Both 30 and 32 are peak elements so [1,1] and [2,2] are both acceptable answers.
public class findAPeakElement2 {
    public static void main(String[] args) {
        class Solution {
            public int[] findPeakGrid(int[][] mat) {
                int rows = mat.length;
                int cols = mat[0].length;
        
                int left = 0;
                int right = cols - 1;
        
                while (left <= right) {
                    int midCol = left + (right - left) / 2;
        
                    int maxRow = 0;
                    for (int i = 0; i < rows; i++) {
                        if (mat[i][midCol] > mat[maxRow][midCol]) {
                            maxRow = i;
                        }
                    }
        
                    int leftVal = (midCol - 1 >= 0) ? mat[maxRow][midCol - 1] : -1;
                    int rightVal = (midCol + 1 < cols) ? mat[maxRow][midCol + 1] : -1;
                    int current = mat[maxRow][midCol];
        
                    if (current > leftVal && current > rightVal) {   //Sirf left or right mai isilia check kr rha h kyuki upar neeche m check krne ki jarorat ni kyuki kyuki humne maximum in the col nikala hai                                                        
                        return new int[] { maxRow, midCol };
                    } else if (rightVal > current) {
                        left = midCol + 1;
                    } else {
                        right = midCol - 1;
                    }
                }
        
                return new int[] { -1, -1 };
            }
        }
        
    }
}
