package leetcode_strings;

public class Question4 {

    /*
    Implement strStr().

Given two strings needle and haystack,
return the index of the first occurrence of needle in haystack,
or -1 if needle is not part of haystack.

Clarification:

What should we return when needle is an empty string?
This is a great question to ask during an interview.

For the purpose of this problem, we will return 0 when needle is an empty string.
This is consistent to C's strStr() and Java's indexOf().
     */

    public static int strStr(String haystack, String needle) {
        if (needle.length() == 0 || needle.toUpperCase().equals(needle.toLowerCase())) {
            return 0;
        } else {
            for (int j = 0; j < haystack.length(); j++) {
                if (haystack.charAt(j) == needle.charAt(0)) {
                    if (haystack.startsWith(needle, j)) {
                        return j;
                    }
                }
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        System.out.println(strStr("hello", "ll"));
        System.out.println(strStr("aaaaa", "bba"));
    }

}
