/*You are given an array of strings tokens that represents an arithmetic expression in a Reverse Polish Notation.

Evaluate the expression. Return an integer that represents the value of the expression.

Note that:

The valid operators are '+', '-', '*', and '/'.
Each operand may be an integer or another expression.
The division between two integers always truncates toward zero.
There will not be any division by zero.
The input represents a valid arithmetic expression in a reverse polish notation.
The answer and all the intermediate calculations can be represented in a 32-bit integer.*/

import java.util.Stack;

class Solution {
    public int evalRPN(String[] tokens) {

        int n = tokens.length;
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            if (tokens[i].equals("+")) {
                int b = Integer.parseInt(stack.pop());
                int a = Integer.parseInt(stack.pop());
                stack.push(String.valueOf(a + b));
            } else if (tokens[i].equals("-")) {
                int b = Integer.parseInt(stack.pop());
                int a = Integer.parseInt(stack.pop());
                stack.push(String.valueOf(a - b));
            } else if (tokens[i].equals("*")) {
                int b = Integer.parseInt(stack.pop());
                int a = Integer.parseInt(stack.pop());
                stack.push(String.valueOf(a * b));
            } else if (tokens[i].equals("/")) {
                int b = Integer.parseInt(stack.pop());
                int a = Integer.parseInt(stack.pop());
                stack.push(String.valueOf(a / b));
            } else {
                stack.push(tokens[i]);
            }
        }

        return Integer.parseInt(stack.pop());
    }
}
