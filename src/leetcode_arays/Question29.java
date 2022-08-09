package leetcode_arays;

public class Question29 {

    /*
    You are given an n x n 2D matrix representing an image,
    rotate the image by 90 degrees (clockwise).

    You have to rotate the image in-place,
    which means you have to modify the input 2D matrix directly.
    DO NOT allocate another 2D matrix and do the rotation.

     */

    public static void rotate(int[][] matrix) {

        int n = matrix.length;
        int[][] check = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                check[i][j] = matrix[j][i];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = check[i][n - 1 - j];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        rotate(matrix);
        int[][] matrix1 = {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        rotate(matrix1);
    }

}
