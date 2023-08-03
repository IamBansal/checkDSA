package leetcode_problems.sheet_arsh.stacks_queues;

import java.util.Stack;

public class BackspaceStringCompare {

    /*
    844. Backspace String Compare
    Given two strings s and t, return true if they are equal when both are typed into
    empty text editors. '#' means a backspace character.

    Note that after backspacing an empty text, the text will continue empty.
     */

    public static boolean backspaceCompare(String s, String t) {
        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '#') {
                if (!stack1.isEmpty()) stack1.pop();
            } else stack1.push(c);
        }
        for (char c : t.toCharArray()) {
            if (c == '#') {
                if (!stack2.isEmpty()) stack2.pop();
            } else stack2.push(c);
        }

        if (stack2.size() != stack1.size()) return false;

        while (!stack1.isEmpty()) if (stack1.pop() != stack2.pop()) return false;

        return true;
    }

    public static void main(String[] args) {
        System.out.println(backspaceCompare("ab#c", "ad#c"));
        System.out.println(backspaceCompare("ab##", "d#c#"));
        System.out.println(backspaceCompare("a#c", "b"));
        System.out.println(backspaceCompare("a#c", "a"));
        System.out.println(backspaceCompare("xywrrmp", "xywrrmu#p"));
    }
}
