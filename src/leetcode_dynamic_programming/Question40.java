package leetcode_dynamic_programming;

import java.util.Arrays;

public class Question40 {

    /*
    309. Best Time to Buy and Sell Stock with Cooldown
    You are given an array prices where prices[i] is the price of a given stock on the ith day.
    Find the maximum profit you can achieve.
    You may complete as many transactions as you like
    (i.e., buy one and sell one share of the stock multiple times) with the following restrictions:
    After you sell your stock, you cannot buy stock on the next day (i.e., cooldown one day).

    Note: You may not engage in multiple transactions simultaneously
    (i.e., you must sell the stock before you buy again).

     */

    //Memoized solution
    public static int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        for (int[] arr : dp) Arrays.fill(arr, -1);
        return helper(prices, 0, 0, 0, dp);
    }

    private static int helper(int[] prices, int i, int canSell, int profit, int[][] dp) {

        if (i >= prices.length) return 0;

        if (dp[i][canSell] != -1) return dp[i][canSell];

        if (canSell == 0) {
            int buy = -prices[i] + helper(prices, i + 1, 1, profit, dp);
            int noBuy = helper(prices, i + 1, 0, profit, dp);
            profit = Math.max(buy, noBuy);
        } else {
            int sell = prices[i] + helper(prices, i + 2, 0, profit, dp);
            int noSell = helper(prices, i + 1, 1, profit, dp);
            profit = Math.max(sell, noSell);
        }
        return dp[i][canSell] = profit;
    }

    //Tabulated solution
    public static int maxProfitTabulated(int[] prices) {
        int n = prices.length;

        int[][] dp = new int[n + 2][2];
        dp[n][0] = dp[n][1] = dp[n + 1][0] = dp[n + 1][1] = 0;

        for (int i = n - 1; i >= 0; i--) {
            dp[i][1] = Math.max(-prices[i] + dp[i + 1][0], dp[i + 1][1]);
            dp[i][0] = Math.max(prices[i] + dp[i + 2][1], dp[i + 1][0]);
        }
        return dp[0][1];
    }

    //Space optimised solution
    public static int maxProfitSpaceOpt(int[] prices) {

        int[] front2 = new int[2];
        int[] front1 = new int[2];
        int[] curr = new int[2];

        for (int i = prices.length - 1; i >= 0; i--) {
            curr[1] = Math.max(-prices[i] + front1[0], front1[1]);
            curr[0] = Math.max(prices[i] + front2[1], front1[0]);

            System.arraycopy(front1, 0, front2, 0, front2.length);
            System.arraycopy(curr, 0, front1, 0, front1.length);
        }

        return curr[1];
    }

    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 0, 2};
        int[] prices1 = {1};
        System.out.println(maxProfit(prices));
        System.out.println(maxProfit(prices1));
        System.out.println();
        System.out.println(maxProfitTabulated(prices));
        System.out.println(maxProfitTabulated(prices1));
        System.out.println();
        System.out.println(maxProfitSpaceOpt(prices));
        System.out.println(maxProfitSpaceOpt(prices1));
    }
}
