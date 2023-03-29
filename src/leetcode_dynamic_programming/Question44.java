package leetcode_dynamic_programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Question44 {

    /*
    368. Largest Divisible Subset
    Given a set of distinct positive integers nums, return the largest subset answer such that every pair
    (answer[i], answer[j]) of elements in this subset satisfies:
    - answer[i] % answer[j] == 0, or
    - answer[j] % answer[i] == 0

    If there are multiple solutions, return any of them.
     */

    public static List<Integer> largestDivisibleSubset(int[] nums) {

        Arrays.sort(nums);
        int[] arr = new int[nums.length];
        Arrays.fill(arr, 1);

        //using a hash array to store the previous index which is in list.
        int[] hash = new int[nums.length];

        int max = 1;
        int lastIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            hash[i] = i;
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && 1 + arr[j] > arr[i]) {
                    arr[i] = 1 + arr[j];
                    hash[i] = j;
                }
            }
            if (arr[i] > max) {
                max = arr[i];
                lastIndex = i;
            }
        }

        List<Integer> list = new ArrayList<>();
        list.add(nums[lastIndex]);
        while (hash[lastIndex] != lastIndex) {
            lastIndex = hash[lastIndex];
            list.add(nums[lastIndex]);
        }
        return list;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int[] nums2 = {1, 2, 4, 8};
        System.out.println(largestDivisibleSubset(nums));
        System.out.println(largestDivisibleSubset(nums2));
    }
}
