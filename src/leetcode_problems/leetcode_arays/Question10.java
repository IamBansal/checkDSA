package leetcode_problems.leetcode_arays;

import java.util.*;

public class Question10 {
    /*
    Given an array nums of size n, return the majority element.

  The majority element is the element that appears more than ⌊n / 2⌋ times.
   You may assume that the majority element always exists in the array.
     */

    public static int majorityElement(int[] nums) {
        ArrayList<Integer> check = new ArrayList<>();
        for (int num : nums) {
            if (!check.contains(num)) {
                check.add(num);
                int count = 0;
                for (int i : nums) {
                    if (i == num) {
                        count++;
                    }
                }
                if (count >= (nums.length / 2) + 1) {
                    return num;
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        int[] nums1 = {1, 2, 3};
        System.out.println(majorityElement(nums));
    }

}
