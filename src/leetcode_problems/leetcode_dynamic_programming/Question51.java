package leetcode_problems.leetcode_dynamic_programming;

public class Question51 {

    /*
    85. Maximal Rectangle
    Given a rows x cols binary matrix filled with 0's and 1's,
     find the largest rectangle containing only 1's and return its area.
     */

    public static int maximalRectangle(String[][] matrix) {
        int maxArea = 0;
        int[] height = new int[matrix[0].length];
        for (String[] strings : matrix) {
            for (int j = 0; j < height.length; j++) {
                if (strings[j].equals("1")) height[j]++;
                else height[j] = 0;
            }
            int area = largestArea(height);
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }

    static int largestArea(int[] arr) {
        int maxArea = 0;
        for (int i = 0; i < arr.length; i++) {
            int minHeight = Integer.MAX_VALUE;
            for (int j = i; j < arr.length; j++) {
                minHeight = Math.min(minHeight, arr[j]);
                maxArea = Math.max(maxArea, minHeight * (j - i + 1));
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        String[][] matrix = {{"1", "0", "1", "0", "0"}, {"1", "0", "1", "1", "1"}, {"1", "1", "1", "1", "1"}, {"1", "0", "0", "1", "0"}};
        String[][] matrix1 = {{"0"}};
        String[][] matrix2 = {{"1"}};
        System.out.println(maximalRectangle(matrix));
        System.out.println(maximalRectangle(matrix1));
        System.out.println(maximalRectangle(matrix2));
    }
}
