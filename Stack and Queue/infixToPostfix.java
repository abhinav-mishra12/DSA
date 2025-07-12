import java.util.Stack;

public class infixToPostfix {
    public static void main(String[] args) {
        Stack<Character> st = new Stack<>();
        String s = "a+b*(c^d-e)";  // Example infix expression
        String ans = "";
        int i = 0;

        while (i < s.length()) {
            char ch = s.charAt(i);

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
                while (!st.isEmpty() && priority(ch) <= priority(st.peek())) {
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

        System.out.println("Postfix expression: " + ans);
    }

    public static int priority(char ch) {
        if (ch == '+' || ch == '-') return 1;
        if (ch == '*' || ch == '/') return 2;
        if (ch == '^') return 3;
        return 0;
    }
}
