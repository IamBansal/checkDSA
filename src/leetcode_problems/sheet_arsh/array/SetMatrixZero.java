package leetcode_problems.sheet_arsh.array;

import java.util.ArrayList;
import java.util.Arrays;

public class SetMatrixZero {

    /*
    73. Set Matrix Zeroes
    Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.
    You must do it in place.
     */

    public static void setZeroes(int[][] matrix) {
        ArrayList<Integer> row = new ArrayList<>();
        ArrayList<Integer> column = new ArrayList<>();

        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[i].length; j++){
                if (matrix[i][j] == 0){
                    if (!row.contains(i)) row.add(i);
                    if (!column.contains(j)) column.add(j);
                }
            }
        }

        while (!row.isEmpty()){
            Arrays.fill(matrix[row.remove(0)], 0);
        }

        while (!column.isEmpty()){
            int j = column.remove(0);
            for (int[] ints : matrix) ints[j] = 0;
        }

        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        setZeroes(matrix);
    }
}
