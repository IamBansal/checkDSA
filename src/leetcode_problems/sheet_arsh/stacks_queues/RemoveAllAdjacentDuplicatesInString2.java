package leetcode_problems.sheet_arsh.stacks_queues;

import java.util.Map;
import java.util.Stack;

public class RemoveAllAdjacentDuplicatesInString2 {

    /*
    1209. Remove All Adjacent Duplicates in String II
    You are given a string s and an integer k, a k duplicate removal consists of choosing
    k adjacent and equal letters from s and removing them, causing the left and the right side
    of the deleted substring to concatenate together.
    We repeatedly make k duplicate removals on s until we no longer can.
    Return the final string after all such duplicate removals have been made.
    It is guaranteed that the answer is unique.
     */

    public static String removeDuplicates(String s, int k) {
        if (s.length() < k) return s;

        Stack<Character> stack = new Stack<>();
        Stack<Integer> stackCounter = new Stack<>();

        for (int i = s.length() - 1; i >= 0; i--) {
            if (!stack.isEmpty() && stack.peek() == s.charAt(i)) {
                if (stackCounter.peek() == k - 1) {
                    for (int j = 1; j < k; j++) {
                        stack.pop();
                        stackCounter.pop();
                    }
                } else {
                    stack.push(s.charAt(i));
                    stackCounter.push(stackCounter.peek() + 1);
                }
            } else {
                stackCounter.push(1);
                stack.push(s.charAt(i));
            }
        }
        String result = "";
        while (!stack.isEmpty()) result += stack.pop();

        return result;
    }

    public static String removeDuplicatesAlternate(String s, int k) {
        if (s.length() < k) return s;

        StringBuilder newString = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        Stack<Integer> stackCounter = new Stack<>();
        for (char c : s.toCharArray()) {
            if (!stack.empty() && stack.peek() == c) {
                if (stackCounter.peek() == k - 1) {
                    for (int j = 1; j < k; j++) {
                        stack.pop();
                        newString.deleteCharAt(newString.length() - 1);
                        stackCounter.pop();
                    }
                } else {
                    stack.push(c);
                    newString.append(c);
                    stackCounter.push(stackCounter.peek() + 1);
                }
            } else {
                stack.push(c);
                stackCounter.push(1);
                newString.append(c);
            }
        }
        return newString.toString();
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates("abcd", 2));
        System.out.println(removeDuplicates("deeedbbcccbdaa", 3));
        System.out.println(removeDuplicates("pbbcggttciiippooaais", 2));
        System.out.println(removeDuplicatesAlternate("abcd", 2));
        System.out.println(removeDuplicatesAlternate("deeedbbcccbdaa", 3));
        System.out.println(removeDuplicatesAlternate("pbbcggttciiippooaais", 2));
    }
}
