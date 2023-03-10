package leetcode_dynamic_programming;

public class Question18 {

    /*
    1289. Minimum Falling Path Sum II - HARD

    Given an n x n integer matrix grid, return the minimum sum of a falling path with non-zero shifts.
    A falling path with non-zero shifts is a choice of exactly one element from each row of grid
    such that no two elements chosen in adjacent rows are in the same column.

     */

    //Tabulated solution
    public static int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        if (n == 1) return matrix[0][0];

        int[] dp = new int[n];
        System.arraycopy(matrix[n - 1], 0, dp, 0, n);
        int[] temp = new int[n];

        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                int min = Integer.MAX_VALUE;
                for (int k = 0; k < n; k++) {
                    if (j != k) min = Math.min(min, dp[k]);
                }
                temp[j] = min + matrix[i][j];
            }
            System.arraycopy(temp, 0, dp, 0, n);
        }
        int min = (int) 1e8;
        for (Integer e : dp) min = Math.min(min, e);
        return min;
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] grid2 = {{7}};
        int[][] grid3 = {{2, 2, 1, 2, 2}, {2, 2, 1, 2, 2}, {2, 2, 1, 2, 2}, {2, 2, 1, 2, 2}, {2, 2, 1, 2, 2}};
        System.out.println(minFallingPathSum(grid));  // 13 - ANS
        System.out.println(minFallingPathSum(grid2)); // 7 - ANS
        System.out.println(minFallingPathSum(grid3)); // 7 - ANS
    }
}
