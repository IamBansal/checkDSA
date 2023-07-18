package leetcode_problems.sheet_arsh.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class FourSum {

    /*
    18. 4Sum
    Given an array nums of n integers, return an array of all the unique quadruplets
    [nums[a], nums[b], nums[c], nums[d]] such that:
    - 0 <= a, b, c, d < n
    - a, b, c, and d are distinct.
    - nums[a] + nums[b] + nums[c] + nums[d] == target

    You may return the answer in any order.
     */

    public static List<List<Integer>> fourSum(int[] nums, int target) {

        HashSet<List<Integer>> hs = new HashSet<>();
        Arrays.sort(nums);
        for (int a = 0; a < nums.length; a++) {
            for (int i = a + 1; i < nums.length; i++) {
                int j = i + 1;
                int k = nums.length - 1;
                while (j < k) {
                    long sum = (long) nums[i] + (long)nums[j] + (long)nums[k] + (long)nums[a];

                    if (sum == target) {
                        List<Integer> elems = new ArrayList<>();
                        elems.add(nums[i]);
                        elems.add(nums[j++]);
                        elems.add(nums[k--]);
                        elems.add(nums[a]);
                        hs.add(elems);
                    } else if (sum > target)
                        k--;
                    else
                        j++;
                }
            }
        }
        return new ArrayList<>(hs);
    }

    public static void main(String[] args) {

        int[] nums = {1, 0, -1, 0, -2, 2};
        System.out.println(fourSum(nums, 0));

        //Reason to take sum as long - numerical overflow error
        int[] nums1 = {1000000000,1000000000,1000000000,1000000000};
        System.out.println(fourSum(nums1, -294967296));
    }
}
