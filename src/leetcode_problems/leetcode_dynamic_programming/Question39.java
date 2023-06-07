package leetcode_problems.leetcode_dynamic_programming;

import java.util.Arrays;

public class Question39 {

    /*
    188. Best Time to Buy and Sell Stock IV
    You are given an integer array prices where prices[i] is the price of a given stock on the ith day,
    and an integer k.
    Find the maximum profit you can achieve.
    You may complete at most k transactions: i.e. you may buy at most k times and sell at most k times.
    Note: You may not engage in multiple transactions simultaneously
    (i.e., you must sell the stock before you buy again).

     */

    //Memoized solution
    public static int maxProfit(int k, int[] prices) {
        int[][] dp = new int[prices.length][2 * k];
        for (int[] array : dp) Arrays.fill(array, -1);
        return helper2(prices, 0, 0, 0, dp, k);
    }

    private static int helper2(int[] prices, int i, int transaction, int profit, int[][] dp, int k) {

        if (i == prices.length || transaction == 2 * k) return 0;

        if (dp[i][transaction] != -1) return dp[i][transaction];

        if (transaction % 2 == 0) {
            int buy = -prices[i] + helper2(prices, i + 1, transaction + 1, profit, dp, k);
            int noBuy = helper2(prices, i + 1, transaction, profit, dp, k);
            profit = Math.max(buy, noBuy);
        } else {
            int sell = prices[i] + helper2(prices, i + 1, transaction + 1, profit, dp, k);
            int noSell = helper2(prices, i + 1, transaction, profit, dp, k);
            profit = Math.max(sell, noSell);
        }
        return dp[i][transaction] = profit;
    }

    //Tabulated solution
    public static int maxProfitTabulated(int k, int[] prices) {
        int n = prices.length;

        int[][] dp = new int[n + 1][2 * k + 1];

        for (int i = 0; i <= n; i++) dp[i][2 * k] = 0;

        for (int transaction = 0; transaction <= 2 * k; transaction++) dp[n][transaction] = 0;

        for (int i = n - 1; i >= 0; i--) {
            for (int transaction = 2 * k - 1; transaction >= 0; transaction--) {
                if (transaction % 2 == 0)
                    dp[i][transaction] = Math.max(-prices[i] + dp[i + 1][transaction + 1], dp[i + 1][transaction]);
                else dp[i][transaction] = Math.max(prices[i] + dp[i + 1][transaction + 1], dp[i + 1][transaction]);
            }
        }
        return dp[0][0];
    }

    //Space optimised solution
    public static int maxProfitSpaceOpt(int k, int[] prices) {
        int[] after = new int[2 * k + 1];
        int[] curr = new int[2 * k + 1];

        for (int i = prices.length - 1; i >= 0; i--) {
            for (int transaction = 2 * k - 1; transaction >= 0; transaction--) {
                if (transaction % 2 == 0) // buy case
                    curr[transaction] = Math.max(-prices[i] + after[transaction + 1], after[transaction]);
                else // sell case
                    curr[transaction] = Math.max(prices[i] + after[transaction + 1], after[transaction]);
            }
            after = curr;
        }
        return after[0];
    }

    public static void main(String[] args) {
        int[] prices0 = {2, 4, 1};
        int[] prices1 = {3, 2, 6, 5, 0, 3};

        System.out.println(maxProfit(2, prices0));
        System.out.println(maxProfit(2, prices1));
        System.out.println();
        System.out.println(maxProfitTabulated(2, prices0));
        System.out.println(maxProfitTabulated(2, prices1));
        System.out.println();
        System.out.println(maxProfitSpaceOpt(2, prices0));
        System.out.println(maxProfitSpaceOpt(2, prices1));
    }
}
