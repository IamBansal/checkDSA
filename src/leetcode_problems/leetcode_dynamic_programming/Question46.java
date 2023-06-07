package leetcode_problems.leetcode_dynamic_programming;

import java.util.Arrays;

public class Question46 {

    /*
    673. Number of Longest Increasing Subsequence
    Given an integer array nums, return the number of longest increasing subsequences.
    Notice that the sequence has to be strictly increasing.
     */

    public static int findNumberOfLIS(int[] nums) {
        int[] arr = new int[nums.length];
        int[] count = new int[nums.length];
        Arrays.fill(arr, 1);
        Arrays.fill(count, 1);

        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i] && arr[i] < 1 + arr[j]) {
                    arr[i] = 1 + arr[j];
                    count[i] = count[j];
                }
                else if (nums[j] < nums[i] && arr[i] == 1 + arr[j]){
                    count[i] += count[j];
                }
            }
            max = Math.max(max, arr[i]);
        }

        int nos = 0;
        for(int i = 0; i < arr.length; i++){
            if (arr[i] == max) nos += count[i];
        }
        return nos;

    }

    public static void main(String[] args) {
        int[] nums = {1,3,5,4,7};
        int[] nums1 = {2,2,2,2,2};
        System.out.println(findNumberOfLIS(nums));
        System.out.println(findNumberOfLIS(nums1));
    }
}
