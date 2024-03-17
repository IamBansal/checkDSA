package leetcode_problems.sheet_arsh.strings;

import java.util.Stack;

public class BasicCalculator2 {

    /*
    227. Basic Calculator II
    Given a string s which represents an expression, evaluate this expression and return its value.
    The integer division should truncate toward zero.
    You may assume that the given expression is always valid.
    All intermediate results will be in the range of [-2^31, 2^31 - 1].
    Note: You are not allowed to use any built-in function which evaluates strings as
    mathematical expressions, such as eval().
     */

    public static int calculate(String s) {
        if (s.length() == 1 && !s.equals(" ")) return Integer.parseInt(s);

        Stack<Integer> stack = new Stack<>();
        Stack<Character> operator = new Stack<>();

//        for (char c : s.toCharArray()) {
//            if (c >= 48 && c <= 57) stack.push(c - 48);
//            else if (c == '+' || c == '-' || c == '*' || c == '/') operator.push(c);
//        }

        char[] array = s.toCharArray();
        int num = 0;
        for (int i = 0; i < array.length; i++) {
            char c = array[i];
            if (i != array.length - 1) {
                if (array[i] >= 48 && array[i] <= 57) {
                    if (array[i + 1] >= 48 && array[i + 1] <= 57) {
                        num = num * 10;
                        num += array[i] - 48;
                        System.out.println("num is " + num);
                    } else {
                        num = num * 10;
                        num += array[i] - 48;
                        stack.push(num);
                        num = 0;
                    }
                } else if (c == '+' || c == '-' || c == '*' || c == '/') operator.push(c);
            } else {
                if (c >= 48 && c <= 57) {
                    num = num * 10;
                    num += array[i] - 48;
                    stack.push(num);
                    System.out.println("num is " + num);
                } else if (c == '+' || c == '-' || c == '*' || c == '/') operator.push(c);
            }
        }

        System.out.println(stack);
        System.out.println(operator);
        int result = stack.pop();

        while (!stack.empty() && !operator.empty()) {

            int first = result;
            int second = stack.pop();
            char op = operator.pop();
            if (!operator.empty() && operator.peek() == '-') second = -1 * second;
            switch (op) {
                case '+' -> result = first + second;
                case '-' -> result = second - first;
                case '*' -> result = first * second;
                case '/' -> result = second / first;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(calculate("3+2*2"));
        System.out.println(calculate(" 3/2 "));
        System.out.println(calculate(" 3+5 / 2 "));
        System.out.println(calculate(" 3-5 "));
        System.out.println(calculate("42"));
        System.out.println(calculate("42-2"));
        System.out.println(calculate("0-2147483647"));
        System.out.println(calculate("1-1-1"));
    }
}
