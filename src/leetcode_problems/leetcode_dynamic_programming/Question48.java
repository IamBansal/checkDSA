package leetcode_problems.leetcode_dynamic_programming;

import java.util.Arrays;

public class Question48 {

    /*
    312. Burst Balloons
    You are given n balloons, indexed from 0 to n - 1.
    Each balloon is painted with a number on it represented by an array nums.
    You are asked to burst all the balloons.
    If you burst the ith balloon, you will get nums[i - 1] * nums[i] * nums[i + 1] coins.
    If i - 1 or i + 1 goes out of bounds of the array, then treat it as if there is a balloon with a 1 painted on it.
    Return the maximum coins you can collect by bursting the balloons wisely.
     */

    //memoized solution
    public static int maxCoins(int[] nums) {
        int n = nums.length;
        int[] numsArray = new int[n + 2];
        System.arraycopy(nums, 0, numsArray, 1, n);
        numsArray[0] = numsArray[n + 1] = 1;

        int[][] dp = new int[n + 3][n + 3];
        for (int[] arr : dp) Arrays.fill(arr, -1);

        return helper(numsArray, 1, n, dp);
    }

    private static int helper(int[] numsArray, int i, int j, int[][] dp) {
        if (i > j) return 0;

        if (dp[i][j] != -1) return dp[i][j];

        int max = 0;
        for (int index = i; index <= j; index++) {
            int coins = numsArray[i - 1] * numsArray[index] * numsArray[j + 1] +
                    helper(numsArray, i, index - 1, dp) + helper(numsArray, index + 1, j, dp);
            max = Math.max(max, coins);
        }
        return dp[i][j] = max;
    }


    //Tabulated solution
    public static int maxCoinsTabulated(int[] nums) {
        int n = nums.length;
        int[] numsArray = new int[n + 2];
        System.arraycopy(nums, 0, numsArray, 1, n);
        numsArray[0] = numsArray[n + 1] = 1;

        int[][] dp = new int[n + 4][n + 4];

        for (int i = n; i > 0; i--) {
            for (int j = 1; j <= n; j++) {
                if (i > j) continue;
                int min = 0;
                for (int index = i; index <= j; index++) {
                    int cost = numsArray[j + 1] * numsArray[index] * numsArray[i - 1] + dp[i][index - 1] + dp[index + 1][j];
                    min = Math.max(min, cost);
                }
                dp[i][j] = min;
            }
        }

        return dp[1][n];

    }

    public static void main(String[] args) {
        int[] coins = {3, 1, 5, 8};
        int[] coins1 = {1, 5};
        System.out.println(maxCoins(coins));
        System.out.println(maxCoins(coins1));
        System.out.println();
        System.out.println(maxCoinsTabulated(coins));
        System.out.println(maxCoinsTabulated(coins1));


    }
}
