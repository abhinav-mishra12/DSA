public class reverseString {
    public static void main(String[] args) {
        class Solution {
            public void reverseString(char[] s) {
                for(int i=0,j=s.length-1;i<j;i++,j--){
                    char tem=s[i];
                    s[i]=s[j];
                    s[j]=tem;
                }
            }
        }
    }
}
