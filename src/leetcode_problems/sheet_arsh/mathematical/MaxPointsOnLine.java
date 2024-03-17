package leetcode_problems.sheet_arsh.mathematical;

import java.util.HashMap;
import java.util.Map;

public class MaxPointsOnLine {

    /*
    149. Max Points on a Line
    Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane,
    return the maximum number of points that lie on the same straight line.
     */

    public static int maxPoints(int[][] points) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int[] array : points) {
            int sum = array[0] + array[1];
            int diff = Math.abs(array[0] - array[1]);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
            if (sum != diff) map.put(diff, map.getOrDefault(diff, 0) + 1);
        }

        int max = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (max < entry.getValue()) max = entry.getValue();
        }
        return max;
    }

    public static void main(String[] args) {
        int[][] points = {{1, 1}, {2, 2}, {3, 3}};
        System.out.println(maxPoints(points));
        int[][] points1 = {{1, 1}, {3, 2}, {5, 3}, {4, 1}, {2, 3}, {1, 4}};
        System.out.println(maxPoints(points1));
    }
}
