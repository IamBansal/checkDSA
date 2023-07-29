package leetcode_problems.sheet_arsh.mathematical;

import java.util.Arrays;

public class MaxProductOfThreeNum {

    /*
    628. Maximum Product of Three Numbers
    Given an integer array nums, find three numbers whose product is maximum and
    return the maximum product.
     */

    public static int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int lastIndex = nums.length - 1;
        int ifNegative = nums[0] * nums[1];
        int notNegative = nums[lastIndex - 1] * nums[lastIndex - 2];
        return Math.max(ifNegative, notNegative) * nums[lastIndex];
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(maximumProduct(nums));
        int[] nums1 = {1, 2, 3, 4};
        System.out.println(maximumProduct(nums1));
        int[] nums2 = {-1, -2, -3};
        System.out.println(maximumProduct(nums2));
        int[] nums3 = {-100,-98,-1,2,3,4};
        System.out.println(maximumProduct(nums3));
    }
}
