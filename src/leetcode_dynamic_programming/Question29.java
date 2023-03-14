package leetcode_dynamic_programming;

public class Question29 {

    /*
    1092. Shortest Common Supersequence
    Given two strings str1 and str2, return the shortest string that has both str1 and str2 as subsequences.
    If there are multiple valid strings, return any of them.
    A string s is a subsequence of string t if deleting some number of characters from t (possibly 0)
    results in the string s.
     */

    public static String shortestCommonSupersequence(String text1, String text2) {

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
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                str.append(text1.charAt(i - 1));
                i--;
            } else {
                str.append(text2.charAt(j - 1));
                j--;
            }
        }

        while (i > 0) {
            str.append(text1.charAt(i - 1));
            i--;
        }
        while (j > 0) {
            str.append(text2.charAt(j - 1));
            j--;
        }

        return str.reverse().toString();

    }

    public static void main(String[] args) {
        System.out.println(shortestCommonSupersequence("abac", "cab"));
        System.out.println(shortestCommonSupersequence("aaaaaaaa", "aaaaaaaa"));
    }
}

