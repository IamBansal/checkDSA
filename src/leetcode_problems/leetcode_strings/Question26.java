package leetcode_problems.leetcode_strings;

public class Question26 {

    /*
    Given a string s, reverse the order of characters in each word
    within a sentence while still preserving whitespace and initial word order.
     */

    public static String reverseWords(String s) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            int lastIndex = 0;
            if (s.charAt(i) == ' ') {
                if (result.length() != 0) {
                    lastIndex = result.length();
                }
                for (int j = i - 1; j >= lastIndex; j--) {
                    result.append(s.charAt(j));
                }
                result.append(s.charAt(i));
            }
            if (i == s.length() - 1) {
                lastIndex = result.length();
                for (int j = i; j >= lastIndex; j--) {
                    result.append(s.charAt(j));
                }
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("Let's take Leetcode contest"));
        System.out.println(reverseWords("God Ding ok"));
    }
}
