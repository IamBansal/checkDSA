package leetcode_problems.leetcode_strings;

import java.util.Stack;

public class Question3 {

    /*
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']',
determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
     */

    public static boolean isValid(String s) {
        Stack<Character> openingBrackets = new Stack<>();
        for (Character c : s.toCharArray()) {
            if (c == ']' && !openingBrackets.isEmpty() && openingBrackets.peek() == '[') {
                openingBrackets.pop();
            } else if (c == ')' && !openingBrackets.isEmpty() && openingBrackets.peek() == '(') {
                openingBrackets.pop();
            } else if (c == '}' && !openingBrackets.isEmpty() && openingBrackets.peek() == '{') {
                openingBrackets.pop();
            } else {
                if (c == '{' || c == '[' || c == '(' || c == ']' || c == ')' || c == '}')
                    openingBrackets.push(c);
            }
        }
        return openingBrackets.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("()[]{}"));
    }
}
