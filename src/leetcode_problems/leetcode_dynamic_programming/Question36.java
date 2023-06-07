package leetcode_problems.leetcode_dynamic_programming;

import java.util.Arrays;

public class Question36 {

    /*
    44. Wildcard Matching
    Given an input string (s) and a pattern (p),
    implement wildcard pattern matching with support for '?' and '*' where:
    - '?' Matches any single character.
    - '*' Matches any sequence of characters (including the empty sequence).

    The matching should cover the entire input string (not partial).
     */

    //Memoized solution
    public static boolean isMatch(String s, String p) {
        int[][] dp = new int[s.length()][p.length()];
        for (int[] arr : dp) Arrays.fill(arr, -1);
        return helper(s, p, s.length() - 1, p.length() - 1, dp);
    }

    private static boolean helper(String s, String p, int i, int j, int[][] dp) {

        if (i < 0 && j < 0) return true;
        if (j < 0) return false;
        if (i < 0) {
            for (int i1 = 0; i1 <= j; i1++) {
                if (p.charAt(i1) != '*') return false;
            }
            return true;
        }

        if (dp[i][j] != -1) return dp[i][j] == 1;

        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') {
            dp[i][j] = helper(s, p, i - 1, j - 1, dp) ? 1 : 0;
            return dp[i][j] == 1;
        }

        if (p.charAt(j) == '*') {
            dp[i][j] = (helper(s, p, i - 1, j, dp) || helper(s, p, i, j - 1, dp)) ? 1 : 0;
            return dp[i][j] == 1;
        }

        dp[i][j] = 0;
        return false;
    }

    //Tabulated solution
    public static boolean isMatchTabulated(String s, String p) {

        int n = p.length();
        int m = s.length();

        boolean[][] dp = new boolean[n + 1][m + 1];
        dp[0][0] = true;
        for (int j = 1; j <= m; j++) dp[0][j] = false;
        for (int i = 1; i <= n; i++) {
            boolean f1 = true;
            for (int i1 = 1; i1 <= i; i1++) {
                if (p.charAt(i1 - 1) != '*') {
                    f1 = false;
                    break;
                }
            }
            dp[i][0] = f1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s.charAt(j - 1) == p.charAt(i - 1) || p.charAt(i - 1) == '?') dp[i][j] = dp[i - 1][j - 1];
                else if (p.charAt(i - 1) == '*') dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                else dp[i][j] = false;
            }
        }
        return dp[n][m];

    }

    public static void main(String[] args) {
        System.out.println(isMatch("aa", "a"));
        System.out.println(isMatch("aa", "*"));
        System.out.println(isMatch("cb", "?a"));
        System.out.println(isMatch("", ""));
        System.out.println(isMatch("abcdefgh", "abb*gh"));
        System.out.println(isMatch("abcdefgh", "abc*gh"));
        System.out.println(isMatch("adceb", "*a*b"));
        System.out.println();
        System.out.println(isMatchTabulated("aa", "a"));
        System.out.println(isMatchTabulated("aa", "*"));
        System.out.println(isMatchTabulated("cb", "?a"));
        System.out.println(isMatchTabulated("", ""));
        System.out.println(isMatchTabulated("abcdefgh", "abb*gh"));
        System.out.println(isMatchTabulated("abcdefgh", "abc*gh"));
        System.out.println(isMatchTabulated("adceb", "*a*b"));
    }
}
