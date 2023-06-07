package leetcode_problems.leetcode_dynamic_programming;

public class Question19 {

    /*
    416. Partition Equal Subset Sum

    Given an integer array nums, return true if you can partition the array into two subsets
    such that the sum of the elements in both subsets is equal or false otherwise.
     */

    public static boolean canPartition(int[] nums) {

        int n = nums.length;
        if (n == 1) return false;

        int sum = 0;
        for (Integer e : nums) sum += e;

        if (sum % 2 != 0) return false;

        int targetSum = sum / 2;
        int[][] dp = new int[n][targetSum + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= targetSum; j++) {
                dp[i][j] = -1;
            }
        }

        return helperCheck(nums, n - 1, targetSum, dp) == 1;
    }

    private static boolean helper(int[] nums, int index, int targetSum) {
        if (index == 0) return nums[0] == targetSum;
        if (targetSum == 0) return true;
        return helper(nums, index - 1, targetSum) || helper(nums, index - 1, targetSum - nums[index]);
    }


    private static int helperCheck(int[] nums, int index, int targetSum, int[][] dp) {
        if (index == 0) {
            if (nums[0] == targetSum) dp[index][targetSum] = 1;
            else dp[index][targetSum] = 0;
            return dp[index][targetSum];
        }

        if (targetSum <= 0) {
            dp[index][targetSum] = 1;
            return dp[index][targetSum];
        }

        if (dp[index][targetSum] != -1) return dp[index][targetSum];

        if (nums[index] > targetSum) {
            if (helperCheck(nums, index - 1, targetSum, dp) == 1) dp[index][targetSum] = 1;
            else dp[index][targetSum] = 0;
        } else {
            if (helperCheck(nums, index - 1, targetSum, dp) == 1 || helperCheck(nums, index - 1, targetSum - nums[index], dp) == 1)
                dp[index][targetSum] = 1;
            else dp[index][targetSum] = 0;
        }

        return dp[index][targetSum];

    }

    public static void main(String[] args) {

        int[] nums = {1, 5, 11, 5};
        int[] nums2 = {1, 2, 5};

        System.out.println(canPartition(nums));
        System.out.println(canPartition(nums2));

    }

}
