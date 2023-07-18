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

    public static int maxProfit(int[] prices) {
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
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }
}
