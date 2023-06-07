package leetcode_problems.leetcode_arays;

import java.util.HashMap;

public class Question12 {

    /*
    Given an integer array nums and an integer k,
    return true if there are two distinct indices i and j in the array
    such that nums[i] == nums[j] and abs(i - j) <= k.

     */

    public static boolean containsNearbyDuplicate(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                if (i - map.get(arr[i]) <= k) {
                    return true;
                }
            }
            map.put(arr[i], i);
        }

        return false;
    }
    public static void main(String[] args) {
        int[] nums = {2,2};
        int k = 3;
        System.out.println(containsNearbyDuplicate(nums, k));
    }

}
