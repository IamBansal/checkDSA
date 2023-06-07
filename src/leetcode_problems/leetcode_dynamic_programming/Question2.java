package leetcode_problems.leetcode_dynamic_programming;

import java.util.ArrayList;
import java.util.List;

public class Question2 {

    /*
    118. Pascal's Triangle
    Given an integer numRows, return the first numRows of Pascal's triangle.
    In Pascal's triangle, each number is the sum of the two numbers directly above it.

     */

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();

        List<Integer> list = new ArrayList<>();
        list.add(1);
        result.add(list);

        for (int i = 2; i <= numRows; i++) {
            List<Integer> list3 = new ArrayList<>();
            list3.add(1);
            for (int j = 2; j <= i; j++) {
                if (j == i) {
                    list3.add(1);
                } else {
                    List<Integer> previousList = result.get(result.size() - 1);
                    list3.add(previousList.get(j - 1) + previousList.get(j - 2));
                }
            }
            result.add(list3);
        }
        return result;
    }

    public static List<Integer> getRow(int rowIndex) {
        if (rowIndex == 0) {
            List<Integer> result = new ArrayList<>();
            result.add(1);
            return result;
        }

        int[][] pascal = new int[rowIndex + 1][];
        for (int i = 0; i < rowIndex + 1; i++) {
            int[] row = new int[i + 1];
            for (int j = 0; j <= i; j++) {
                row[j] = (j == 0) || (j == i) ? 1 : pascal[i - 1][j] + pascal[i - 1][j - 1];
            }
            pascal[i] = row;
        }
        List<Integer> result = new ArrayList<>();
        for (Integer e : pascal[rowIndex]) {
            result.add(e);
        }

        return result;

    }

    public static void main(String[] args) {

        List<List<Integer>> result = generate(5);
        for (List<Integer> row : result) {
            for (Integer num : row) {
                System.out.print(num + ",");
            }
            System.out.println();
        }
        System.out.println();

        List<Integer> resultRow = getRow(1);
        for (Integer num : resultRow) {
            System.out.print(num + ",");
        }
        System.out.println();

    }
}
