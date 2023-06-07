package leetcode_problems.leetcode_arays;

import java.util.ArrayList;
import java.util.List;

public class Question32 {

    /*
    Given an m x n matrix, return all elements of the matrix in spiral order.

     */

    int maxLeft, maxRight, maxDown, maxUp, totalValueToVisit, curRow = 0, curCol = -1;

    List<Integer> result = new ArrayList();

    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        totalValueToVisit = m * n;

        setInitialMaxValue(m, n);

        while (totalValueToVisit > 0) {
            goRight(matrix);
            goDown(matrix);
            goLeft(matrix);
            goUp(matrix);
        }

        for (Integer e : result) {
            System.out.print(e + " ");
        }
        System.out.println();

        return result;
    }

    public void goRight(int[][] matrix) {
        if (totalValueToVisit == 0)
            return;
        for (int i = curCol + 1; i < maxRight; i++) {
            result.add(matrix[curRow][i]);
            totalValueToVisit--;
            curCol = i;
        }
        maxRight--;
    }

    public void goDown(int[][] matrix) {
        if (totalValueToVisit == 0)
            return;
        for (int i = curRow + 1; i < maxDown; i++) {
            result.add(matrix[i][curCol]);
            totalValueToVisit--;
            curRow = i;
        }
        maxDown--;
    }

    public void goLeft(int[][] matrix) {
        if (totalValueToVisit == 0)
            return;
        for (int i = curCol - 1; i >= maxLeft; i--) {
            result.add(matrix[curRow][i]);
            totalValueToVisit--;
            curCol = i;
        }
        maxLeft++;
    }

    public void goUp(int[][] matrix) {
        if (totalValueToVisit == 0)
            return;
        for (int i = curRow - 1; i >= maxUp; i--) {
            result.add(matrix[i][curCol]);
            totalValueToVisit--;
            curRow = i;
        }
        maxUp++;
    }

    public void setInitialMaxValue(int m, int n) {
        maxLeft = 0;
        maxRight = n;
        maxDown = m;
        maxUp = 1;
    }

    public static void main(String[] args) {
        Question32 obj = new Question32();
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        obj.spiralOrder(matrix);
    }
}
