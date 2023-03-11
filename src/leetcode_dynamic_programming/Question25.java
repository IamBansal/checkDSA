package leetcode_dynamic_programming;

import java.util.Arrays;

public class Question25 {

    /*
    322. Coin Change
    You are given an integer array coins representing coins of different denominations
    and an integer amount representing a total amount of money.
    Return the fewest number of coins that you need to make up that amount.
    If that amount of money cannot be made up by any combination of the coins, return -1.

    You may assume that you have an infinite number of each kind of coin.

     */

    //Memoized solution
    public static int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length][amount + 1];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        int ans = helper(coins, amount, coins.length - 1, dp);
        return (ans == (int) 1e7) ? -1 : ans;
    }

    private static int helper(int[] coins, int amountLeft, int index, int[][] dp) {

        if (amountLeft == 0) return 0;
        if (index == 0) return (amountLeft % coins[0] == 0) ? amountLeft / coins[0] : (int) 1e7;

        if (dp[index][amountLeft] != -1) return dp[index][amountLeft];

        int notTake = helper(coins, amountLeft, index - 1, dp);
        int take = (int) 1e7;
        if (coins[index] <= amountLeft) take = 1 + helper(coins, amountLeft - coins[index], index, dp);

        return dp[index][amountLeft] = Math.min(take, notTake);
    }

    //Tabulated solution
    public static int coinChangeBetter(int[] coins, int amount) {
        Arrays.sort(coins);
        int[] best = new int[amount + 1];
        Arrays.fill(best, 1, amount + 1, amount + 1);
        for (int c : coins) {
            for (int i = c; i <= amount; i++) {
                best[i] = Math.min(best[i], 1 + best[i - c]);
            }
        }
        return best[amount] == amount + 1 ? -1 : best[amount];
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int[] coins2 = {2};
        int[] coins3 = {1};
        int[] coins4 = {2, 5, 10, 1};
        System.out.println(coinChange(coins, 11));
        System.out.println(coinChange(coins2, 3));
        System.out.println(coinChange(coins3, 0));
        System.out.println(coinChange(coins4, 27));
        System.out.println();
        System.out.println(coinChangeBetter(coins, 11));
        System.out.println(coinChangeBetter(coins2, 3));
        System.out.println(coinChangeBetter(coins3, 0));
        System.out.println(coinChangeBetter(coins4, 27));
    }
}