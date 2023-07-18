package leetcode_problems.sheet_arsh.array;

public class LargestRectangle {

    /*
    84. Largest Rectangle in Histogram
    Given an array of integers heights representing the histogram's bar height
    where the width of each bar is 1, return the area of the largest rectangle in the histogram.
     */

    //This solution gives TLE
    public static int largestRectangleArea(int[] heights) {
        int maxArea = Integer.MIN_VALUE;
        for (int i = 0; i < heights.length; i++) {
            int min = heights[i];
            for (int j = i; j < heights.length; j++) {
                //Storing minimum height too till the jth height as per the condition.
                min = Math.min(min, Math.min(heights[i], heights[j]));
                maxArea = Math.max(maxArea, min * (Math.abs(i - j) + 1));
            }
        }
        return maxArea;
    }

//    public static int largestRectangleAreaBetter(int[] heights) {
//
//    }

    public static void main(String[] args) {
        int[] heights = {2, 1, 5, 6, 2, 3};
        int[] heights1 = {2, 4};
        System.out.println(largestRectangleArea(heights));
        System.out.println(largestRectangleArea(heights1));

    }
}
