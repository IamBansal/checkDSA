package leetcode_problems.leetcode_arays;

import java.util.Arrays;

public class Question14 {

    /*
    Given an array nums containing n distinct numbers in the range [0, n],
    return the only number in the range that is missing from the array.
     */

    public static int missingNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                return i;
            }
        }
        return nums.length;
    }

    public static void main(String[] args) {
        int[] nums = {9, 6, 4, 2, 3, 5, 7, 0, 1};
        int[] nums1 = {3, 0, 1};
        int[] nums2 = {0, 1};
        System.out.println(missingNumber(nums));
        System.out.println(missingNumber(nums1));
        System.out.println(missingNumber(nums2));
    }
}
