package leetcode_problems.leetcode_dynamic_programming;

public class Question53 {

    /*
    1277. Count Square Submatrices with All Ones
    Given a m * n matrix of ones and zeros, return how many square submatrices have all ones.
     */

    public static int countSquares(int[][] matrix) {

        int[][] dp = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i == 0 || j == 0) dp[i][j] = matrix[i][j];
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) dp[i][j] = 0;
                else dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
            }
        }

        int sum = 0;
        for (int[] arr : dp) {
            for (Integer e : arr) sum += e;
        }

        return sum;
    }

    public static void main(String[] args) {
        int[][] matrix = {{0, 1, 1, 1}, {1, 1, 1, 1}, {0, 1, 1, 1}};
        int[][] matrix1 = {{1, 0, 1}, {1, 1, 0}, {1, 1, 0}};
        System.out.println(countSquares(matrix));
        System.out.println(countSquares(matrix1));
    }
}
