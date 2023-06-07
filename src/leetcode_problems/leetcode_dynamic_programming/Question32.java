package leetcode_problems.leetcode_dynamic_programming;

public class Question32 {

    /*
    712. Minimum ASCII Delete Sum for Two Strings
    Given two strings s1 and s2, return the lowest ASCII sum of deleted characters to make two strings equal.
     */

    //Approach 1 - DP array will store LCS with max ASCII
    public static int minimumDeleteSum(String text1, String text2) {

        int[][] dp = new int[text1.length() + 1][text2.length() + 1];

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (i == 0 || j == 0) dp[i][j] = 0;
                else if (text1.charAt(i - 1) == text2.charAt(j - 1)) dp[i][j] = text1.charAt(i - 1) + dp[i - 1][j - 1];
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        int asciiTotal = -2 * dp[dp.length - 1][dp[0].length - 1];
        for (int a = 0; a < text1.length(); a++) asciiTotal += text1.charAt(a);
        for (int a = 0; a < text2.length(); a++) asciiTotal += text2.charAt(a);

        return asciiTotal;
    }

    //Approach 2 - DP array will store final answer.
    public static int minDeleteSum2(String s1, String s2) {

        int[][] dp = new int[s1.length() + 1][s2.length() + 1];

        for (int i = 1; i <= s1.length(); i++) dp[i][0] = dp[i - 1][0] + s1.charAt(i - 1);

        for (int i = 1; i <= s2.length(); i++) dp[0][i] = dp[0][i - 1] + s2.charAt(i - 1);

        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1];
                else dp[i][j] = Math.min(dp[i - 1][j] + s1.charAt(i - 1), dp[i][j - 1] + s2.charAt(j - 1));
            }
        }
        return dp[s1.length()][s2.length()];
    }

    public static void main(String[] args) {
        System.out.println(minimumDeleteSum("sea", "eat"));
        System.out.println(minimumDeleteSum("delete", "leet"));
        System.out.println(minimumDeleteSum("xnbteodleejrzeo", "gaouojqkkk"));
        System.out.println();
        System.out.println(minDeleteSum2("sea", "eat"));
        System.out.println(minDeleteSum2("delete", "leet"));
        System.out.println(minDeleteSum2("xnbteodleejrzeo", "gaouojqkkk"));
    }
}
