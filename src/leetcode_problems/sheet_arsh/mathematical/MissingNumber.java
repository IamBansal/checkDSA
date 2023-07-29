package leetcode_problems.sheet_arsh.mathematical;

import java.util.Arrays;

public class MissingNumber {

    /*
    268. Missing Number
    Given an array nums containing n distinct numbers in the range [0, n],
    return the only number in the range that is missing from the array.
     */

    public static int missingNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) return i;
        }
        return nums.length;
    }

    public static int missingNumberBetter(int[] nums) {
        int sum = nums.length * (nums.length + 1) / 2;
        for (int x : nums) sum -= x;
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {3, 0, 1};
        System.out.println(missingNumber(nums));
        int[] nums1 = {0, 1};
        System.out.println(missingNumber(nums1));
        int[] nums2 = {9, 6, 4, 2, 3, 5, 7, 0, 1};
        System.out.println(missingNumber(nums2));
    }
}
