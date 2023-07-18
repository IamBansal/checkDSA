package leetcode_problems.sheet_arsh.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class ThreeSum {

    /*
    15. 3Sum
    Given an integer array nums, return all the triplets
    [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

    Notice that the solution set must not contain duplicate triplets.
     */

    public static List<List<Integer>> threeSum(int[] nums) {

        //HashSet is used to remove duplicates automatically
        HashSet<List<Integer>> hs = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    List<Integer> elems = new ArrayList<>();
                    elems.add(nums[i]);
                    elems.add(nums[j++]);
                    elems.add(nums[k--]);
                    hs.add(elems);
                } else if (sum > 0)
                    k--;
                else
                    j++;
            }
        }
        return new ArrayList<>(hs);
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(nums));
    }
}
