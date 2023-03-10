package leetcode_dynamic_programming;

public class Question17 {

    /*
    931. Minimum Falling Path Sum - MEDIUM
    Given an n x n array of integers matrix, return the minimum sum of any falling path through matrix.
    A falling path starts at any element in the first row and chooses the element
    in the next row that is either directly below or diagonally left/right.
    Specifically, the next element from position (row, col) will be (row + 1, col - 1), (row + 1, col), or (row + 1, col + 1).

     */

    //Memoized solution
    public static int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        if (n == 1) return matrix[0][0];

        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0) dp[i][j] = matrix[i][j];
                else dp[i][j] = (int) 1e8;
            }
        }

        int min = (int) 1e7;
        for (int i = 0; i < n; i++) {
            min = Math.min(min, helper(matrix, n - 1, i, dp));
        }
        return min;
    }

    private static int helper(int[][] matrix, int row, int column, int[][] dp) {
        if (row < 0 || column < 0 || column >= matrix.length) return (int) 1e7;
        if (row == 0) return matrix[row][column];

        if (dp[row][column] != (int) 1e8) return dp[row][column];

        int leftUp = helper(matrix, row - 1, column - 1, dp);
        int up = helper(matrix, row - 1, column, dp);
        int rightUp = helper(matrix, row - 1, column + 1, dp);
        return dp[row][column] = matrix[row][column] + Math.min(leftUp, Math.min(rightUp, up));

    }

    //Space optimised tabulated solution
    public static int minFallingPathSumBetter(int[][] matrix) {
        int n = matrix.length;
        if (n == 1) return matrix[0][0];

        int[] dp = new int[n];
        System.arraycopy(matrix[0], 0, dp, 0, n);

        int[] temp = new int[n];

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0) temp[j] = matrix[i][j] + Math.min(dp[j], dp[j + 1]);
                else if (j == n - 1) temp[j] = matrix[i][j] + Math.min(dp[j], dp[j - 1]);
                else temp[j] = matrix[i][j] + Math.min(Math.min(dp[j], dp[j - 1]), dp[j + 1]);
            }
            System.arraycopy(temp, 0, dp, 0, n);
        }

        int min = (int) 1e7;
        for (Integer e : dp) {
            min = Math.min(min, e);
        }
        return min;
    }

    public static void main(String[] args) {

        int[][] matrix = {{2, 1, 3}, {6, 5, 4}, {7, 8, 9}};
        int[][] matrix2 = {{-19, 57}, {-40, -5}};
        System.out.println(minFallingPathSum(matrix));
        System.out.println(minFallingPathSum(matrix2));
        System.out.println(minFallingPathSumBetter(matrix));
        System.out.println(minFallingPathSumBetter(matrix2));

    }
}
