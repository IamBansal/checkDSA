package leetcode_problems.leetcode_dynamic_programming;

public class Question30 {

    //TODO - FIND BETTER SOLUTION

    /*
    647. Palindromic Substrings

    Given a string s, return the number of palindromic substrings in it.
    A string is a palindrome when it reads the same backward as forward.
    A substring is a contiguous sequence of characters within the string.
     */

    public static int countSubstrings(String str) {
        int n = str.length();
        boolean[][] dp = new boolean[n][n];
        int ans = 0;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                dp[i][j] = str.charAt(i) == str.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]);
                if (dp[i][j]) ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(countSubstrings("abc"));
        System.out.println(countSubstrings("aaa"));
    }
}
