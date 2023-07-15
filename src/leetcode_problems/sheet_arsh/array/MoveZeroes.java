package leetcode_problems.sheet_arsh.array;

import java.util.ArrayList;

public class MoveZeroes {

    /*
    283. Move Zeroes
    Given an integer array nums, move all 0's to the end of it while maintaining the
    relative order of the non-zero elements.
    Note that you must do this in-place without making a copy of the array.
     */

    //This solution took only 1ms time.
    public static void moveZeroesBetter(int[] nums) {
        int ptr = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[ptr] = nums[i];
                ptr++;
            }
        }
        for (int i = ptr; i < nums.length; i++) nums[i] = 0;
        for (int e : nums) System.out.print(e + " ");
    }

    //This solution takes a little more time.
    public static void moveZeroes(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int num : nums) if (num != 0) list.add(num);

        for (int i = 0; i < nums.length; i++){
            if (i < list.size()) nums[i] = list.get(i);
            else nums[i] = 0;
        }
        for (int e : nums) System.out.print(e + " ");
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        moveZeroes(nums);
        moveZeroesBetter(nums);
    }
}
