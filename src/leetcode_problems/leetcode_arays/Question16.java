package leetcode_problems.leetcode_arays;

public class Question16 {


    /*
    Given an integer array nums, handle multiple queries of the following type:

Calculate the sum of the elements of nums between indices
left and right inclusive where left <= right.
Implement the NumArray class:

NumArray(int[] nums) Initializes the object with the integer array nums.
int sumRange(int left, int right) Returns the sum of the elements of nums
 between indices left and right inclusive
(i.e. nums[left] + nums[left + 1] + ... + nums[right]).
     */

    private int[] sumTill;

    public Question16(int[] nums) {
        sumTill = new int[nums.length + 1];
        for (int i = 1; i < sumTill.length; i++) {
            sumTill[i] += nums[i - 1] + sumTill[i - 1];
        }
    }

    public int sumRange(int left, int right) {
        return sumTill[right + 1] - sumTill[left];
    }

    public static void main(String[] args) {
        int[] nums = {-2, 0, 3, -5, 2, -1};
        Question16 obj = new Question16(nums);
        int param_1 = obj.sumRange(0, 5);
        System.out.println(param_1);
    }
}
