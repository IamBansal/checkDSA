package leetcode_problems.sheet_arsh.array;

import java.util.Arrays;

public class ChocolateDistribution {

    /*
    GFG Question

    Given an array of N integers where each value represents the number of chocolates in a packet.
    Each packet can have a variable number of chocolates.
    There are m students, the task is to distribute chocolate packets such that:
    - Each student gets one packet.
    - The difference between the number of chocolates in the packet with maximum chocolates and
      the packet with minimum chocolates given to the students is minimum.
     */

    public static int minDiff(int[] choc, int m) {
        Arrays.sort(choc);
        int diff = Integer.MAX_VALUE;
        for (int i = 0; i + m - 1 < choc.length; i++) {
            diff = Math.min(diff, choc[i + m - 1] - choc[i]);
        }
        return diff;
    }

    public static void main(String[] args) {
        int[] choc = {7, 3, 2, 4, 9, 12, 56};
        System.out.println(minDiff(choc, 3));

        int[] choc1 = {3, 4, 1, 9, 56, 7, 9, 12};
        System.out.println(minDiff(choc1, 5));

        int[] choc2 = {12, 4, 7, 9, 2, 23, 25, 41, 30, 40, 28, 42, 30, 44, 48, 43, 50};
        System.out.println(minDiff(choc2, 7));
    }
}
