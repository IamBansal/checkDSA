package leetcode_problems.sheet_arsh.strings;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseWords {

    /*
    151. Reverse Words in a String
    Given an input string s, reverse the order of the words.
    A word is defined as a sequence of non-space characters.
    The words in s will be separated by at least one space.
    Return a string of the words in reverse order concatenated by a single space.
    Note that s may contain leading or trailing spaces or multiple spaces between two words.
    The returned string should only have a single space separating the words. Do not include any extra spaces.
     */

    public static String reverseWords(String s) {

        //Adding length of words in queue
        Queue<Integer> q = new LinkedList<>();
        int count = 0;
        char[] array = s.toCharArray();
        for (int i = 0; i < array.length; i++) {
            if (array[i] == ' ') {
                if (count != 0) q.add(count);
                count = 0;
            } else count++;
            if (i == array.length - 1 && array[i] != ' ') q.add(count);
        }

        //Removing white spaces
        StringBuilder sNew = new StringBuilder();
        for (char c : array) if (c != ' ') sNew.append(c);

        //Adding separate words in stack
        Stack<String> stack = new Stack<>();
        int length, prev = 0;
        while (!q.isEmpty()) {
            length = q.remove();
            stack.push(sNew.substring(prev, length + prev));
            prev = prev + length;
        }

        //Result formation
        StringBuilder result = new StringBuilder();
        while (!stack.empty()) {
            result.append(stack.pop());
            if (!stack.empty()) result.append(" ");
        }
        return result.toString();
    }


    public static void main(String[] args) {
        System.out.println(reverseWords("the sky is blue"));
        System.out.println(reverseWords("  hello world  "));
        System.out.println(reverseWords("a good   example"));
    }

}
