package leetcode_problems.sheet_arsh.stacks_queues;

import java.util.Stack;

public class RemoveAllAdjacentDuplicatesInString {

    /*
    1047. Remove All Adjacent Duplicates In String
    You are given a string s consisting of lowercase English letters.
    A duplicate removal consists of choosing two adjacent and equal letters and removing them.
    We repeatedly make duplicate removals on s until we no longer can.
    Return the final string after all such duplicate removals have been made.
    It can be proven that the answer is unique.
     */

    public static String removeDuplicates(String s) {
        if (s.length() == 1) return s;

        Stack<Character> stack = new Stack<>();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (!stack.isEmpty() && stack.peek() == s.charAt(i)) stack.pop();
            else stack.push(s.charAt(i));
        }
        String result = "";
        while (!stack.isEmpty()) result += stack.pop();

        return result;
    }

    public String removeDuplicatesAlternate(String s) {
        if (s.length() == 1) return s;

        StringBuilder newString = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (!stack.empty() && stack.peek() == c) {
                newString.deleteCharAt(newString.length() - 1);
                stack.pop();
            } else {
                stack.push(c);
                newString.append(c);
            }
        }
        return newString.toString();
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates("abbaca"));
        System.out.println(removeDuplicates("azxxzy"));
    }
}
