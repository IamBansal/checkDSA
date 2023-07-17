package leetcode_problems.sheet_arsh.array;

import java.util.Arrays;

public class JumpGame {

    /*
    55. Jump Game
    You are given an integer array nums. You are initially positioned at the array's first index,
    and each element in the array represents your maximum jump length at that position.

    Return true if you can reach the last index, or false otherwise.
     */

    public static boolean canJump(int[] nums) {
        if (nums.length == 1) return true;

        boolean[] dp = new boolean[nums.length];
        Arrays.fill(dp, false);
        dp[dp.length - 1] = true;
        dp[dp.length - 2] = nums[nums.length - 2] != 0;

        for (int i = nums.length - 3; i >= 0; i--) {
            int index = Math.min(i + nums[i], nums.length - 1);
            for (int j = 1 + i; j <= index; j++) {
                if (dp[j]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[0];
    }

    public static boolean canJumpBetter(int[] nums) {
        int index = 0, currJump = nums[0];

        while (++index < nums.length && currJump-- != 0) {
            currJump = Math.max(currJump, nums[index]);
        }

        System.gc();
        return index >= nums.length;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(canJump(nums));
        System.out.println(canJumpBetter(nums));
    }
}
