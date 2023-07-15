package leetcode_problems.sheet_arsh.array;

import java.util.ArrayList;

public class RemoveDuplicate {

    /*
    26. Remove Duplicates from Sorted Array
    Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once.
    The relative order of the elements should be kept the same. Then return the number of unique elements in nums.
    Consider the number of unique elements of nums to be k, to get accepted, you need to do the following things:
    - Change the array nums such that the first k elements of nums contain the unique elements in the order they were present in nums initially.
      The remaining elements of nums are not important as well as the size of nums.
    - Return k.
     */

    public static int removeDuplicates(int[] nums) {
        int ptr = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[ptr] != nums[i]) {
                ptr++;
                nums[ptr] = nums[i];
            }
        }
        return ptr + 1;
    }

    public static void main(String[] args) {
        int[] arr = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(removeDuplicates(arr));
    }
}
