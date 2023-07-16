package leetcode_problems.sheet_arsh.array;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    /*
    54. Spiral Matrix
    Given an m x n matrix, return all elements of the matrix in spiral order.
     */

    public static List<Integer> spiralOrder(int[][] matrix) {

        int left = 0, right = matrix[0].length - 1;
        int top = 0, bottom = matrix.length - 1;

        List<Integer> result = new ArrayList<>();

        while (top <= bottom && left <= right) {

            //Going right
            for (int i = left; i <= right; i++) result.add(matrix[top][i]);
            top++;

            //Going down
            for (int i = top; i <= bottom; i++) result.add(matrix[i][right]);
            right--;

            //Going left with condition that top is above or at bottom
            if (top <= bottom) {
                for (int i = right; i >= left; i--) result.add(matrix[bottom][i]);
                bottom--;
            }

            //Going up with condition that left is before or at right
            if (left <= right) {
                for (int i = bottom; i >= top; i--) result.add(matrix[i][left]);
                left++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4, 5, 6, 7}};
        int[][] matrix1 = {{1,2,3}, {4,5,6}, {7,8,9}};
        System.out.println(spiralOrder(matrix));
        System.out.println(spiralOrder(matrix1));
    }
}
