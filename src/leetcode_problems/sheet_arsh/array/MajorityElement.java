package leetcode_problems.sheet_arsh.array;

import java.util.Arrays;

public class MajorityElement {

    /*
    169. Majority Element
    Given an array nums of size n, return the majority element.
    The majority element is the element that appears more than ⌊n / 2⌋ times.
    You may assume that the majority element always exists in the array.
     */

    public static int majorityElement(int[] nums) {
        Arrays.sort(nums);

        int count = 0, prev = nums[0];
        for (int num : nums) {
            if (num == prev) count++;
            else count = 1;
            prev = num;
            if (count > nums.length / 2) return num;
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        System.out.println(majorityElement(nums));
    }
}
