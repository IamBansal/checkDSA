package leetcode_dynamic_programming;

public class Question12 {

    /*
    64. Minimum Path Sum
     Given m x n grid filled with non-negative numbers, find a path from top left to bottom right,
     which minimizes the sum of all numbers along its path.

     Note: You can only move either down or right at any point in time.
     */

    //Memoized solution
    public static int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        return helper(grid, grid.length - 1, grid[0].length - 1, dp);
    }

    private static int helper(int[][] grid, int i, int j, int[][] dp) {

        if (i == 0 && j == 0) return grid[i][j];
        if (i < 0 || j < 0) return (int) 1e7;

        if (dp[i][j] != -1) return dp[i][j];
        else dp[i][j] = grid[i][j] + Math.min(helper(grid, i - 1, j, dp), helper(grid, i, j - 1, dp));
        return dp[i][j];

    }

    //Tabulated solution
    public static int minPathSumBetter(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (i == 0 && j == 0) dp[i][j] = grid[i][j];
                else {
                    int up = (int) 1e7, left = (int) 1e7;
                    if (i > 0) up = dp[i - 1][j];
                    if (j > 0) left = dp[i][j - 1];
                    dp[i][j] = grid[i][j] + Math.min(up, left);
                }
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }

    public static void main(String[] args) {

        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(minPathSum(grid));
        System.out.println(minPathSumBetter(grid));

        int[][] grid2 = {{1, 2, 3}, {4, 5, 6}};
        System.out.println(minPathSum(grid2));
        System.out.println(minPathSumBetter(grid2));
    }
}
