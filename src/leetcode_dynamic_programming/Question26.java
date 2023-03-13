package leetcode_dynamic_programming;

import java.util.Arrays;

public class Question26 {

    /*
    1143. Longest Common Subsequence
    Given two strings text1 and text2, return the length of their longest common subsequence.
    If there is no common subsequence, return 0.
    A subsequence of a string is a new string generated from the original string with some characters (can be none)
    deleted without changing the relative order of the remaining characters.

    For example, "ace" is a subsequence of "abcde".
    A common subsequence of two strings is a subsequence that is common to both strings.

   SUBSEQUENCE - Is not continuous, but maintains order.
   SUBSTRING - Is continuous also.\

     */

    //Memoized Solution
    public static int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()][text2.length()];
        for (int[] arr : dp) Arrays.fill(arr, -1);
        return helper(text1, text2, text1.length() - 1, text2.length() - 1, dp);
    }

    private static int helper(String text1, String text2, int i1, int i2, int[][] dp) {
        if (i1 < 0 || i2 < 0) return 0;
        if (dp[i1][i2] != -1) return dp[i1][i2];
        if (text1.charAt(i1) == text2.charAt(i2)) return dp[i1][i2] = 1 + helper(text1, text2, i1 - 1, i2 - 1, dp);
        else return dp[i1][i2] = Math.max(helper(text1, text2, i1, i2 - 1, dp), helper(text1, text2, i1 - 1, i2, dp));
    }

    //Space optimised Tabulated solution
    public static int longestCommonSubsequenceBetter(String text1, String text2) {
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

    //Print Longest Common Subsequence
    public static String printLongestCommonSubsequence(String text1, String text2) {

        //Generating matrix of LCS
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (i == 0 || j == 0) dp[i][j] = 0;
            }
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) dp[i][j] = 1 + dp[i - 1][j - 1];
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }


        //Printing code
        int i = text1.length(), j = text2.length();
        StringBuilder str = new StringBuilder();

        while (i > 0 && j > 0) {
            if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                str.append(text1.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) i--;
            else j--;
        }
        return str.reverse().toString();
    }

    //Space optimised Tabulated solution - substring
    public static int longestCommonSubstring(String text1, String text2) {
        int[] prev = new int[text2.length() + 1];
        int[] curr = new int[text2.length() + 1];
        Arrays.fill(prev, 0);

        int max = 0;
        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j < prev.length; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) curr[j] = 1 + prev[j - 1];
                else curr[j] = 0;
                max = Math.max(max, curr[j]);
            }
            System.arraycopy(curr, 0, prev, 0, prev.length);
        }
        return max;
    }

    public static void main(String[] args) {

        //For longest common subsequence
        System.out.println(longestCommonSubsequence("abcde", "ace"));
        System.out.println(longestCommonSubsequence("abc", "abc"));
        System.out.println(longestCommonSubsequence("abc", "def"));

        System.out.println();

        System.out.println(longestCommonSubsequenceBetter("abcde", "ace"));
        System.out.println(longestCommonSubsequenceBetter("abc", "abc"));
        System.out.println(longestCommonSubsequenceBetter("abc", "def"));
        System.out.println(longestCommonSubsequenceBetter("abcba", "abcbcba"));

        System.out.println();

        //For longest common substring
        System.out.println(longestCommonSubstring("abcde", "ace"));
        System.out.println(longestCommonSubstring("abc", "abc"));
        System.out.println(longestCommonSubstring("abc", "def"));
        System.out.println(longestCommonSubstring("abcba", "abcbcba"));
        System.out.println(longestCommonSubstring("abcd", "abzd"));

        //Print Longest Common Subsequence
        System.out.println(printLongestCommonSubsequence("abcde", "ace"));
        System.out.println(printLongestCommonSubsequence("abc", "abc"));
        System.out.println(printLongestCommonSubsequence("abc", "def"));
        System.out.println(printLongestCommonSubsequence("abcba", "abcbcba"));
        System.out.println(printLongestCommonSubsequence("abcd", "abzd"));

    }
}
