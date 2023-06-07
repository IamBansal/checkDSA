package leetcode_problems.leetcode_dynamic_programming;

public class Question20 {

    //TODO - Incomplete

    /*
    1981. Minimize the Difference Between Target and Chosen Elements

    You are given an m x n integer matrix mat and an integer target.
    Choose one integer from each row in the matrix such that
    the absolute difference between target and the sum of the chosen elements is minimized.
    Return the minimum absolute difference.
    The absolute difference between two numbers a and b is the absolute value of a - b.

     */

    public static int minimizeTheDifference(int[][] mat, int target) {
        if (mat.length == 1 && mat[0].length == 1) return Math.abs(target - mat[0][0]);

        return helper(mat, 0, target, (int) 1e7);
    }

    private static int helper(int[][] mat, int i, int target, int min) {

        if (i == mat.length) return target;

        for (int a = 0; a < mat[0].length; a++) {
            min = Math.min(min, helper(mat, i + 1, Math.abs(target - mat[i][a]), min));
        }
        return min;
    }

    public static void main(String[] args) {

        int[][] nums = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] nums2 = {{1}, {2}, {3}};
        int[][] nums3 = {{1, 2, 9, 8, 7}};
        int[][] nums4 = {{10, 3, 7, 7, 9, 6, 9, 8, 9, 5}, {1, 1, 6, 8, 6, 7, 7, 9, 3, 9}, {3, 4, 4, 1, 3, 6, 3, 3, 9, 9}, {6, 9, 9, 3, 8, 7, 9, 6, 10, 6}};
        System.out.println(minimizeTheDifference(nums, 13));
        System.out.println(minimizeTheDifference(nums2, 100));
        System.out.println(minimizeTheDifference(nums3, 6));
        System.out.println(minimizeTheDifference(nums4, 5)); // 3 Answer

    }

}
