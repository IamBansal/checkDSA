package leetcode_dynamic_programming;

public class Question9 {

    public static boolean canJump(int[] nums) {
        if (nums.length == 1) return true;

        boolean[] dp = new boolean[nums.length];
        dp[dp.length - 1] = true;
        dp[dp.length - 2] = nums[nums.length - 2] != 0;

        for (int i = 0; i < dp.length - 2; i++) {
            dp[i] = false;
        }

        for (int i = nums.length - 3; i >= 0; i--) {
            int index = Math.min(i + nums[i], nums.length - 1);
            for (int j = i + 1; j <= index; j++) {
                if (dp[j]) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[0];

    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 0, 4};
        System.out.println(canJump(nums));
    }
}
