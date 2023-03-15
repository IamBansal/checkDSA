package leetcode_dynamic_programming;

public class Question27 {

    //TODO - FIND BETTER SOLUTION

    /*
    5. Longest Palindromic Substring

    Given a string s, return the longest palindromic substring in s.

     */

    //Recursive solution
    public static String longestPalindromicSubstring(String str) {

        if (str.length() == 1) return str;

        if (isPalindrome(str)) return str;

        String left = longestPalindromicSubstring(str.substring(0, str.length() - 1));
        String right = longestPalindromicSubstring(str.substring(1));

        if (left.length() > right.length()) return left;
        else return right;

    }

    public static boolean isPalindrome(String s) {

        if (s.length() <= 1) return true;

        for (int i = 0; i < s.length() / 2; i++) if (s.charAt(i) != s.charAt(s.length() - 1 - i)) return false;

        return true;
    }

    //Accepted solution - but not best
    public static String longestPalindrome(String str) {
        int n = str.length();
        boolean[][] dp = new boolean[n][n];
        String ans = "";

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                String sub = str.substring(i, j + 1);
                dp[i][j] = str.charAt(i) == str.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]);
                if (dp[i][j] && ans.length() < sub.length()) ans = sub;
            }
        }
        return ans;
    }

    public static void main(String[] args) {

        System.out.println(longestPalindromicSubstring("babad"));
        System.out.println(longestPalindromicSubstring("cbbd"));
        System.out.println(longestPalindromicSubstring("aacabdkacaa"));

        System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome("cbbd"));
        System.out.println(longestPalindrome("aacabdkacaa"));
    }

}
