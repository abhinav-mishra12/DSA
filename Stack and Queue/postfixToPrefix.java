import java.util.Stack;
public class postfixToPrefix {
    public static void main(String[] args) {
        String postfix = "ab+cd-*";  // Example: (a + b) * (c - d)
        String prefix = convertPostfixToPrefix(postfix);
        System.out.println("Postfix: " + postfix);
        System.out.println("Prefix: " + prefix);
    }
    public static String convertPostfixToPrefix(String postfix) {
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < postfix.length(); i++) {
            char ch = postfix.charAt(i);

            if (Character.isLetterOrDigit(ch)) {
                stack.push(String.valueOf(ch));
            } else if (isOperator(ch)) {
                String op2 = stack.pop();
                String op1 = stack.pop();
                String expr = ch + op1 + op2;
                stack.push(expr);
            }
        }

        return stack.pop(); // Final prefix expression
    }

    public static boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^';
    }
}
