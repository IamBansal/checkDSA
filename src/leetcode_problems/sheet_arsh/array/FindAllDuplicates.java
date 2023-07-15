package leetcode_problems.sheet_arsh.array;

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicates {

    /*
    442. Find All Duplicates in an Array
    Given an integer array nums of length n where all the integers of nums are in the range [1, n]
    and each integer appears once or twice, return an array of all the integers that appears twice.

    You must write an algorithm that runs in O(n) time and uses only constant extra space.
     */

    public static List<Integer> findDuplicates(int[] nums) {

        List<Integer> res = new ArrayList<>();
        boolean[] arr = new boolean[nums.length + 1];
        for (int num : nums) {
            if (arr[num]) res.add(num);
            else arr[num] = true;
        }
        return res;

    }

    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        System.out.println(findDuplicates(nums));
    }
}
