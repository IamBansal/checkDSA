package leetcode_problems.leetcode_arays;

import java.util.Arrays;
import java.util.LinkedList;

public class Question31 {

    /*
         You are given an array of non-overlapping intervals where intervals[i] = [starti, endi]
          represent the start and the end of the ith interval and intervals is sorted in ascending order by starti.
          You are also given an interval newInterval = [start, end] that represents the start and end of another interval.

        Insert newInterval into intervals such that intervals is still sorted in ascending order
         by starti and intervals still does not have any overlapping intervals
         (merge overlapping intervals if necessary).

        Return intervals after the insertion.

     */

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] newIntervalsArray = new int[intervals.length + 1][2];
        int i = 0;
        for (int[] arr : intervals) {
            newIntervalsArray[i] = arr;
            i++;
        }
        newIntervalsArray[newIntervalsArray.length - 1] = newInterval;
        return merge(newIntervalsArray);
    }


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
        int[][] intervals = {{1, 3}, {6, 9}};
        int[] newInterval = {2, 5};
        insert(intervals, newInterval);
    }
}
