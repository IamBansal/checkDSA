package leetcode_dynamic_programming;

import java.lang.reflect.Array;

public class Question6 {

    /*
    1646. Get Maximum in Generated Array

    You are given an integer n.
    A 0-indexed integer array num of length n + 1 is generated in the following way:
    - num[0] = 0
    - num[1] = 1
    - num[2 * i] = num[i] when 2 <= 2 * i <= n
    - num[2 * i + 1] = num[i] + num[i + 1] when 2 <= 2 * i + 1 <= n

    Return the maximum integer in the array num
     */

    public static int getMaximumGenerated(int n) {
        if (n <= 1) return n;

        int[] array = new int[n + 1];
        array[0] = 0;
        array[1] = 1;

        int max = 1;

        for (int j = 1; j <= (n - 1) / 2; j++) {
            array[2 * j] = array[j];
            array[2 * j + 1] = array[j] + array[j + 1];
            int greater = Math.max(array[2 * j], array[2 * j + 1]);
            if (max < greater) max = greater;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(getMaximumGenerated(7));
        System.out.println(getMaximumGenerated(2));
        System.out.println(getMaximumGenerated(3));
    }
}
