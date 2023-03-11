package leetcode_dynamic_programming;

import java.util.Arrays;

public class Question24 {

    /*
    518. Coin Change II

    You are given an integer array coins representing coins of different denominations
     and an integer amount representing a total amount of money.
     Return the number of combinations that make up that amount.
     If that amount of money cannot be made up by any combination of the coins, return 0.
     You may assume that you have an infinite number of each kind of coin.
     The answer is guaranteed to fit into a signed 32-bit integer.

     */

        public static int change(int amount, int[] coins) {

        int[][] dp = new int[coins.length][amount + 1];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        return helper(coins, amount, coins.length - 1, dp);
    }

    private static int helper(int[] coins, int amountLeft, int index, int[][] dp) {

        if (amountLeft == 0) return 1;
        if (index == 0) return (amountLeft % coins[0] == 0) ? 1 : 0;

        if (dp[index][amountLeft] != -1) return dp[index][amountLeft];

        int notTake = helper(coins, amountLeft, index - 1, dp);
        int take = 0;
        if (coins[index] <= amountLeft) take = helper(coins, amountLeft - coins[index], index, dp);

        return dp[index][amountLeft] = take + notTake;
    }

    public static int changeBetter(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (Integer coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }

    public static void main(String[] args) {

        int[] coins = {1, 2, 5};
        int[] coins2 = {2};
        int[] coins3 = {10};
        int[] coins4 = {3, 5, 7, 8, 9, 10, 11};
        System.out.println(change(5, coins));
        System.out.println(change(3, coins2));
        System.out.println(change(10, coins3));
        System.out.println(change(500, coins4));
        System.out.println(changeBetter(5, coins));
        System.out.println(changeBetter(3, coins2));
        System.out.println(changeBetter(10, coins3));
        System.out.println(changeBetter(500, coins4));

    }
}
