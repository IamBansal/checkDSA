package leetcode_problems.leetcode_arays;

import java.util.ArrayList;
import java.util.Arrays;

public class Question19 {

    /*
Given an array nums of n integers where nums[i] is in the range [1, n],
return an array of all the integers in the range [1, n] that do not appear in nums.

      */

    public static ArrayList<Integer> findDisappearedNumbers(int[] nums) {
        ArrayList<Integer> result = new ArrayList<>();
        ArrayList<Integer> check = new ArrayList<>();

        Arrays.sort(nums);
        for (Integer e : nums){
            check.add(e);
        }
        for (int i = 0; i <= nums.length; i++){
            if (!check.contains(i)){
                result.add(i);
            }
        }
        result.remove(0);
//        for (Integer e : result){
//            System.out.println(e +" ");
//        }
        return result;
    }

    public static ArrayList<Integer> findDisappearedNumbersBetter(int[] nums){
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0) {
                nums[index] = nums[index] * -1;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                result.add(i + 1);
            } else {
                nums[i] *= -1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        int[] nums1 = {1, 1};
        findDisappearedNumbers(nums);
        findDisappearedNumbers(nums1);;
        findDisappearedNumbersBetter(nums);
        findDisappearedNumbersBetter(nums1);
    }

}