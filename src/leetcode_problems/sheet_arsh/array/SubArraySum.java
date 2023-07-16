package leetcode_problems.sheet_arsh.array;

import java.util.HashMap;
import java.util.Map;

public class SubArraySum {

    /*
    974. SubArray Sums Divisible by K
    Given an integer array nums and an integer k, return the number of non-empty subArrays
    that have a sum divisible by k.
    A subArray is a contiguous part of an array.
     */

    //This solution gives TLE
    public static int subArraysDivByK(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i <= nums.length; i++) {
            for (int j = 0; j + i < nums.length; j++) {
                if (sumOfArray(nums, j, j + i) % k == 0) count++;
            }
        }
        return count;
    }

    private static int sumOfArray(int[] nums, int j, int i) {
        int sum = 0;
        for (int a = j; a <= i; a++) sum += nums[a];
        return sum;
    }

    //Kind of similar to subArraySumOfK problem - 560
    public static int subArraysDivByKBetter(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int count = 0, sum = 0;
        for (int a : nums) {
            sum = (sum + a) % k;
            if (sum < 0) sum += k;
            count += map.getOrDefault(sum, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 0, -2, -3, 1};
        System.out.println(subArraysDivByKBetter(nums, 5));
        int[] nums1 = {5};
        System.out.println(subArraysDivByKBetter(nums1, 9));
    }
}
