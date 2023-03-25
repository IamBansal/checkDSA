package leetcode_dynamic_programming;

import java.util.Arrays;

public class Question38 {

    /*
    123. Best Time to Buy and Sell Stock III
    You are given an array prices where prices[i] is the price of a given stock on the ith day.
    Find the maximum profit you can achieve. You may complete at most two transactions.

    Note: You may not engage in multiple transactions simultaneously
    (i.e., you must sell the stock before you buy again).
     */

    //Memoized solution
    public static int maxProfit(int[] prices) {
        int[][][] dp = new int[prices.length][2][3];
        for (int[][] arr : dp) {
            for (int[] array : arr) Arrays.fill(array, -1);
        }
        return helper(prices, 0, 0, 0, dp, 2);
    }

    private static int helper(int[] prices, int i, int canSell, int profit, int[][][] dp, int buysLeft) {

        if (i == prices.length || buysLeft == 0) return 0;

        if (dp[i][canSell][buysLeft] != -1) return dp[i][canSell][buysLeft];

        if (canSell == 0) {
            int buy = -prices[i] + helper(prices, i + 1, 1, profit, dp, buysLeft);
            int noBuy = helper(prices, i + 1, 0, profit, dp, buysLeft);
            profit = Math.max(buy, noBuy);
        } else {
            int sell = prices[i] + helper(prices, i + 1, 0, profit, dp, buysLeft - 1);
            int noSell = helper(prices, i + 1, 1, profit, dp, buysLeft);
            profit = Math.max(sell, noSell);
        }
        return dp[i][canSell][buysLeft] = profit;
    }

    //Tabulated solution
    public static int maxProfitTabulated(int[] prices) {
        int n = prices.length;

        int[][][] dp = new int[n + 1][2][3];

        for (int i = 0; i <= n; i++) {
            for (int buy = 0; buy <= 1; buy++) {
                dp[i][buy][0] = 0;
            }
        }

        for (int buy = 0; buy <= 1; buy++) {
            for (int buysLeft = 0; buysLeft <= 2; buysLeft++) {
                dp[n][buy][buysLeft] = 0;
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int buy = 0; buy <= 1; buy++) {
                for (int buysLeft = 1; buysLeft <= 2; buysLeft++) {
                    if (buy == 1)
                        dp[i][buy][buysLeft] = Math.max(-prices[i] + dp[i + 1][0][buysLeft], dp[i + 1][1][buysLeft]);
                    else
                        dp[i][buy][buysLeft] = Math.max(prices[i] + dp[i + 1][1][buysLeft - 1], dp[i + 1][0][buysLeft]);
                }
            }
        }
        return dp[0][1][2];
    }

    //Space optimised solution
    public static int maxProfitSpaceOpt(int[] prices) {
        int[][] after = new int[2][3];
        int[][] curr = new int[2][3];

        for (int i = prices.length - 1; i >= 0; i--) {
            for (int buy = 0; buy <= 1; buy++) {
                for (int buysLeft = 1; buysLeft <= 2; buysLeft++) {
                    if (buy == 1)
                        curr[buy][buysLeft] = Math.max(-prices[i] + after[0][buysLeft], after[1][buysLeft]);
                    else
                        curr[buy][buysLeft] = Math.max(prices[i] + after[1][buysLeft - 1], after[0][buysLeft]);
                }
            }
            after = curr;
        }
        return after[1][2];
    }

    /*

    METHOD - 2
     4 transactions are named as we can buy-sell only 2 times
     {0, 1, 2, 3}
     even for buys and odd for sells

     */

    //Memoized solution - method 2
    public static int maxProfit2(int[] prices) {
        int[][] dp = new int[prices.length][4];
        for (int[] array : dp) Arrays.fill(array, -1);
        return helper2(prices, 0, 0, 0, dp);
    }

    private static int helper2(int[] prices, int i, int transaction, int profit, int[][] dp) {

        if (i == prices.length || transaction == 4) return 0;

        if (dp[i][transaction] != -1) return dp[i][transaction];

        if (transaction % 2 == 0) {
            int buy = -prices[i] + helper2(prices, i + 1, transaction + 1, profit, dp);
            int noBuy = helper2(prices, i + 1, transaction, profit, dp);
            profit = Math.max(buy, noBuy);
        } else {
            int sell = prices[i] + helper2(prices, i + 1, transaction + 1, profit, dp);
            int noSell = helper2(prices, i + 1, transaction, profit, dp);
            profit = Math.max(sell, noSell);
        }
        return dp[i][transaction] = profit;
    }

    //Tabulated solution - method 2
    public static int maxProfitTabulated2(int[] prices) {
        int n = prices.length;

        int[][] dp = new int[n + 1][5];

        for (int i = 0; i <= n; i++) dp[i][4] = 0;

        for (int transaction = 0; transaction <= 4; transaction++) dp[n][transaction] = 0;

        for (int i = n - 1; i >= 0; i--) {
            for (int transaction = 3; transaction >= 0; transaction--) {
                if (transaction % 2 == 0)
                    dp[i][transaction] = Math.max(-prices[i] + dp[i + 1][transaction + 1], dp[i + 1][transaction]);
                else dp[i][transaction] = Math.max(prices[i] + dp[i + 1][transaction + 1], dp[i + 1][transaction]);
            }
        }
        return dp[0][0];
    }

    //Space optimised solution - method 2
    public static int maxProfitSpaceOpt2(int[] prices) {
        int[] after = new int[5];
        int[] curr = new int[5];

        for (int i = prices.length - 1; i >= 0; i--) {
            for (int transaction = 3; transaction >= 0; transaction--) {
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
        int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};
        int[] prices1 = {1, 2, 3, 4, 5};
        int[] prices2 = {7, 6, 4, 3, 1};

        System.out.println(maxProfit(prices));
        System.out.println(maxProfit(prices1));
        System.out.println(maxProfit(prices2));
        System.out.println();
        System.out.println(maxProfit2(prices));
        System.out.println(maxProfit2(prices1));
        System.out.println(maxProfit2(prices2));
        System.out.println();
        System.out.println(maxProfitTabulated(prices));
        System.out.println(maxProfitTabulated(prices1));
        System.out.println(maxProfitTabulated(prices2));
        System.out.println();
        System.out.println(maxProfitTabulated2(prices));
        System.out.println(maxProfitTabulated2(prices1));
        System.out.println(maxProfitTabulated2(prices2));
        System.out.println();
        System.out.println(maxProfitSpaceOpt(prices));
        System.out.println(maxProfitSpaceOpt(prices1));
        System.out.println(maxProfitSpaceOpt(prices2));
        System.out.println();
        System.out.println(maxProfitSpaceOpt2(prices));
        System.out.println(maxProfitSpaceOpt2(prices1));
        System.out.println(maxProfitSpaceOpt2(prices2));
    }
}
