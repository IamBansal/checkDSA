package leetcode_problems.sheet_arsh.stacks_queues;

import java.util.Stack;

public class EvaluateReversePolishNotation {

    /*
    150. Evaluate Reverse Polish Notation
    You are given an array of strings tokens that represents an arithmetic expression in a Reverse Polish Notation.
    Evaluate the expression. Return an integer that represents the value of the expression.
    Note that:
    - The valid operators are '+', '-', '*', and '/'.
    - Each operand may be an integer or another expression.
    - The division between two integers always truncates toward zero.
    - There will not be any division by zero.
    - The input represents a valid arithmetic expression in a reverse polish notation.
    - The answer and all the intermediate calculations can be represented in a 32-bit integer.
     */

    public static int evalRPN(String[] tokens) {
        Stack<Integer> stackNumber = new Stack<>();

        for (String c : tokens) {
            switch (c) {
                case "+" -> stackNumber.push(stackNumber.pop() + stackNumber.pop());
                case "-" -> stackNumber.push(-stackNumber.pop() + stackNumber.pop());
                case "*" -> stackNumber.push(stackNumber.pop() * stackNumber.pop());
                case "/" -> {
                    int val = stackNumber.pop();
                    stackNumber.push(stackNumber.pop() / val);
                }
                default -> stackNumber.push(Integer.parseInt(c));
            }
        }
        return stackNumber.pop();
    }

    public static void main(String[] args) {
        System.out.println(evalRPN(new String[]{"2", "1", "+", "3", "*"}));
        System.out.println(evalRPN(new String[]{"4", "13", "5", "/", "+"}));
        System.out.println(evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));
    }
}
