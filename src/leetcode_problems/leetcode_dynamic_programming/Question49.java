package leetcode_problems.leetcode_dynamic_programming;

import java.util.Arrays;

public class Question49 {

    /*
    132. Palindrome Partitioning II
    Given a string s, partition s such that every substring of the partition is a palindrome.
    Return the minimum cuts needed for a palindrome partitioning of s.
     */

    private static boolean isPalindrome(String s, int start, int end) {
        while (start <= end) {
            if (s.charAt(start++) != s.charAt(end--)) return false;
        }
        return true;
    }


    //Memoized solution
    public static int minCut(String s) {
        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);
        return helper(s, 0, dp) - 1;
    }

    private static int helper(String s, int i, int[] dp) {
        if (i == s.length()) return 0;

        if (dp[i] != -1) return dp[i];

        int min = (int) 1e9;
        for (int j = i; j < s.length(); j++) {
            if (isPalindrome(s, i, j)) {
                int cost = 1 + helper(s, j + 1, dp);
                min = Math.min(min, cost);
            }
        }
        return dp[i] = min;
    }

    //Tabulated solution
    public static int minCutTabulated(String s) {

        int[] dp = new int[s.length() + 1];
        dp[s.length()] = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            int min = (int) 1e9;
            for (int j = i; j < s.length(); j++) {
                if (isPalindrome(s, i, j)) {
                    int cost = 1 + dp[j + 1];
                    min = Math.min(min, cost);
                }
            }
            dp[i] = min;
        }
        return dp[0] - 1;
    }

    public static void main(String[] args) {
        System.out.println(minCut("aab"));
        System.out.println(minCut("a"));
        System.out.println(minCut("ab"));
        System.out.println();
        System.out.println(minCutTabulated("aab"));
        System.out.println(minCutTabulated("a"));
        System.out.println(minCutTabulated("ab"));
    }
}
