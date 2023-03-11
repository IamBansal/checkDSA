package leetcode_dynamic_programming;

import java.util.Arrays;

public class Question22 {

    /*
    213. House Robber II

        You are a professional robber planning to rob houses along a street.
        Each house has a certain amount of money stashed.
        All houses at this place are arranged in a circle.
        That means the first house is the neighbor of the last one.
        Meanwhile, adjacent houses have a security system connected,
        and it will automatically contact the police if two adjacent houses were broken into on the same night.

        Given an integer array nums representing the amount of money of each house.
        Return the maximum amount of money you can rob tonight without alerting the police.
     */

    //Memoized solution
    public static int rob(int[] nums) {
        if (nums.length == 1) return nums[0];

        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);

        int[] dp2 = new int[nums.length];
        Arrays.fill(dp2, -1);

        return Math.max(helper(nums, 0, nums.length - 2, dp), helper(nums, 1, nums.length - 1, dp2));
    }

    private static int helper(int[] nums, int startIndex, int endIndex, int[] dp) {

        if (startIndex == endIndex) return nums[startIndex];
        if (startIndex > endIndex) return 0;

        if (dp[startIndex] != -1) return dp[startIndex];

        int take = nums[startIndex] + helper(nums, startIndex + 2, endIndex, dp);
        int notTake = helper(nums, startIndex + 1, endIndex, dp);

        return dp[startIndex] = Math.max(take, notTake);

    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        int[] nums2 = {1, 2, 3};
        int[] nums3 = {2, 3, 2};
        int[] nums4 = {1, 2, 1, 1};
        System.out.println(rob(nums));
        System.out.println(rob(nums2));
        System.out.println(rob(nums3));
        System.out.println(rob(nums4));
    }
}
