package leetcode_problems.sheet_arsh.dynamic_programming;

public class ClimbingStairs {

    /*
    70. Climbing Stairs
    You are climbing a staircase. It takes n steps to reach the top.
    Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
     */

    public static int climbStairs(int n) {
        if (n == 1) return 1;

        int[] dp = new int[n];
        dp[n - 1] = 1;
        dp[n - 2] = 2;

        for (int i = n - 3; i >= 0; i--) dp[i] = dp[i + 1] + dp[i + 2];
        return dp[0];
    }

    public int climbStairsSpaceOptimised(int n) {
        if (n <= 1) return 1;
        int prev2 = 1, prev = 1, curr = 0;

        for (int i = 2; i <= n; i++) {
            curr = prev + prev2;
            prev2 = prev;
            prev = curr;
        }
        return curr;
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(2));
        System.out.println(climbStairs(3));
    }
}
