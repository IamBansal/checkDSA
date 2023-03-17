package leetcode_dynamic_programming;

import java.util.Arrays;

public class Question34 {

    /*
    115. Distinct Subsequences
    Given two strings s and t, return the number of distinct subsequences of s which equals t.
    The test cases are generated so that the answer fits on a 32-bit signed integer.
     */

    //Memoized solution
    public static int numDistinct(String s, String t) {
        int[][] dp = new int[s.length()][t.length()];
        for (int[] ints : dp) {
            Arrays.fill(ints, -1);
        }
        return helper(s, t, s.length() - 1, t.length() - 1, dp);
    }

    private static int helper(String s, String t, int i, int j, int[][] dp) {

        if (j < 0) return 1;
        if (i < 0) return 0;

        if (dp[i][j] != -1) return dp[i][j];

        if (s.charAt(i) == t.charAt(j)) return dp[i][j] = helper(s, t, i - 1, j - 1, dp) + helper(s, t, i - 1, j, dp);
        else return dp[i][j] = helper(s, t, i - 1, j, dp);

    }

    //Tabulated solution
    public static int numDistinctBetter(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int[] ints : dp) {
            Arrays.fill(ints, 0);
        }

        for (int i = 0; i <= n; i++) dp[i][0] = 1;
        for (int i = 1; i <= m; i++) dp[0][i] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                else dp[i][j] = dp[i - 1][j];
            }
        }

        return dp[n][m];
    }

    //Space optimised solution -> 1d array optimised (only one array used)
    // in previous question we used two arrays for that.
    public static int numDistinctBest(String s, String t) {
        int[] dp = new int[t.length() + 1];
        Arrays.fill(dp, 0);

        dp[0] = 1;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = t.length(); j >= 1; j--) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) dp[j] = dp[j - 1] + dp[j];
            }
        }

        return dp[t.length()];
    }


    public static void main(String[] args) {
        System.out.println(numDistinct("rabbbit", "rabbit"));
        System.out.println(numDistinct("babgbag", "bag"));
        System.out.println(numDistinctBetter("rabbbit", "rabbit"));
        System.out.println(numDistinctBetter("babgbag", "bag"));
        System.out.println(numDistinctBest("rabbbit", "rabbit"));
        System.out.println(numDistinctBest("babgbag", "bag"));

    }
}
