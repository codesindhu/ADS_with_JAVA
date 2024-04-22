import java.util.Scanner;
import java.util.Stack;

public class InfixToPrefix {
    
    // Function to check if a character is an operator
    static boolean isOperator(char ch) {
        return (ch == '+' || ch == '-' || ch == '*' || ch == '/');
    }

    // Function to get the precedence of an operator
    static int precedence(char op) {
        switch(op) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
        }
        return -1;
    }

    
    
    static String infixToPrefix(String infix) {
        StringBuilder prefix = new StringBuilder();


        StringBuilder infixReversed = new StringBuilder(infix).reverse();
        Stack<Character> stack = new Stack<>();




        for (int i = 0; i < infixReversed.length(); i++) {
            char ch = infixReversed.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                prefix.append(ch);
            } else if (ch == ')') {
                stack.push(ch);
            } else if (ch == '(') {
                while (!stack.isEmpty() && stack.peek() != ')') {
                    prefix.append(stack.pop());
                }
                stack.pop(); // Discard the ')'
            } else { // Operator
                while (!stack.isEmpty() && precedence(ch) < precedence(stack.peek())) {
                    prefix.append(stack.pop());
                }
                stack.push(ch);
            }
        }
        while (!stack.isEmpty()) {
            prefix.append(stack.pop());
        }
        return prefix.reverse().toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the infix expression:");
        String infixExpression = scanner.nextLine();
        scanner.close();
        
        System.out.println("Infix Expression: " + infixExpression);

        System.out.println("Prefix Expression: " + infixToPrefix(infixExpression));
    }
}

