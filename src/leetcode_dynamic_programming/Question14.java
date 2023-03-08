package leetcode_dynamic_programming;

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

    public static int minimumTotal(List<List<Integer>> triangle) {

        if (triangle.size() == 1) return triangle.get(0).get(0);
        int min = (int) 1e7;

        return helper(triangle, triangle.size() - 1, min, triangle.size() - 1, triangle.size() - 2);

    }

    private static int helper(List<List<Integer>> triangle, int row, int min, int column, int prevColumn) {

        if (row <= 0) return triangle.get(0).get(0);
        if (column == 0) prevColumn = 0;
        for (int i = prevColumn; i <= column; i++) {
            min = Math.min(min, triangle.get(row).get(i) + helper(triangle, row - 1, min, i, i - 1));
        }
        return min;
    }

    public static int minimumTotalBetter(List<List<Integer>> triangle) {
        int[] A = new int[triangle.size() + 1];
        for (int i = triangle.size() - 1; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                A[j] = Math.min(A[j], A[j + 1]) + triangle.get(i).get(j);
            }
        }
        return A[0];
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

        System.out.println(minimumTotal(finaList));
        System.out.println(minimumTotalBetter(finaList));
    }
}
