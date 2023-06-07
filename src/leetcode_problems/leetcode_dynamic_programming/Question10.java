package leetcode_problems.leetcode_dynamic_programming;

public class Question10 {

    /*
    63. Unique Paths II

    You are given an m x n integer array grid.
    There is a robot initially located at the top-left corner (i.e., grid[0][0]).
    The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]).
    The robot can only move either down or right at any point in time.
    An obstacle and space are marked as 1 or 0 respectively in grid.
    A path that the robot takes cannot include any square that is an obstacle.
    Return the number of possible unique paths that the robot can take to reach the bottom-right corner.
    The testcases are generated so that the answer will be less than or equal to 2 * 109.

     */

    //Recursive solution
//    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
//        if (obstacleGrid[0][0] == 1) return 0;
//        return helper(obstacleGrid, obstacleGrid.length - 1, obstacleGrid[0].length - 1);
//    }
//
//    private static int helper(int[][] obstacleGrid, int i, int j) {
//
//        if (i == 0 && j == 0) return 1;
//        if (i < 0 || j < 0) return 0;
//        if (obstacleGrid[i][j] == 1) return 0;
//
//        return helper(obstacleGrid, i - 1, j) + helper(obstacleGrid, i, j - 1);
//
//    }

    //Tabulated solution
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1) return 0;

        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (obstacleGrid[i][j] == 1) dp[i][j] = 0;
                else if (i == 0 && j == 0) dp[i][j] = 1;
                else {
                    int up = 0, left = 0;
                    if (i > 0) up = dp[i - 1][j];
                    if (j > 0) left = dp[i][j - 1];
                    dp[i][j] = left + up;
                }
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }


    //Memoized solution
//    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
//        if (obstacleGrid[0][0] == 1) return 0;
//
//        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
//        for( int i = 0; i < dp.length; i++){
//            for (int j = 0; j < dp[0].length; j++) {
//                dp[i][j] = -1;
//            }
//        }
//        return helper(obstacleGrid, dp.length - 1, dp[0].length - 1, dp);
//    }
//
//    private static int helper(int[][] obstacleGrid, int i, int j, int[][] dp) {
//
//        if (i == 0 && j == 0) return 1;
//        if (i < 0 || j < 0) return 0;
//        if (obstacleGrid[i][j] == 1) return 0;
//
//        if (dp[i][j] != -1) return dp[i][j];
//        else dp[i][j] = helper(obstacleGrid, i - 1, j, dp) + helper(obstacleGrid, i, j - 1, dp);
//        return dp[i][j];
//    }

    public static void main(String[] args) {

        int[][] grid = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        System.out.println(uniquePathsWithObstacles(grid));
        int[][] grid2 = {{0, 0}, {1, 1}, {0, 0}};
        System.out.println(uniquePathsWithObstacles(grid2));

    }

}
