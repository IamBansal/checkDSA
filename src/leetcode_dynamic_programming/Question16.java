package leetcode_dynamic_programming;

public class Question16 {

    /*
    1463. Cherry Pickup II

    You are given a rows x cols matrix grid representing a field of cherries where grid[i][j]
    represents the number of cherries that you can collect from the (i, j) cell.
    You have two robots that can collect cherries for you:
    - Robot #1 is located at the top-left corner (0, 0), and
    - Robot #2 is located at the top-right corner (0, cols - 1).

    Return the maximum number of cherries collection using both robots by following the rules below:
    - From a cell (i, j), robots can move to cell (i + 1, j - 1), (i + 1, j), or (i + 1, j + 1).
    - When any robot passes through a cell, It picks up all cherries, and the cell becomes an empty cell.
    - When both robots stay in the same cell, only one takes the cherries.
    - Both robots cannot move outside the grid at any moment.
    - Both robots should reach the bottom row in grid.

     */

    public static int cherryPickup(int[][] grid) {

        int r = grid.length;
        int c = grid[0].length;

        int[][][] dp = new int[r][c][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                for (int k = 0; k < c; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }

        return helper(0, 0, c - 1, r, c, grid, dp);
    }

    public static int helper(int i, int j1, int j2, int r, int c, int[][] grid, int[][][] dp) {
        if (j1 < 0 || j2 < 0 || j1 >= c || j2 >= c) return (int) -1e8;
        if (i == r - 1) {
            if (j1 == j2) return grid[i][j1];
            else return grid[i][j1] + grid[i][j2];
        }

        if (dp[i][j1][j2] != -1) return dp[i][j1][j2];

        //explore paths
        int max = (int) -1e8;
        for (int dj1 = -1; dj1 <= 1; dj1++) {
            for (int dj2 = -1; dj2 <= 1; dj2++) {
                int value;
                if (j1 == j2) value = grid[i][j1];
                else value = grid[i][j1] + grid[i][j2];
                value += helper(i + 1, j1 + dj1, j2 + dj2, r, c, grid, dp);
                max = Math.max(max, value);
            }
        }
        return dp[i][j1][j2] = max;

    }

    public static void main(String[] args) {

        int[][] grid = {{3, 1, 1}, {2, 5, 1}, {1, 5, 5}, {2, 1, 1}};
        int[][] grid2 = {{1, 0, 0, 0, 0, 0, 1}, {2, 0, 0, 0, 0, 3, 0}, {2, 0, 9, 0, 0, 0, 0}, {0, 3, 0, 5, 4, 0, 0}, {1, 0, 2, 3, 0, 0, 6}};

        System.out.println(cherryPickup(grid));
        System.out.println(cherryPickup(grid2));

    }
}
