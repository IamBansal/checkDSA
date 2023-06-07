package leetcode_problems.leetcode_dynamic_programming;

import java.util.Arrays;

public class Question23 {

    /*
    494. Target Sum

    You are given an integer array nums and an integer target.
    You want to build an expression out of nums by adding one of the symbols
    '+' and '-' before each integer in nums and then concatenate all the integers.
    For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1
    and concatenate them to build the expression "+2-1".
    Return the number of different expressions that you can build, which evaluates to target.

     */

    //memoized solution
    public static int findTargetSumWays(int[] nums, int target) {
        int totalSum = 0;
        for (Integer e : nums) totalSum += e;

        if (totalSum + target < 0 || (totalSum + target) % 2 == 1) return 0;

        int sum = (totalSum + target) / 2;

        int[][] dp = new int[nums.length][sum + 1];
        for (int[] ints : dp) {
            Arrays.fill(ints, -1);
        }

        return helper(nums, nums.length - 1, sum, dp);
    }

    private static int helper(int[] nums, int index, int targetLeft, int[][] dp) {
        if (index == 0) {
            if (targetLeft == 0 && nums[0] == 0) return 2;
            if (targetLeft == 0 || nums[0] == targetLeft) return 1;
            return 0;
        }

        if (dp[index][targetLeft] != -1) return  dp[index][targetLeft];

        if (nums[index] > targetLeft) dp[index][targetLeft] = helper(nums, index - 1, targetLeft, dp);
        else dp[index][targetLeft] = helper(nums, index - 1, targetLeft - nums[index], dp) + helper(nums, index - 1, targetLeft, dp);

        return dp[index][targetLeft];
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1};
        int[] nums2 = {0, 0, 0, 0, 0, 0, 0, 0, 1};
        int[] nums3 = {1, 2, 3, 1};
        int[] nums4 = {7, 9, 3, 8, 0, 2, 4, 8, 3, 9};
        int[] nums5 = {-100};
        System.out.println(findTargetSumWays(nums, 3));
        System.out.println(findTargetSumWays(nums2, 1));
        System.out.println(findTargetSumWays(nums3, 3));
        System.out.println(findTargetSumWays(nums4, 0));
        System.out.println(findTargetSumWays(nums5, 100));
    }
}
