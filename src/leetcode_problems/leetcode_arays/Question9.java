package leetcode_problems.leetcode_arays;

import java.util.ArrayList;

public class Question9 {

    /*
    Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.

You must implement a solution with a linear runtime complexity and use only constant extra space.
     */

    public static int singleNumber(int[] nums) {
        ArrayList<Integer> check = new ArrayList<>();
        for (Integer e : nums) {
            if (!check.contains(e)) {
                check.add(e);
            } else {
                check.remove(e);
            }
        }
        return check.get(0);
    }

    public static void main(String[] args) {
        int[] nums = {4, 1, 2, 1, 2};
        System.out.println(singleNumber(nums));
    }
}
