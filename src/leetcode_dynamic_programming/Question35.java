package leetcode_dynamic_programming;

import java.util.Arrays;

public class Question35 {

    /*
    72. Edit Distance
    Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.
    You have the following three operations permitted on a word:
    - Insert a character
    - Delete a character
    - Replace a character
     */

    //Memoized solution
    public static int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()][word2.length()];
        for (int[] arr : dp) Arrays.fill(arr, -1);
        return helper(word1, word2, word1.length() - 1, word2.length() - 1, dp);
    }

    private static int helper(String word1, String word2, int i, int j, int[][] dp) {

        if (i < 0) return j + 1;
        if (j < 0) return i + 1;

        if (dp[i][j] != -1) return dp[i][j];

        if (word1.charAt(i) == word2.charAt(j)) return dp[i][j] = helper(word1, word2, i - 1, j - 1, dp);

        int insert = 1 + helper(word1, word2, i, j - 1, dp);
        int delete = 1 + helper(word1, word2, i - 1, j, dp);
        int replace = 1 + helper(word1, word2, i - 1, j - 1, dp);

        return dp[i][j] = Math.min(insert, Math.min(delete, replace));
    }

    //Tabulated solution
    public static int minDistanceTabulated(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i < dp.length; i++) dp[i][0] = i;
        for (int j = 0; j < dp[0].length; j++) dp[0][j] = j;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1];
                else dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
            }
        }

        return dp[word1.length()][word2.length()];
    }

    //Space Optimised
    public static int minDistanceSpaceOpt(String word1, String word2) {

        int n = word1.length();
        int m = word2.length();

        int[] prev = new int[m + 1];
        int[] curr = new int[m + 1];

        for (int i = 0; i <= m; i++) prev[i] = i;

        for (int i = 1; i <= n; i++) {
            curr[0] = i;
            for (int j = 1; j <= m; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) curr[j] = prev[j - 1];
                else curr[j] = 1 + Math.min(prev[j - 1], Math.min(prev[j], curr[j - 1]));
            }
            System.arraycopy(curr, 0, prev, 0, prev.length);
        }

        return prev[m];
    }

    public static void main(String[] args) {
        System.out.println(minDistance("horse", "ros"));
        System.out.println(minDistance("intention", "execution"));
        System.out.println();
        System.out.println(minDistanceTabulated("horse", "ros"));
        System.out.println(minDistanceTabulated("intention", "execution"));
        System.out.println();
        System.out.println(minDistanceSpaceOpt("horse", "ros"));
        System.out.println(minDistanceSpaceOpt("intention", "execution"));
    }
}
