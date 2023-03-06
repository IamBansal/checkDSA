package leetcode_dynamic_programming;

public class Question8 {

    /*
    You are given a 0-indexed array of integers nums of length n. You are initially positioned at nums[0].
    Each element nums[i] represents the maximum length of a forward jump from index i.
    In other words, if you are at nums[i], you can jump to any nums[i + j] where:
    -> 0 <= j <= nums[i] and
    -> i + j < n

    Return the minimum number of jumps to reach nums[n - 1]. The test cases are generated such that you can reach nums[n - 1].

     */
    static int min = (int) 1e8;

    //Recursive solution - takes time
    public static int jump(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }

        return helper(0, nums[0], nums, min);
    }

    private static int helper(int i, int j, int[] nums, int min) {

        if (i >= nums.length - 1) {
            return 0;
        }

        for (int index = i + 1; index <= i + j; index++) {
            if (index < nums.length) {
                int path = 1 + helper(index, nums[index], nums, min);
                if (path < min) min = path;
            }
        }
        return min;
    }

    //Dp - tabulation solution - better than recursion
    public static int jumpDP(int[] nums) {
        if (nums.length == 1) return 0;

        int[] dp = new int[nums.length];
        dp[dp.length - 1] = 0;
        dp[dp.length - 2] = 1;
        for (int i = 0; i < dp.length - 2; i++) {
            dp[i] = (int) 1e7;
        }

        for (int i = nums.length - 3; i >= 0; i--) {
            int min = (int) 1e8;

            int index = Math.min(i + nums[i], nums.length - 1);

            for (int j = i + 1; j <= index; j++) {
                if (min > 1 + dp[j]) min = 1 + dp[j];
            }
            dp[i] = min;
        }

        return dp[0];

    }

    //better solution in time
    public static int jumpBetterInTime(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int max = 0;
        int curr = 0;
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            max = Math.max(max, i + nums[i]);
            if (curr == i) {
                curr = max;
                count++;
            }
            if (curr > nums.length - 1) {
                return count;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,0,1,4};
        System.out.println(jumpDP(nums));
    }

}
