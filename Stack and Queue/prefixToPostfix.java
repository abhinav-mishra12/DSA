import java.util.Stack;
public class prefixToPostfix {
        // Check if the character is an operator
    static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '^';
    }

    // Convert Prefix to Postfix
    static String prefixToPostfix(String prefix) {
        Stack<String> stack = new Stack<>();

        // Read the prefix expression in reverse order
        for (int i = prefix.length() - 1; i >= 0; i--) {
            char ch = prefix.charAt(i);

            // If character is operator
            if (isOperator(ch)) {
                // Pop two operands from stack
                String op1 = stack.pop();
                String op2 = stack.pop();

                // Combine them in postfix order
                String temp = op1 + op2 + ch;

                // Push the result back to stack
                stack.push(temp);
            } else {
                // If character is operand, push to stack
                stack.push(ch + "");
            }
        }

        // Final element of stack is the postfix expression
        return stack.peek();
    }

    public static void main(String[] args) {
        String prefix = "*+AB-CD";
        String postfix = prefixToPostfix(prefix);

        System.out.println("Prefix Expression: " + prefix);
        System.out.println("Postfix Expression: " + postfix);
    }
}
