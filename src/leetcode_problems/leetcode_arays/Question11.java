package leetcode_problems.leetcode_arays;

import java.util.ArrayList;
import java.util.Arrays;

public class Question11 {

    /*
    Given an integer array nums,
    return true if any value appears at least twice in the array,
    and return false if every element is distinct.
     */

    public static boolean containsDuplicate(int[] nums) {
        ArrayList<Integer> check = new ArrayList<>();
        for (Integer e : nums) {
            if (!check.contains(e)) {
                check.add(e);
            } else {
                return true;
            }
        }
        return false;
    }

    public static boolean containsDuplicateBetter(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1])
                count++;
        }
        return count > 0;

    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        int[] nums1 = {1, 2, 3};
        System.out.println(containsDuplicateBetter(nums));
        System.out.println(containsDuplicateBetter(nums1));
    }

}
