import java.util.Stack;
public class prefixToInfix {
    public static void main(String[] args) {
        String s = "*+pq-mn";
        Stack<String> st = new Stack<>();
        int i = s.length()-1;
        while (i>=0) {
            char ch = s.charAt(i);
            if ((ch >= 'A' && ch <= 'Z') ||
                (ch >= 'a' && ch <= 'z') ||
                (ch >= '0' && ch <= '9')){
                    st.push(String.valueOf(ch));
                }
            else{
                String t1 = st.pop();
                String t2 = st.pop();
                String con = '(' + t1 + ch + t2 + ')'; //Only difference 
                st.push(con); 
            }
            i--;
        }
        System.out.println(st.peek());
    }
}
