package leetcode_problems.sheet_arsh.stacks_queues;

import java.util.Stack;

public class OnlineStockSpan {

    /*
    901. Online Stock Span
    Design an algorithm that collects daily price quotes for some stock and
    returns the span of that stock's price for the current day.
    The span of the stock's price in one day is the maximum number of consecutive days
    (starting from that day and going backward) for which the stock price was
    less than or equal to the price of that day.

    For example, if the prices of the stock in the last four days is [7,2,1,2]
    and the price of the stock today is 2, then the span of today is 4 because starting from today,
    the price of the stock was less than or equal 2 for 4 consecutive days.
    Also, if the prices of the stock in the last four days is [7,34,1,2]
    and the price of the stock today is 8, then the span of today is 3 because starting from today,
    the price of the stock was less than or equal 8 for 3 consecutive days.

    Implement the StockSpanner class:
    - StockSpanner() Initializes the object of the class.
    - int next(int price) Returns the span of the stock's price given that today's price is price.
     */
    Stack<int[]> stack1;
    public OnlineStockSpan() {
        stack1 = new Stack<>();
    }

    //In it an array is made with 0th index as the price and 1st index as the span value and stored in stack

    public int next(int price) {
        int val = 1;
        while (!stack1.isEmpty() && stack1.peek()[0] <= price) val += stack1.pop()[1];
        stack1.push(new int[]{price, val});
        return val;
    }

    public static void main(String[] args) {
        OnlineStockSpan obj = new OnlineStockSpan();
        obj.next(100);
        obj.next(80);
        obj.next(60);
        obj.next(70);
        obj.next(60);
        obj.next(75);
        obj.next(85);
    }
}
