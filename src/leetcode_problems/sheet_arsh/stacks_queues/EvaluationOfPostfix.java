package leetcode_problems.sheet_arsh.stacks_queues;

import java.util.Stack;

public class EvaluationOfPostfix {

    /*
    GFG Problem

    Evaluation of Postfix Expression
    Given string S representing a postfix expression, the task is to evaluate the expression
    and find the final value. Operators will only include the basic arithmetic operators like
     *, /, + and -.
     */

    public static int evaluatePostFix(String s) {
        Stack<Integer> stack = new Stack<>();

        for (char c: s.toCharArray()){
            if (c >= '0' && c <= '9') stack.push(c - '0');
            else {
                switch (c) {
                    case '+' -> stack.push(stack.pop() + stack.pop());
                    case '-' -> stack.push(- stack.pop() + stack.pop());
                    case '*' -> stack.push(stack.pop() * stack.pop());
                    case '/' -> {
                        int val = stack.pop();
                        stack.push(stack.pop() / val);
                    }
                }
            }
        }

        return stack.pop();
    }

    public static void main(String[] args) {
        System.out.println(evaluatePostFix("231*+9-"));
        System.out.println(evaluatePostFix("123+*8-"));
    }
}
