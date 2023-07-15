package leetcode_problems.sheet_arsh.array;

import java.util.ArrayList;
import java.util.Arrays;

public class DuplicateNumber {

    /*
    287. Find the Duplicate Number
    Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
    There is only one repeated number in nums, return this repeated number.
    You must solve the problem without modifying the array nums and uses only constant extra space.
     */

    //This solution will give TLE for large inputs.
    public static int findDuplicate(int[] nums) {
        ArrayList<Integer> check = new ArrayList<>();
        for (Integer e : nums) {
            if (check.contains(e)) return e;
            else check.add(e);
        }
        return 0;
    }

    //Better solution
    public static int findDuplicateBetter(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int first = nums[i];
            int second = nums[i + 1];
            if (first == second) return first;
        }
        return 0;
    }

    //Best solution
    public static int findDuplicateBest(int[] nums) {
        boolean[] arr = new boolean[nums.length];
        for (int num : nums) {
            if (arr[num]) return num;
            else arr[num] = true;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 4, 2, 2};
        System.out.println(findDuplicateBetter(nums));
        int[] nums1 = {3, 1, 3, 4, 2};
        System.out.println(findDuplicateBetter(nums1));
    }

}
