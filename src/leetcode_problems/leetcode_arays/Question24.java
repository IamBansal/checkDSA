package leetcode_problems.leetcode_arays;

import java.util.ArrayList;
import java.util.Arrays;

public class Question24 {

    /*
    There is an integer array nums sorted in ascending order (with distinct values).

Prior to being passed to your function, nums is possibly rotated at an unknown pivot index
k (1 <= k < nums.length) such that the resulting array is
[nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed).
For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].

Given the array nums after the possible rotation and an integer target,
return the index of target if it is in nums, or -1 if it is not in nums.

You must write an algorithm with O(log n) runtime complexity.
     */

    public static int search(int[] nums, int target) {

        ArrayList<Integer> check = new ArrayList<>();
        int[] numsCheck = new int[nums.length];
        System.arraycopy(nums, 0, numsCheck, 0, nums.length);
        for (Integer e : nums) {
            check.add(e);
        }

        if (check.contains(target)) {
            int kVal = nums[0];
            Arrays.sort(numsCheck);

            int k = 0;

            for (int i = 0; i < numsCheck.length; i++) {
                if (numsCheck[i] == kVal) {
                    k = i;
                    break;
                }
            }

            if (target >= kVal) {
                for (int i = 0; i < nums.length - k; i++) {
                    if (nums[i] == target) {
                        return i;
                    }
                }
            } else {
                for (int i = nums.length - k; i < nums.length; i++) {
                    if (nums[i] == target) {
                        return i;
                    }
                }
            }
        } else {
            return -1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(search(nums, 0));
        System.out.println(search(nums, 3));
        int[] nums2 = {1};
        System.out.println(search(nums2, 0));
    }

}
