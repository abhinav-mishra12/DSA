public class spriral2 {
    public static void main(String[] args) {
        class Solution {
            public int[][] generateMatrix(int n) {
                int[][] mat = new int[n][n];
                int left=0,top=0,right=n-1,bottom=n-1;
                int element=1;
                while(left<=right && top<=bottom){
                    for(int i=left;i<=right;i++){
                        mat[top][i] = element;
                        element++; 
                    }
                    top++;
        
                    for(int i=top;i<=bottom;i++){
                        mat[i][right]=element;
                        element++;
                    }
                    right--;
                    
                    for(int i=right;i>=left;i--){
                        mat[bottom][i]=element;
                        element++;
                    }
                    bottom--;
        
                    for(int i=bottom;i>=top;i--){
                        mat[i][left]=element;
                        element++;
                    }
                    left++;
                }
                return mat;
            }
        }
        
    }
}
