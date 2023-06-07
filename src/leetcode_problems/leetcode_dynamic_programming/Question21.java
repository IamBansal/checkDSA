package leetcode_problems.leetcode_dynamic_programming;

import java.util.Arrays;

public class Question21 {

    /*
    198. House Robber
    You are a professional robber planning to rob houses along a street.
    Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is
    that adjacent houses have security systems connected,
    and it will automatically contact the police if two adjacent houses were broken into on the same night.
    Given an integer array nums representing the amount of money of each house,
    return the maximum amount of money you can rob tonight without alerting the police.

     */

    //memoized solution
    public static int rob(int[] nums) {
        if (nums.length == 1) return nums[0];

        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);

        return helper(nums, 0, dp);
    }

    private static int helper(int[] nums, int startIndex, int[] dp) {

        if (startIndex == nums.length - 1) return nums[startIndex];
        if (startIndex > nums.length - 1) return 0;

        if (dp[startIndex] != -1) return dp[startIndex];

        int take = nums[startIndex] + helper(nums, startIndex + 2, dp);
        int notTake = helper(nums, startIndex + 1, dp);

        return dp[startIndex] = Math.max(take, notTake);

    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        int[] nums2 = {2, 7, 9, 3, 1};
        int[] nums3 = {114, 117, 207, 117, 235, 82, 90, 67, 143, 146, 53, 108, 200, 91, 80, 223, 58, 170, 110, 236, 81, 90, 222, 160, 165, 195, 187, 199, 114, 235, 197, 187, 69, 129, 64, 214, 228, 78, 188, 67, 205, 94, 205, 169, 241, 202, 144, 240};
        System.out.println(rob(nums));
        System.out.println(rob(nums2));
        System.out.println(rob(nums3));
    }
}
