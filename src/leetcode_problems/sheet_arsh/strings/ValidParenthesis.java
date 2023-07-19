package leetcode_problems.sheet_arsh.strings;

import java.util.Stack;

public class ValidParenthesis {

    /*
    20. Valid Parentheses
    Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
    An input string is valid if:
    - Open brackets must be closed by the same type of brackets.
    - Open brackets must be closed in the correct order.
    - Every close bracket has a corresponding open bracket of the same type.
     */

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] array = s.toCharArray();

        if (array[0] == ')' || array[0] == ']' || array[0] == '}') return false;
        for (char c : array) {
            if (c == ')') {
                if (!stack.isEmpty() && stack.peek() == '(') stack.pop();
                else stack.push(c);
            } else if (c == '}') {
                if (!stack.isEmpty() && stack.peek() == '{') stack.pop();
                else stack.push(c);
            } else if (c == ']') {
                if (!stack.isEmpty() && stack.peek() == '[') stack.pop();
                else stack.push(c);
            } else {
                stack.push(c);
            }
        }
        return stack.empty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("()"));
        System.out.println(isValid("(){}[]"));
        System.out.println(isValid("({[]})"));
        System.out.println(isValid("(]"));
    }
}
