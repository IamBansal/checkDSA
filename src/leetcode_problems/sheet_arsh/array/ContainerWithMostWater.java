package leetcode_problems.sheet_arsh.array;

public class ContainerWithMostWater {

    /*
    11. Container With Most Water
    You are given an integer array height of length n.
    There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
    Find two lines that together with the x-axis form a container, such that the container contains the most water.
    Return the maximum amount of water a container can store.

    Notice that you may not slant the container.
     */

    //This is a better solution
    public static int maxAreaBetter(int[] height) {
        int max = 0, left = 0, right = height.length - 1;
        while (left < right) {
            int minHeight = Math.min(height[left], height[right]);
            max = Math.max(max, minHeight * (right - left));
            if (height[left] < height[right]) left++;
            else right--;
        }
        return max;
    }

    //This solution gives TLE
    public static int maxArea(int[] height) {
        int maxArea = Integer.MIN_VALUE;
        for (int i = 1; i < height.length; i++) {
            for (int j = 0; j + i < height.length; j++) {
                int minHeight = Math.min(height[i + j], height[j]);
                maxArea = Math.max(maxArea, minHeight * Math.abs(i));
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(height));
        System.out.println(maxAreaBetter(height));
        int[] height1 = {1, 1};
        System.out.println(maxArea(height1));
        System.out.println(maxAreaBetter(height1));
    }
}
