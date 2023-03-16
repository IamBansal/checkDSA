package leetcode_dynamic_programming;

public class Question7 {

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
        System.out.println(longestPalindrome("bb"));
        System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome("cabbd"));
        System.out.println(longestPalindrome("abcdeffedba"));
    }
}
