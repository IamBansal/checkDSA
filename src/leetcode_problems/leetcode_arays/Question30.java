package leetcode_problems.leetcode_arays;

import java.util.Arrays;
import java.util.LinkedList;

public class Question30 {

    /*
    Given an array of intervals where intervals[i] = [start, end],
     merge all overlapping intervals,
    and return an array of the non-overlapping intervals
    that cover all the intervals in the input.
     */

    public static int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        LinkedList<int[]> result = new LinkedList<>();

        for (int[] interval : intervals) {
            if (result.size() == 0) {
                result.add(interval);
            } else {
                if (interval[0] <= result.peekLast()[1]) {
                    result.peekLast()[1] = Math.max(interval[1], result.peekLast()[1]);
                } else {
                    result.add(interval);
                }
            }
        }

        int[][] ans = result.toArray(new int[result.size()][]);

        for (int[] an : ans) {
            for (int j = 0; j < 2; j++) {
                System.out.print(an[j] + " ");
            }
            System.out.println();
        }
        System.out.println();

        return ans;
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        merge(intervals);
    }
}
