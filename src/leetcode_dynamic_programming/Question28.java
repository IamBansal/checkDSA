package leetcode_dynamic_programming;

import java.util.Arrays;

public class Question28 {

    /*
    516. Longest Palindromic Subsequence

    Given a string s, find the longest palindromic subsequence's length in s.
    A subsequence is a sequence that can be derived from another sequence by deleting some or no elements
     without changing the order of the remaining elements.
     */

    public static int longestPalindromeSubsequence(String text1) {

        StringBuilder text2 = new StringBuilder();
        for (int i = text1.length() - 1; i >= 0; i--) text2.append(text1.charAt(i));

        int[] prev = new int[text2.length() + 1];
        int[] curr = new int[text2.length() + 1];
        Arrays.fill(prev, 0);

        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j < prev.length; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) curr[j] = 1 + prev[j - 1];
                else curr[j] = Math.max(prev[j], curr[j - 1]);
            }
            System.arraycopy(curr, 0, prev, 0, prev.length);
        }

        return prev[text2.length()];

    }

    public static void main(String[] args) {
        System.out.println(longestPalindromeSubsequence("bbbab"));
        System.out.println(longestPalindromeSubsequence("cbbd"));
    }
}
