package leetcode_problems.sheet_arsh.mathematical;

import java.util.HashSet;
import java.util.Set;

public class ValidSquare {

    /*
    593. Valid Square
    Given the coordinates of four points in 2D space p1, p2, p3 and p4,
    return true if the four points construct a square.
    The coordinate of a point pi is represented as [xi, yi]. The input is not given in any order.
    A valid square has four equal sides with positive length and four equal angles (90-degree angles).
     */

    public static boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        Set<Integer> set = new HashSet<>();

        set.add(distanceSquare(p1, p2));
        set.add(distanceSquare(p1, p3));
        set.add(distanceSquare(p1, p4));
        set.add(distanceSquare(p2, p3));
        set.add(distanceSquare(p2, p4));
        set.add(distanceSquare(p3, p4));

        return !set.contains(0) && set.size() == 2;
    }

    private static int distanceSquare(int[] a, int[] b) {
        return (a[0] - b[0]) * (a[0] - b[0]) + (a[1] - b[1]) * (a[1] - b[1]);
    }

    public static void main(String[] args) {
        int[] p1 = {0, 0}, p2 = {1, 1}, p3 = {1, 0}, p4 = {0, 1};
        System.out.println(validSquare(p1, p2, p3, p4));
    }
}
