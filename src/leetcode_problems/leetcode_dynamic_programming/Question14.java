package leetcode_problems.leetcode_dynamic_programming;

import java.util.ArrayList;
import java.util.List;

public class Question14 {

    /*
    120. Triangle
    Given a triangle array, return the minimum path sum from top to bottom.
    For each step, you may move to an adjacent number of the row below.
    More formally, if you are on index i on the current row,
    you may move to either index i or index i + 1 on the next row.
     */

    public static int minimumTotalBetter(List<List<Integer>> triangle) {
        int[] A = new int[triangle.size() + 1];
        for (int i = triangle.size() - 1; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                A[j] = Math.min(A[j], A[j + 1]) + triangle.get(i).get(j);
            }
        }
        return A[0];
    }

    //Memoized solution
    public static int minimumTotal(List<List<Integer>> triangle) {

        int n = triangle.size();
        int[][] array = new int[n][n];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                array[i][j] = (int) 1e8;
            }
        }
        array[0][0] = triangle.get(0).get(0);

        int min = (int) 1e7;
        for (int i = 0; i < n; i++) {
            min = Math.min(min, checkHelper(triangle, n - 1, i, array));
        }
        return min;
    }

    private static int checkHelper(List<List<Integer>> triangle, int row, int column, int[][] array) {

        if (row == 0) return array[0][0];
        if (column < 0 || column > row) return (int) 1e7;

        if (array[row][column] != (int) 1e8) return array[row][column];
        else
            array[row][column] = triangle.get(row).get(column) + Math.min(checkHelper(triangle, row - 1, column, array), checkHelper(triangle, row - 1, column - 1, array));
        return array[row][column];

    }


    public static void main(String[] args) {
        List<Integer> row1 = new ArrayList<>();
        row1.add(2);
        List<Integer> row2 = new ArrayList<>();
        row2.add(3);
        row2.add(4);

        List<Integer> row3 = new ArrayList<>();
        row3.add(6);
        row3.add(5);
        row3.add(7);

        List<Integer> row4 = new ArrayList<>();
        row4.add(4);
        row4.add(1);
        row4.add(8);
        row4.add(3);

        List<List<Integer>> finaList = new ArrayList<>();
        finaList.add(row1);
        finaList.add(row2);
        finaList.add(row3);
        finaList.add(row4);

//        List<Integer> row1 = new ArrayList<>();
//        row1.add(-1);
//        List<Integer> row2 = new ArrayList<>();
//        row2.add(2);
//        row2.add(3);
//
//        List<Integer> row3 = new ArrayList<>();
//        row3.add(1);
//        row3.add(-1);
//        row3.add(-3);
//
//        List<Integer> row4 = new ArrayList<>();
//        row4.add(4);
//        row4.add(1);
//        row4.add(8);
//        row4.add(3);
//
//        List<List<Integer>> finaList = new ArrayList<>();
//        finaList.add(row1);
//        finaList.add(row2);
//        finaList.add(row3);
////        finaList.add(row4);

        System.out.println(minimumTotal(finaList));
        System.out.println(minimumTotalBetter(finaList));
    }
}
