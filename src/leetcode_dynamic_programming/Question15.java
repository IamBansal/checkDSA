package leetcode_dynamic_programming;

public class Question15 {

    /*
    741. Cherry Pickup

    You are given an n x n grid representing a field of cherries, each cell is one of three possible integers.
    - 0 means the cell is empty, so you can pass through,
    - 1 means the cell contains a cherry that you can pick up and pass through, or
    - -1 means the cell contains a thorn that blocks your way.

    Return the maximum number of cherries you can collect by following the rules below:
    - Starting at the position (0, 0) and reaching (n - 1, n - 1) by moving right
      or down through valid path cells (cells with value 0 or 1).
    - After reaching (n - 1, n - 1), returning to (0, 0) by moving left or up through valid path cells.
    - When passing through a path cell containing a cherry, you pick it up, and the cell becomes an empty cell 0.
    - If there is no valid path between (0, 0) and (n - 1, n - 1), then no cherries can be collected.

     */

    public static int cherryPickup(int[][] grid) {
        int n = grid.length;
        if (n == 1) return grid[0][0];

        if (haveValidPath(grid, n - 1, n - 1))
            return helper(grid, n - 1, n - 1, 0) + helper(grid, n - 1, n - 1, 0);
        else return 0;
    }

    private static boolean haveValidPath(int[][] grid, int row, int column) {
        if (row == 0 && column == 0) return true;
        if (row < 0 || column < 0) return false;
        if (grid[row][column] == -1) return false;

        return haveValidPath(grid, row, column - 1) || haveValidPath(grid, row - 1, column);
    }

    private static int helper(int[][] grid, int row, int column, int val) {

        if (row == 0 && column == 0) return grid[0][0];
        if (row < 0 || column < 0) return 0;
        if (grid[row][column] == -1) return 0;

        val = grid[row][column] + Math.max(helper(grid, row, column - 1, val), helper(grid, row - 1, column, val));
        grid[row][column] = 0;
//        System.out.println(val + " at " + row + ", " + column);
        return val;
    }


    //Memoized solution
    public static int cherryPickupBetter(int[][] grid) {

        int r = grid.length;

        int[][][] dp = new int[r][r + 1][r + 1];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j <= r; j++) {
                for (int k = 0; k <= r; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }

        return Math.max(0, path(0, 0, 0, grid, dp));
    }

    public static int path(int r1, int c1, int c2, int[][] grid, int[][][] dp) {
        int n = grid.length;
        int r2 = r1 + c1 - c2;
        if (r1 >= n || r2 >= n || c1 >= n || c2 >= n || grid[r1][c1] == -1 || grid[r2][c2] == -1) return (int) -1e8;
        if (dp[r1][c1][c2] != -1) return dp[r1][c1][c2];
        if (r1 == n - 1 && c1 == n - 1) return grid[r1][c1];


        int cherries = 0;
        if (r1 == r2 && c1 == c2) cherries += grid[r1][c1];
        else cherries += grid[r1][c1] + grid[r2][c2];


        int f1 = path(r1, c1 + 1, c2 + 1, grid, dp);
        int f2 = path(r1, c1 + 1, c2, grid, dp);
        int f3 = path(r1 + 1, c1, c2 + 1, grid, dp);
        int f4 = path(r1 + 1, c1, c2, grid, dp);

        cherries += Math.max(f1, Math.max(f2, Math.max(f3, f4)));
        return dp[r1][c1][c2] = cherries;
    }


    public static void main(String[] args) {

        int[][] grid1 = {{0, 1, -1}, {1, 0, -1}, {1, 1, 1}};
        int[][] grid2 = {{1, 1, 1, 1, 0, 0, 0}, {0, 0, 0, 1, 0, 0, 0}, {0, 0, 0, 1, 0, 0, 1}, {1, 0, 0, 1, 0, 0, 0}, {0, 0, 0, 1, 0, 0, 0}, {0, 0, 0, 1, 0, 0, 0}, {0, 0, 0, 1, 1, 1, 1}};

        System.out.println(cherryPickupBetter(grid1));
        System.out.println(cherryPickupBetter(grid2));

    }
}
