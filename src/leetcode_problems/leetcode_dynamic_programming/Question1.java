package leetcode_problems.leetcode_dynamic_programming;

public class Question1 {

    /*
        Question Number 70. Climbing Stairs
        You are climbing a staircase. It takes n steps to reach the top.
        Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

     */
    public static int climbStairs(int n) {

        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]);
        }
        return dp[n];
    }

    //Better in space
    public static int climbStairsBetter(int n) {
        if(n <= 1){
            return 1;
        }
        int prev2 = 1;
        int prev = 1;

        for (int i = 2; i <= n; i++) {
            int curr = prev + prev2;
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(2));
        System.out.println(climbStairs(3));
        System.out.println(climbStairsBetter(2));
        System.out.println(climbStairsBetter(3));
    }
}
