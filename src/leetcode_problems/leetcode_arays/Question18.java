package leetcode_problems.leetcode_arays;

import java.util.ArrayList;
import java.util.Arrays;

public class Question18 {

    /*
    Given an integer array nums, return the third maximum number in this array.
    If the third maximum does not exist, return the maximum number.

     */

    public static int thirdMax(int[] arr) {

        int l = 1;
        for (int i = 0; i < arr.length -1; i++){
            if (arr[i] != arr[i + 1]){
                arr[l] = arr[i + 1];
                l++;
            }
        }

        ArrayList<Integer> check = new ArrayList<>();
        for (int e: arr
        ) {
            if (!check.contains(e)){
                check.add(e);
            }
        }
        int[] nums = new int[check.size()];
        for (int i = 0; i < nums.length; i++){
            nums[i] = check.get(i);
        }
        Arrays.sort(nums);
        if (nums.length < 3){
            return nums[nums.length - 1];
        } else {
            return nums[nums.length - 3];
        }
    }

    public static void main(String[] args) {
        int[] nums = {2,2,3,1};
        System.out.println(thirdMax(nums));
    }

}
