public class stringPalindrome{
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        boolean ans = isPalindrome(s);
        System.out.println(ans);
    }
    public static boolean isPalindrome(String s){
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int start=0;
        int end=s.length()-1;
        while(start<=end){
            if(s.charAt(start)!=s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}