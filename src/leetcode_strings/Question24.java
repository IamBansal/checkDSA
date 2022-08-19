package leetcode_strings;

public class Question24 {

    /*
    Given two strings a and b, return the length of the longest uncommon subsequence between a and b.
    If the longest uncommon subsequence does not exist, return -1.

An uncommon subsequence between two strings is a string that is a subsequence of one but not the other.

A subsequence of a string s is a string that can be obtained after deleting any number of characters from s.

For example, "abc" is a subsequence of "aebdc" because you can delete the underlined characters in "aebdc" to get "abc".
Other subsequences of "aebdc" include "aebdc", "aeb", and "" (empty string).

     */

    public static int findLUSLength(String a, String b) {
        int a1=a.length();
        int b1=b.length();
        if(a.equals(b))
        {
            return -1;
        }
        return Math.max(a1, b1);
    }

    public static void main(String[] args) {
        System.out.println(findLUSLength("aba", "cdc"));
        System.out.println(findLUSLength("aaa", "bbb"));
        System.out.println(findLUSLength("aaa", "aaa"));
    }
}
