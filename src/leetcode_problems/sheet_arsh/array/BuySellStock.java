package leetcode_problems.sheet_arsh.array;

public class BuySellStock {

    /*
    121. Best Time to Buy and Sell Stock
    You are given an array prices where prices[i] is the price of a given stock on the ith day.
    You want to maximize your profit by choosing a single day to buy one stock and
    choosing a different day in the future to sell that stock.

    Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
     */

    public static int maxProfit(int[] prices) {
        int mini = prices[0];
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            profit = Math.max(profit, prices[i] - mini);
            mini = Math.min(mini, prices[i]);
        }
        return profit;
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));
    }
}