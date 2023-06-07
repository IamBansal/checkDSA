package leetcode_problems.leetcode_strings;

public class Question16 {

    /*
        Given two strings s and t, return true if s is a subsequence of t, or false otherwise.

    A subsequence of a string is a new string that is formed from the original string
    by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters.
    (i.e., "ace" is a subsequence of "abcde" while "aec" is not).

     */

    public static boolean isSubsequence(String s, String t) {
        int slow = 0, length = s.length();
        if (length == 0) {
            return true;
        }
        for (int i = 0; i < t.length(); i++) {
            char ch = s.charAt(slow);
            char th = t.charAt(i);
            if (ch == th) {
                slow++;
            }
            if (slow == length) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isSubsequence("acb", "ahbgdc"));
        System.out.println(isSubsequence("", ""));
        System.out.println(isSubsequence("", "vsd"));
        System.out.println(isSubsequence("ab", "baab"));
        System.out.println(isSubsequence("abc", "ahbgdc"));
        System.out.println(isSubsequence("axc", "ahbgdc"));
        System.out.println(isSubsequence("axcsdkjgfgfu", "ahbgdc"));
    }
}
