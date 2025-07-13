import java.util.Stack;
public class postfixToInfix {
    public static void main(String[] args) {
        Stack<String> st = new Stack<>();
        String s = "ab-de+f*/";
        int i = 0;
        while(i<s.length()){
            char ch = s.charAt(i);
            if ((ch >= 'A' && ch <= 'Z') ||
                (ch >= 'a' && ch <= 'z') ||
                (ch >= '0' && ch <= '9')){
                    st.push(String.valueOf(ch));
                }
            else{
                String t1 = st.pop();
                String t2 = st.pop();
                String con = '(' + t2 + ch + t1 + ')';
                st.push(con); 
            }
            i++;
        }

        System.out.println(st.peek());
    }
}
