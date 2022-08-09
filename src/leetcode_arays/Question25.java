package leetcode_arays;

import java.util.HashSet;

public class Question25 {

    /*
    Given an array of integers nums sorted in non-decreasing order,
    find the starting and ending position of a given target value.

   If target is not found in the array, return [-1, -1].

    You must write an algorithm with O(log n) runtime complexity.
     */

    public static void searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = -1;
        result[1] = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                result[0] = i;
                break;
            }
        }

        if (result[0] != -1) {
            for (int i = result[0] + 1; i < nums.length; i++) {
                if (nums[i] != target && nums[i - 1] == target) {
                    result[1] = i - 1;
                }
                if (i == nums.length - 1 && nums[i] == target) {
                    result[1] = i;
                }
            }
            if (result[1] == -1) {
                result[1] = result[0];
            }
        }

        for (Integer e : result) {
            System.out.print(e + ", ");
        }
        System.out.println();

    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        searchRange(nums, 1);
        int[] nums1 = {5, 7, 7, 8, 8, 10};
        searchRange(nums1, 8);
        searchRange(nums1, 6);

        HashSet<String> set = new HashSet<>();


    }

}
