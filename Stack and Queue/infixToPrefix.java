// Step 1: Reverse the expression
// Step 2: Infix to postfix(with some certain conditions)
// Step 3: Reverse the expression
import java.util.Stack;
public class infixToPrefix {
    public static void main(String[] args) {
        String s = "a+b*(c^d-e)";
        s = reverse(s);
        s = infixToPostfix(s);
        s= reverse(s);
        System.out.println(s);
    }

    public static String infixToPostfix(String s){
        Stack<Character> st = new Stack<>();
        String a = s;
        String ans = "";
        int i = 0;

        while (i < a.length()) {
            char ch = a.charAt(i);

            if ((ch >= 'A' && ch <= 'Z') ||
                (ch >= 'a' && ch <= 'z') ||
                (ch >= '0' && ch <= '9')) {
                ans += ch;
            }

            else if (ch == '(') {
                st.push(ch);
            }

            else if (ch == ')') {
                while (!st.isEmpty() && st.peek() != '(') {
                    ans += st.peek();
                    st.pop();
                }
                if (!st.isEmpty() && st.peek() == '(') {
                    st.pop();  // pop the '('
                }
            }

            else {
                while (!st.isEmpty() && priority(ch) < priority(st.peek())) {
                    ans += st.peek();
                    st.pop();
                }
                st.push(ch);
            }

            i++;
        }

        while (!st.isEmpty()) {
            ans += st.peek();
            st.pop();
        }

        return ans;


    }

    public static String reverse(String s){
        StringBuilder a = new StringBuilder();
        for(int i = s.length() - 1; i >= 0; i--){
        char ch = s.charAt(i);
        if(ch == '(')
            a.append(')');
        else if(ch == ')')
            a.append('(');
        else
            a.append(ch);
        }
        return a.toString();

    }

    public static int priority(char ch) {
        if (ch == '+' || ch == '-') return 1;
        if (ch == '*' || ch == '/') return 2;
        if (ch == '^') return 3;
        return 0;
    }
}
