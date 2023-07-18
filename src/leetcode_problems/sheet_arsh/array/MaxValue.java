package leetcode_problems.sheet_arsh.array;

import java.util.Arrays;

public class MaxValue {

    /*
    1499. Max Value of Equation
    You are given an array points containing the coordinates of points on a 2D plane,
    sorted by the x-values, where points[i] = [xi, yi] such that xi < xj for all
    1 <= i < j <= points.length. You are also given an integer k.

    Return the maximum value of the equation yi + yj + |xi - xj| where |xi - xj| <= k and 1 <= i < j <= points.length.

    It is guaranteed that there exists at least one pair of points that satisfy the constraint |xi - xj| <= k.
     */

    //This solution gives TLE
    public static int findMaxValueOfEquation(int[][] points, int k) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                int condition = Math.abs(points[i][0] - points[j][0]);
                if (condition <= k) {
                    max = Math.max(max, points[i][1] + points[j][1] + condition);
                }
            }
        }
        return max;
    }

//    public static int findMaxValueOfEquationBetter(int[][] points, int k) {

//        boolean[] check = new boolean[points.length];
//        Arrays.fill(check, false);
//
//        for (int i = 0; i < check.length - 1; i++) {
//            if (Math.abs(points[i][0] - points[i + 1][0]) <= k) check[i] = true;
//        }
//
//        int max = Integer.MIN_VALUE;
//        for (int i = 0; i < points.length; i++) {
//            if (!check[i]) break;
//            for (int j = i + 1; j < points.length; j++) {
//                if (!check[j - 1]) break;
//                int condition = Math.abs(points[i][0] - points[j][0]);
//                if (condition <= k) {
//                    max = Math.max(max, points[i][1] + points[j][1] + condition);
//                }
//            }
//        }
//        return max;
//    }

    public static void main(String[] args) {
        int[][] points = {{1, 3}, {2, 0}, {5, 10}, {6, -10}};
        System.out.println(findMaxValueOfEquation(points, 1));
//        System.out.println(findMaxValueOfEquationBetter(points, 1));
        int[][] points1 = {{0, 0}, {3, 0}, {9, 2}};
        System.out.println(findMaxValueOfEquation(points1, 3));
//        System.out.println(findMaxValueOfEquationBetter(points1, 3));
    }
}
