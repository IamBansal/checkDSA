package leetcode_problems.sheet_arsh.array;

import java.util.Arrays;

public class SortColors {

    /*
    75. Sort Colors
    Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent,
    with the colors in the order red, white, and blue.
    We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
    You must solve this problem without using the library's sort function.
     */

    public static void sortColors(int[] input) {
        for (int i = 0; i < input.length; i++) {
            int j = i - 1;
            int temp = input[i];
            while (j >= 0 && input[j] > temp) {
                input[j + 1] = input[j];
                j--;
            }
            input[j + 1] = temp;
        }
        for (int j : input) {
            System.out.print(j + " ");
        }

    }

    public static void main(String[] args) {
        int[] input = {2,0,2,1,1,0};
        sortColors(input);
    }
}
