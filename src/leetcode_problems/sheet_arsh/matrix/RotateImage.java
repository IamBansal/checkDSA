package leetcode_problems.sheet_arsh.matrix;

public class RotateImage {

    /*
    48. Rotate Image
    You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
    You have to rotate the image in-place, which means you have to modify the input 2D matrix directly.
    DO NOT allocate another 2D matrix and do the rotation.
     */

    //This solution is in-place
    public static void rotateInPlace(int[][] matrix) {

        int n = matrix.length, temp;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for (int j = 0; j < n / 2; j++) {
            for (int i = 0; i < n; i++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = temp;
            }
        }

        //Print the result
        for (int[] array : matrix) {
            for (int num : array) System.out.print(num + " ");
            System.out.println();
        }
        System.out.println();

    }

    //This solution is using extra space
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

        //Print the result
        for (int[] array : matrix) {
            for (int num : array) System.out.print(num + " ");
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        rotate(matrix);
        rotateInPlace(matrix);
        int[][] matrix1 = {{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
        rotate(matrix1);
        rotateInPlace(matrix1);
    }
}
