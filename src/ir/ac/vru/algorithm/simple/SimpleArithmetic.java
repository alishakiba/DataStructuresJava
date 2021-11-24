package ir.ac.vru.algorithm.simple;

import java.util.Scanner;
import java.util.Stack;

public class SimpleArithmetic {
    public static void main(String[] args) {
        // read arithmetic expression from the input as an string
        Scanner scanner = new Scanner(System.in);
        String expression = scanner.nextLine();
        // using two stacks to store the operands and operators
        Stack<Character> operatorStack = new Stack<>();
        Stack<Integer> operandStack = new Stack<>();
        // parsing the expression
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (Character.isDigit(c)) {
                // if the character is a digit, push it to the operand stack
                operandStack.push(c - '0');
            }
            else if (c == '+' || c == '-' || c == '*' || c == '/') {
                // if the character is an operator, push it to the operator stack
                operatorStack.push(c);
            }
            else if (c == '(') {
                // if the character is an opening bracket, push it to the operator stack
                operatorStack.push(c);
            }
            else if (c == ')') {
                // if the character is a closing bracket, pop the operator stack until the opening bracket is found
                while (operatorStack.peek() != '(') {
                    char operator = operatorStack.pop();
                    int operand2 = operandStack.pop();
                    int operand1 = operandStack.pop();
                    int result = applyOperator(operator, operand2, operand1);
                    operandStack.push(result);
                }
                // pop the opening bracket
                operatorStack.pop();
            }
            else if (c == ' ') {
                // if the character is a space, ignore it
            }
            else {
                // if the character is not a digit, operator or bracket, throw an exception
                throw new IllegalArgumentException("Invalid character");
            }
        }
        // pop the operator stack until it is empty
        while (!operatorStack.isEmpty()) {
            char operator = operatorStack.pop();
            int operand2 = operandStack.pop();
            int operand1 = operandStack.pop();
            int result = applyOperator(operator, operand2, operand1);
            operandStack.push(result);
        }
        // print the result
        int result = operandStack.pop();
        System.out.println(result);
    }

    private static int applyOperator(char operator, int operand2, int operand1) {
        int result = 0;
        switch (operator) {
            case '+':
                result = operand1 + operand2;
                break;
            case '-':
                result = operand1 - operand2;
                break;
            case '*':
                result = operand1 * operand2;
                break;
            case '/':
                result = operand1 / operand2;
                break;
            default:
                throw new IllegalArgumentException("Invalid operator");
        };
        return result;
    }
}
