package leetcode_problems.sheet_arsh.greedy;

import java.util.Stack;

public class RemoveKDigits {

    /*

   402. Remove K Digits
Medium
8.3K
360
Companies
Given string num representing a non-negative integer num, and an integer k, return the smallest possible integer after removing k digits from num.


     */

    public static String removeKDigits(String num, int k) {
        if(k == num.length()) return "0";

        Stack<Character> stack = new Stack<>();
        for (char c: num.toCharArray()) stack.add(c);

        int number = helper(k, stack, 0);
        return number + "";
    }

    private static int helper(int k, Stack<Character> stack, int number) {
        if (k == 0 || stack.empty()) return Integer.MAX_VALUE;

        int digit = stack.pop();
        int taken = helper(k, stack, number * 10 + digit);
        int notTaken = helper(k - 1, stack, number);

        return Math.min(taken, notTaken);
    }

    public static void main(String[] args) {
        System.out.println(removeKDigits("1432219", 3));
        System.out.println(removeKDigits("10200", 1));
        System.out.println(removeKDigits("10", 2));
        System.out.println(removeKDigits("10", 1));
    }
}