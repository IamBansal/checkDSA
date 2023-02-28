package leetcode_recursion;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Question10 {

    /*
    Given an encoded string, return its decoded string.

    The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times.
    Note that k is guaranteed to be a positive integer.

    You may assume that the input string is always valid;
    there are no extra white spaces, square brackets are well-formed, etc.
    Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k.
    For example, there will not be input like 3a or 2[4].

    The test cases are generated so that the length of the output will never exceed 105.
     */

    public static String decodeWithoutRecursion(String s) {
        Stack<Integer> numStack = new Stack<>();
        Stack<StringBuilder> strBuild = new Stack<>();
        StringBuilder str = new StringBuilder();
        int num = 0;
        for (char c : s.toCharArray()) {
            if (c >= '0' && c <= '9') {
                num = num * 10 + c - '0';
            } else if (c == '[') {
                strBuild.push(str);
                str = new StringBuilder();
                numStack.push(num);
                num = 0;
            } else if (c == ']') {
                StringBuilder temp = str;
                str = strBuild.pop();
                int count = numStack.pop();
                while (count-- > 0) {
                    str.append(temp);
                }
            } else {
                str.append(c);
            }
        }
        return str.toString();

    }

    //With Recursion
//    public static String decodeString(String s) {
//
//        Stack<Character> stack = new Stack<>();
//
//        String result = "";
//
//        return check(s, stack, result);
//
//    }
//
//    public static String check(String s, Stack<Character> stack, String result) {
//
//        if (s.length() == 0) {
//            return s;
//        }
//        String str = "";
//
//        if (s.charAt(0) == '[') {
//            stack.push('[');
//            System.out.println("bracket");
//            return check(s.substring(1), stack, result);
//
//        } else if (48 <= s.charAt(0) && s.charAt(0) <= 57) {
//
//            System.out.println("number");
//            int num = s.charAt(0) - '0';
//
//            String res = check(s.substring(1), stack, result);
//
//            if (stack.isEmpty()) {
//                while (num > 0) {
//                    result = result.concat(res);
//                    num--;
//                }
//                result = result + check(s.substring(res.length() + 3), stack, result);
//            } else {
//                res = check(s.substring(1), stack, result);
//            }
//            return result;
//
//        } else {
//
//            if (s.charAt(0) == ']') {
//                stack.pop();
//                System.out.println("closing");
//                return "";
//            } else {
//
//                System.out.println("letter");
//                str = str.concat(String.valueOf(s.charAt(0)));
//                str = str.concat(check(s.substring(1), stack, result));
//                return str;
//
//            }
//
//        }
//
//    }

    public static String decodeString(String s) {
        Queue<Character> queue = new LinkedList<>();
        for (char c : s.toCharArray()) queue.offer(c);
        return helper(queue);
    }

    public static String helper(Queue<Character> queue) {
        StringBuilder sb = new StringBuilder();
        int num = 0;
        while (!queue.isEmpty()) {
            char c = queue.poll();
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            } else if (c == '[') {
                String sub = helper(queue);
                sb.append((sub).repeat(Math.max(0, num)));
                num = 0;
            } else if (c == ']') {
                break;
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        System.out.println(decodeString("3[a]2[bc]"));
        System.out.println();
        System.out.println(decodeString("3[a2[c]]"));
    }

}
