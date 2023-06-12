package leetcode_problems.leetcode_queue;

public class Leetcode2073 {

    /*
    2073. Time Needed to Buy Tickets
    There are n people in a line queuing to buy tickets, where the 0th person is at the front of the line
    and the (n - 1)th person is at the back of the line.
    You are given a 0-indexed integer array tickets of length n
    where the number of tickets that the ith person would like to buy is tickets[i].
    Each person takes exactly 1 second to buy a ticket.
    A person can only buy 1 ticket at a time and has to go back to the end of the line
    (which happens instantaneously) in order to buy more tickets.
    If a person does not have any tickets left to buy, the person will leave the line.

    Return the time taken for the person at position k (0-indexed) to finish buying tickets.
     */

    public static int timeRequiredToBuy(int[] tickets, int k) {

        if (tickets[k] == 1) return k + 1;

        int time = 0;
        for (int i = 0; i < tickets.length; i++) {
            if (tickets[i] >= tickets[k]) {
                if (i > k) {
                    time--;
                }
                time += tickets[k];
            } else time += tickets[i];
        }
        return time;

    }

    public static void main(String[] args) {
        int[] tickets = {84, 49, 5, 24, 70, 77, 87, 8};
        int[] tickets1 = {15, 66, 3, 47, 71, 27, 54, 43, 97, 34, 94, 33, 54, 26, 15, 52, 20, 71, 88, 42, 50, 6, 66, 88, 36, 99, 27, 82, 7, 72};
        System.out.println(timeRequiredToBuy(tickets, 3));
        System.out.println(timeRequiredToBuy(tickets1, 18));
    }
}
