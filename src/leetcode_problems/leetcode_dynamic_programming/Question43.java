package leetcode_problems.leetcode_dynamic_programming;

import java.util.Arrays;

public class Question43 {

    //TODO - SOLUTION REQUIRES MORE TOPICS TO BE STUDIED - only dp is not sufficient

    /*
    2407. Longest Increasing Subsequence II
    You are given an integer array nums and an integer k.
    Find the longest subsequence of nums that meets the following requirements:
    - The subsequence is strictly increasing and
    - The difference between adjacent elements in the subsequence is at most k.

    Return the length of the longest subsequence that meets the requirements.
     */

    //This solution gives TLE due to big size of nums array in some test cases.
    public static int lengthOfLIS(int[] nums, int k) {
        int[] arr = new int[nums.length];
        Arrays.fill(arr, 1);

        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && nums[i] - nums[j] <= k) arr[i] = Math.max(arr[i], 1 + arr[j]);
            }
            max = Math.max(max, arr[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {4, 2, 1, 4, 3, 4, 5, 8, 15};
        int[] nums2 = {7, 4, 5, 1, 8, 12, 4, 7};
        int[] nums3 = {1, 5};

        System.out.println(lengthOfLIS(nums, 3));
        System.out.println(lengthOfLIS(nums2, 5));
        System.out.println(lengthOfLIS(nums3, 1));
        System.out.println();
    }
}
