package leetcode_problems.leetcode_dynamic_programming;

import java.util.Arrays;

public class Question42 {

    /*
    300. Longest Increasing Subsequence
    Given an integer array nums, return the length of the longest strictly increasing subsequence.
     */

    //Memoized solution
    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n + 1];
        for (int[] arr : dp) Arrays.fill(arr, -1);
        return helper(nums, 0, -1, dp);
    }

    private static int helper(int[] nums, int index, int prevIndex, int[][] dp) {

        if (index == nums.length) return 0;

        if (dp[index][prevIndex + 1] != -1) return dp[index][prevIndex + 1];

        int length = helper(nums, index + 1, prevIndex, dp);
        if (prevIndex == -1 || nums[index] > nums[prevIndex])
            length = Math.max(length, 1 + helper(nums, index + 1, index, dp));

        return dp[index][prevIndex + 1] = length;
    }

    //Tabulated solution
    public static int lengthOfLISTabulated(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n + 1][n + 1];

        for (int index = n - 1; index >= 0; index--) {
            for (int prevIndex = index - 1; prevIndex >= -1; prevIndex--) {
                int length = dp[index + 1][prevIndex + 1];
                if (prevIndex == -1 || nums[index] > nums[prevIndex])
                    length = Math.max(length, 1 + dp[index + 1][index + 1]);
                dp[index][prevIndex + 1] = length;
            }
        }
        return dp[0][0];
    }

    //Space Optimised solution
    public static int lengthOfLISSpaceOpt(int[] nums) {
        int n = nums.length;
        int[] ahead = new int[n + 1];
        int[] curr = new int[n + 1];

        for (int index = n - 1; index >= 0; index--) {
            for (int prevIndex = index - 1; prevIndex >= -1; prevIndex--) {
                int length = ahead[prevIndex + 1];
                if (prevIndex == -1 || nums[index] > nums[prevIndex])
                    length = Math.max(length, 1 + ahead[index + 1]);
                curr[prevIndex + 1] = length;
            }
            ahead = curr;
        }
        return ahead[0];
    }

    //Tabulated solution - method 2 (better in space and time)
    //It stores LIS till the given index in the array - so helpful in getting all LIS too
    public static int lengthOfLISTabulated2(int[] nums) {
        int[] arr = new int[nums.length];
        Arrays.fill(arr, 1);

        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) arr[i] = Math.max(arr[i], 1 + arr[j]);
            }
            max = Math.max(max, arr[i]);
        }
        return max;
    }

    //Print LIS
    public static void printLIS(int[] nums) {
        int[] arr = new int[nums.length];
        Arrays.fill(arr, 1);

        //using a hash array to store the previous index which is in list.
        int[] hash = new int[nums.length];

        int max = 1;
        int lastIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            hash[i] = i;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i] && 1 + arr[j] > arr[i]) {
                    arr[i] = 1 + arr[j];
                    hash[i] = j;
                }
            }
            if (arr[i] > max) {
                max = arr[i];
                lastIndex = i;
            }
        }

        int[] list = new int[max];
        list[list.length - 1] = nums[lastIndex];
        int ind = list.length - 2;
        while (hash[lastIndex] != lastIndex) {
            lastIndex = hash[lastIndex];
            list[ind--] = nums[lastIndex];
        }

        for (Integer e : list) System.out.print(e + " ");
        System.out.println();

    }

    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        int[] nums2 = {0, 1, 0, 3, 2, 3};
        int[] nums3 = {7, 7, 7, 7, 7};

        System.out.println(lengthOfLIS(nums));
        System.out.println(lengthOfLIS(nums2));
        System.out.println(lengthOfLIS(nums3));
        System.out.println();
        System.out.println(lengthOfLISTabulated(nums));
        System.out.println(lengthOfLISTabulated(nums2));
        System.out.println(lengthOfLISTabulated(nums3));
        System.out.println();
        System.out.println(lengthOfLISSpaceOpt(nums));
        System.out.println(lengthOfLISSpaceOpt(nums2));
        System.out.println(lengthOfLISSpaceOpt(nums3));
        System.out.println();
        System.out.println(lengthOfLISTabulated2(nums));
        System.out.println(lengthOfLISTabulated2(nums2));
        System.out.println(lengthOfLISTabulated2(nums3));
        System.out.println();
        printLIS(nums);
        printLIS(nums2);
        printLIS(nums3);

    }
}
