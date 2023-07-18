package leetcode_problems.sheet_arsh.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class ReversePairs {

    /*
    493. Reverse Pairs
    Given an integer array nums, return the number of reverse pairs in the array.
    A reverse pair is a pair (i, j) where:
    - 0 <= i < j < nums.length, and
    - nums[i] > 2 * nums[j].
     */

    //This solution gives TLE
    public static int reversePairs(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if ((float) nums[i] > (float) 2 * nums[j]) count++;
            }
        }

        return count;
    }


    public static int reversePairsBetter(int[] nums) {

        int[] temp = new int[nums.length];
        System.arraycopy(nums, 0, temp, 0, nums.length);
        Arrays.sort(temp);

        ArrayList<Integer> check = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++){
            int num = temp[i];
            if (!check.contains(num)) check.add(num);
            map.put(nums[i], i);
        }

        System.out.println(check + " check");
        System.out.println(map);
//        for (int i = 0; i < nums.length; i++){
//            if (check.indexOf(nums[i]) != 0){
//
//            }
//        }


        return 0;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,2,3,1};
//        int[] nums = {2,4,3,5,1};
//        int[] nums1 = {2147483647, 2147483647, 2147483647, 2147483647, 2147483647, 2147483647};
        System.out.println(reversePairsBetter(nums));

    }
}
