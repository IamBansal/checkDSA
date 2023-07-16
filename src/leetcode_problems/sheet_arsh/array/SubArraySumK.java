package leetcode_problems.sheet_arsh.array;

import java.util.HashMap;
import java.util.Map;

public class SubArraySumK {

    /*
    560. SubArray Sum Equals K
    Given an array of integers nums and an integer k,
    return the total number of subArrays whose sum equals to k.
    A subArray is a contiguous non-empty sequence of elements within an array.
     */

    //This solution gives TLE
    public static int subArraySum(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i <= nums.length; i++) {
            for (int j = 0; j + i < nums.length; j++) {
                if (sumOfArray(nums, j, j + i) == k) count++;
            }
        }
        return count;
    }

    private static int sumOfArray(int[] nums, int j, int i) {
        int sum = 0;
        for (int a = j; a <= i; a++) sum += nums[a];
        return sum;
    }

    //It uses simple pre-sum technique using hashmap
    public static int subArraySumBetter(int[] nums, int k) {
        int sum = 0, result = 0;
        Map<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0, 1);

        //here, if the map contains sum - k value, i.e., some pre-sum value
        //it means it is sa desired subArray, hence, added
        for (int num : nums) {
            sum += num;
            if (preSum.containsKey(sum - k)) result += preSum.get(sum - k);
            preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
        }
//        System.out.println(preSum);

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1};
        System.out.println(subArraySum(nums, 2));
        System.out.println(subArraySumBetter(nums, 2));
    }
}
