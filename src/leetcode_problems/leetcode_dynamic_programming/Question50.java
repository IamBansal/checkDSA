package leetcode_problems.leetcode_dynamic_programming;

import java.util.Arrays;

public class Question50 {

    /*
    1043. Partition Array for Maximum Sum
    Given an integer array arr, partition the array into (contiguous) subarrays of length at most k.
    After partitioning, each subarray has their values changed to become the maximum value of that subarray.
    Return the largest sum of the given array after partitioning.
    Test cases are generated so that the answer fits in a 32-bit integer.

     */

    //Memoized solution
    public static int maxSumAfterPartitioning(int[] arr, int k) {
        int[] dp = new int[arr.length];
        Arrays.fill(dp, -1);
        return helper(arr, 0, k, dp);
    }

    private static int helper(int[] arr, int i, int k, int[] dp) {
        if (i == arr.length) return 0;

        if (dp[i] != -1) return dp[i];

        int length = 0, max = Integer.MIN_VALUE, maxAns = Integer.MIN_VALUE;
        for (int j = i; j < Math.min(i + k, arr.length); j++) {
            length++;
            max = Math.max(max, arr[j]);
            int sum = length * max + helper(arr, j + 1, k, dp);
            maxAns = Math.max(maxAns, sum);
        }
        return dp[i] = maxAns;
    }

    //Tabulated solution
    public static int maxSumAfterPartTab(int[] arr, int k) {
        int[] dp = new int[arr.length + 1];
        dp[arr.length] = 0;

        for (int i = arr.length - 1; i >= 0; i--) {
            int length = 0, max = Integer.MIN_VALUE, maxAns = Integer.MIN_VALUE;
            for (int j = i; j < Math.min(i + k, arr.length); j++) {
                length++;
                max = Math.max(max, arr[j]);
                int sum = length * max + dp[j + 1];
                maxAns = Math.max(maxAns, sum);
            }
            dp[i] = maxAns;
        }
        return dp[0];
    }

    public static void main(String[] args) {
        int[] arr = {1, 15, 7, 9, 2, 5, 10};
        int[] arr1 = {1, 4, 1, 5, 7, 3, 6, 1, 9, 9, 3};
        int[] arr2 = {1};
        System.out.println(maxSumAfterPartitioning(arr, 3));
        System.out.println(maxSumAfterPartitioning(arr1, 4));
        System.out.println(maxSumAfterPartitioning(arr2, 1));
        System.out.println();
        System.out.println(maxSumAfterPartTab(arr, 3));
        System.out.println(maxSumAfterPartTab(arr1, 4));
        System.out.println(maxSumAfterPartTab(arr2, 1));
    }
}
