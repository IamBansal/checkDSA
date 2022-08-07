package leetcode_arays;

import java.util.ArrayList;

public class Question15 {

    /*
    Given an integer array nums, move all 0's to the end of it
    while maintaining the relative order of the non-zero elements.
     */

    public static void moveZeroes(int[] nums) {
        ArrayList<Integer> check = new ArrayList<>();

        for (Integer e : nums
        ) {
            check.add(e);
        }

        int count = 0;
        for (int i = 0; i < check.size(); i++) {
            if (check.get(i) == 0) {
                check.remove(check.get(i));
                i = i - 1;
                count++;
            }
        }
        int length = check.size();

        for (int i = 0; i < nums.length; i++) {
            if (check.size() != 0) {
                nums[i] = check.get(0);
                check.remove(check.get(0));
            }
        }
        for (int i = length; i < nums.length; i++) {
            nums[i] = 0;
        }

        for (Integer e : nums
        ) {
            System.out.print(e + " ");
        }
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        int[] nums1 = {0};
        moveZeroes(nums);
        moveZeroes(nums1);
    }
}
