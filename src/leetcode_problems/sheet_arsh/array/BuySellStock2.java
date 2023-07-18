package leetcode_problems.sheet_arsh.array;

public class BuySellStock2 {

    /*
    122. Best Time to Buy and Sell Stock II
    You are given an integer array prices where prices[i] is the price of a given stock on the ith day.
    On each day, you may decide to buy and/or sell the stock.
    You can only hold at most one share of the stock at any time.
    However, you can buy it then immediately sell it on the same day.
    Find and return the maximum profit you can achieve.
     */

    //This solution gives TLE
    public static int maxProfitRecursive(int[] prices) {
        return helper(prices, true, 0);
    }

    private static int helper(int[] prices, boolean canBuy, int index) {
        if (index == prices.length) return 0;
        if (canBuy) {
            int buy = -prices[index] + helper(prices, false, index + 1);
            int notBuy = helper(prices, true, index + 1);
            return Math.max(buy, notBuy);
        } else {
            int sell = prices[index] + helper(prices, true, index + 1);
            int notSell = helper(prices, false, index + 1);
            return Math.max(sell, notSell);
        }
    }

    //Memoized solution
    public static int maxProfitMemoized(int[] prices) {
        int[][] dp = new int[prices.length][2];
        return helper(prices, 1, 0, dp);
    }

    private static int helper(int[] prices, int canBuy, int index, int[][] dp) {
        if (index == prices.length) return 0;
        if (dp[index][canBuy] != 0) return dp[index][canBuy];
        if (canBuy == 1) {
            int buy = -prices[index] + helper(prices, 0, index + 1, dp);
            int notBuy = helper(prices, 1, index + 1, dp);
            dp[index][canBuy] = Math.max(buy, notBuy);
        } else {
            int sell = prices[index] + helper(prices, 1, index + 1, dp);
            int notSell = helper(prices, 0, index + 1, dp);
            dp[index][canBuy] = Math.max(sell, notSell);
        }
        return dp[index][canBuy];
    }

    //Tabulated solution
    public static int maxProfitTabulated(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n + 1][2];
        dp[n][0] = dp[n][1] = 0;

        for (int index = n - 1; index >= 0; index--) {
            for (int canBuy = 0; canBuy <= 1; canBuy++) {
                if (canBuy == 1) {
                    int buy = -prices[index] + dp[index + 1][0];
                    int notBuy = dp[index + 1][1];
                    dp[index][canBuy] = Math.max(buy, notBuy);
                } else {
                    int sell = prices[index] + dp[index + 1][1];
                    int notSell = dp[index + 1][0];
                    dp[index][canBuy] = Math.max(sell, notSell);
                }
            }
        }
        return dp[0][1];
    }

    //Space optimised solution of tabulated one.
    public static int maxProfitSpaceOptimised(int[] prices) {
        int aheadBuy = 0, aheadNotBuy = 0, curBuy, curNotBuy;
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
        System.out.println(maxProfitRecursive(prices));
        System.out.println(maxProfitMemoized(prices));
        System.out.println(maxProfitTabulated(prices));
        System.out.println(maxProfitSpaceOptimised(prices));
    }
}
