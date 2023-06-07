package leetcode_problems.leetcode_arays;

public class Question8 {

    /*
    121. Best Time to Buy and Sell Stock

    You are given an array prices where prices[i] is the price of a given stock on the ith day.
    You want to maximize your profit by choosing a single day to buy one stock and choosing
    a different day in the future to sell that stock.
    Return the maximum profit you can achieve from this transaction.
    If you cannot achieve any profit, return 0.
     */

    public static int maxProfit(int[] prices) {
        int profit = 0;

        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int diff = prices[j] - prices[i];
                if (diff > 0 && diff > profit) {
                    profit = diff;
                }
            }
        }

        return profit;
    }

    public static int maxProfitBetter(int[] prices) {
        int profit = 0;
        int iBuy = 0; // index when buying
        for (int i = 0; i < prices.length; i++) {
            if (prices[iBuy] > prices[i]) iBuy = i;
            profit = Math.max(profit, prices[i] - prices[iBuy]);
        }
        return profit;
    }

    public static int maxProfitBest(int[] prices){
        int mini = prices[0];
        int profit = 0;
        for (int i = 1; i < prices.length; i++){
            profit = Math.max(profit, prices[i] - mini);
            mini = Math.min(mini, prices[i]);
        }
        return profit;
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        int[] prices1 = {9, 3, 7, 10, 2, 4, 6};
        System.out.println(maxProfit(prices));
        System.out.println(maxProfit(prices1));
        System.out.println(maxProfitBetter(prices1));
        System.out.println(maxProfitBest(prices));
        System.out.println(maxProfitBest(prices1));
    }
}
