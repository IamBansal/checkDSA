package leetcode_arays;

public class Question37 {

    /*
    1480. Running Sum of 1d Array
    Given an array nums. We define a running sum of an array as runningSum[i] = sum(nums[0]…nums[i]).
    Return the running sum of nums.
     */

    public static int[] runningSum(int[] nums) {
        for (int i = 1; i < nums.length; i++) nums[i] += nums[i - 1];
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        int[] ans = runningSum(nums);
        for (Integer e : ans) System.out.print(e + " ");
    }
}
