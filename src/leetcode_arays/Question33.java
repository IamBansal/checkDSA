package leetcode_arays;

public class Question33 {

    /*
    Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.
     */

    int maxLeft, maxRight, maxDown, maxUp, totalValueToVisit, curRow = 0, curCol = -1, number = 1;

    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];

        totalValueToVisit = n * n;

        setInitialMaxValue(n, n);

        while (totalValueToVisit > 0) {
            goRight(result);
            goDown(result);
            goLeft(result);
            goUp(result);
        }

        for (int[] arr : result
        ) {
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }

        return result;
    }

    public void goRight(int[][] matrix) {
        if (totalValueToVisit == 0)
            return;
        for (int i = curCol + 1; i < maxRight; i++) {
            matrix[curRow][i] = number;
            number++;
            totalValueToVisit--;
            curCol = i;
        }
        maxRight--;
    }

    public void goDown(int[][] matrix) {
        if (totalValueToVisit == 0)
            return;
        for (int i = curRow + 1; i < maxDown; i++) {
            matrix[i][curCol] = number;
            number++;
            totalValueToVisit--;
            curRow = i;
        }
        maxDown--;
    }

    public void goLeft(int[][] matrix) {
        if (totalValueToVisit == 0)
            return;
        for (int i = curCol - 1; i >= maxLeft; i--) {
            matrix[curRow][i] = number;
            number++;
            totalValueToVisit--;
            curCol = i;
        }
        maxLeft++;
    }

    public void goUp(int[][] matrix) {
        if (totalValueToVisit == 0)
            return;
        for (int i = curRow - 1; i >= maxUp; i--) {
            matrix[i][curCol] = number;
            number++;
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
        Question33 obj = new Question33();
        obj.generateMatrix(3);
    }
}
