package leetcode_dynamic_programming;

import java.util.Arrays;

public class Question41 {

    /*
    714. Best Time to Buy and Sell Stock with Transaction Fee
    You are given an array prices where prices[i] is the price of a given stock on the ith day,
    and an integer fee representing a transaction fee.
    Find the maximum profit you can achieve. You may complete as many transactions as you like,
    but you need to pay the transaction fee for each transaction.

    Note: You may not engage in multiple transactions simultaneously
    (i.e., you must sell the stock before you buy again).
     */

    //Memoized solution
    public static int maxProfit(int[] prices, int fee) {
        int[][] dp = new int[prices.length][2];
        for (int[] arr : dp) Arrays.fill(arr, -1);
        return helper(prices, 0, 0, 0, dp, fee);
    }

    private static int helper(int[] prices, int i, int canSell, int profit, int[][] dp, int fee) {

        if (i >= prices.length) return 0;

        if (dp[i][canSell] != -1) return dp[i][canSell];

        if (canSell == 0) {
            int buy = -prices[i] - fee + helper(prices, i + 1, 1, profit, dp, fee);
            int noBuy = helper(prices, i + 1, 0, profit, dp, fee);
            profit = Math.max(buy, noBuy);
        } else {
            int sell = prices[i] + helper(prices, i + 1, 0, profit, dp, fee);
            int noSell = helper(prices, i + 1, 1, profit, dp, fee);
            profit = Math.max(sell, noSell);
        }
        return dp[i][canSell] = profit;
    }

    //Tabulated solution
    public static int maxProfitTabulated(int[] prices, int fee) {
        int n = prices.length;

        int[][] dp = new int[n + 1][2];
        dp[n][0] = dp[n][1] = 0;

        for (int i = n - 1; i >= 0; i--) {
            dp[i][1] = Math.max(-prices[i] - fee + dp[i + 1][0], dp[i + 1][1]);
            dp[i][0] = Math.max(prices[i] + dp[i + 1][1], dp[i + 1][0]);
        }
        return dp[0][1];
    }

    //Space optimised solution
    public static int maxProfitSpaceOpt(int[] prices, int fee) {

        int[] front1 = new int[2];
        int[] curr = new int[2];

        for (int i = prices.length - 1; i >= 0; i--) {
            curr[1] = Math.max(-prices[i] - fee + front1[0], front1[1]);
            curr[0] = Math.max(prices[i] + front1[1], front1[0]);

            System.arraycopy(curr, 0, front1, 0, front1.length);
        }

        return curr[1];
    }

    public static void main(String[] args) {
        int[] prices = {1, 3, 2, 8, 4, 9};
        int[] prices1 = {1, 3, 7, 5, 10, 3};
        System.out.println(maxProfit(prices, 2));
        System.out.println(maxProfit(prices1, 3));
        System.out.println();
        System.out.println(maxProfitTabulated(prices, 2));
        System.out.println(maxProfitTabulated(prices1, 3));
        System.out.println();
        System.out.println(maxProfitSpaceOpt(prices, 2));
        System.out.println(maxProfitSpaceOpt(prices1, 3));
    }
}
