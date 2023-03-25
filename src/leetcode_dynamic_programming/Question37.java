package leetcode_dynamic_programming;

import java.util.Arrays;

public class Question37 {

    /*
    122. Best Time to Buy and Sell Stock II
    You are given an integer array prices where prices[i] is the price of a given stock on the ith day.
    On each day, you may decide to buy and/or sell the stock.
    You can only hold at most one share of the stock at any time.
    However, you can buy it then immediately sell it on the same day.
    Find and return the maximum profit you can achieve.
     */

    //Memoized solution
    public static int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        for (int[] arr : dp) Arrays.fill(arr, -1);
        return helper(prices, 0, 0, 0, dp);
    }

    private static int helper(int[] prices, int i, int canSell, int profit, int[][] dp) {

        if (i == prices.length) return 0;

        if (dp[i][canSell] != -1) return dp[i][canSell];

        if (canSell == 0) {
            int buy = -prices[i] + helper(prices, i + 1, 1, profit, dp);
            int noBuy = helper(prices, i + 1, 0, profit, dp);
            profit = Math.max(buy, noBuy);
        } else {
            int sell = prices[i] + helper(prices, i + 1, 0, profit, dp);
            int noSell = helper(prices, i + 1, 1, profit, dp);
            profit = Math.max(sell, noSell);
        }
        return dp[i][canSell] = profit;
    }

    //Tabulated solution
    public static int maxProfitTabulated(int[] prices) {
        int n = prices.length;

        int[][] dp = new int[n + 1][2];
        dp[n][0] = dp[n][1] = 0;

        for (int i = n - 1; i >= 0; i--) {
            for (int buy = 0; buy <= 1; buy++) {
                int profit;
                if (buy == 1) profit = Math.max(-prices[i] + dp[i + 1][0], dp[i + 1][1]);
                else profit = Math.max(prices[i] + dp[i + 1][1], dp[i + 1][0]);
                dp[i][buy] = profit;
            }
        }
        return dp[0][1];
    }

    //Space optimised solution
    public static int maxProfitSpaceOpt(int[] prices) {
        int aheadBuy, aheadNotBuy, curBuy, curNotBuy;
        aheadNotBuy = aheadBuy = 0;

        for (int i = prices.length - 1; i >= 0; i--) {
            curBuy = Math.max(-prices[i] + aheadNotBuy, aheadBuy);
            curNotBuy = Math.max(prices[i] + aheadBuy, aheadNotBuy);

            aheadBuy = curBuy;
            aheadNotBuy = curNotBuy;
        }

        return aheadBuy;
    }


    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        int[] prices1 = {1, 2, 3, 4, 5};
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
