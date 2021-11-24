package ir.ac.vru.algorithm.simple;

import ir.ac.vru.array.Stack;
import java.util.Scanner;

public class BalancedParentheses {
    public static void main(String[] args) {
        // read input string
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        // check if parentheses are balanced
        boolean balanced = checkBalancedParentheses(input);
        // print result
        if (balanced) {
            System.out.println("Balanced");
        }
        else {
            System.out.println("Not balanced");
        }
    }

    public static boolean checkBalancedParentheses(String input) {
        // check if parentheses are balanced
        Stack<Character> stack = new Stack<Character>(input.length());
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '(') {
                stack.push(c);
            }
            else if (c == ')') {
                if (stack.isEmpty() || stack.pop() != '(') {
                    return false;
                }
            }
            else {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
