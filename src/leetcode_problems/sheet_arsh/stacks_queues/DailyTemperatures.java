package leetcode_problems.sheet_arsh.stacks_queues;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class DailyTemperatures {

    /*
    739. Daily Temperatures
    Given an array of integers temperatures represents the daily temperatures,
    return an array answer such that answer[i] is the number of days you have to wait
    after the ith day to get a warmer temperature.
    If there is no future day for which this is possible, keep answer[i] == 0 instead.
     */

    //This solution is taking so much time.
    public static int[] dailyTemperatures(int[] temperatures) {

        Map<Integer, Integer> map = new HashMap<>(); // map from x to next greater element of x
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> stackIndexes = new Stack<>();
        for (int i = 0; i < temperatures.length; i++) {
            int num = temperatures[i];
            while (!stack.isEmpty() && stack.peek() < num) {
                stack.pop();
                map.put(stackIndexes.pop(), i);
            }
            stackIndexes.push(i);
            stack.push(num);
        }
        for (int i = 0; i < temperatures.length; i++) {
            if (map.containsKey(i)) temperatures[i] = Math.abs(map.get(i) - i);
            else temperatures[i] = 0;
        }
        return temperatures;
    }

    public static void main(String[] args) {
        int[] temp = {73, 74, 75, 71, 69, 72, 76, 73};
        for (int num : dailyTemperatures(temp)) System.out.print(num + " ");
        System.out.println();

        int[] temp1 = {30, 40, 50, 60};
        for (int num : dailyTemperatures(temp1)) System.out.print(num + " ");
        System.out.println();

        int[] temp2 = {30, 60, 90};
        for (int num : dailyTemperatures(temp2)) System.out.print(num + " ");
        System.out.println();
    }
}
