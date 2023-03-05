package leetcode_dynamic_programming;

public class Question3 {

    /*
      Count number of 1's occurring in a number in binary representation and return array.
     */

    public static int[] countBits(int n) {
        int[] result = new int[n + 1];
        for (int i = 1; i <= n; i++) result[i] = result[i >> 1] + (i & 1);
        return result;
    }

    public static void main(String[] args) {
        for (Integer e : countBits(5)) {
            System.out.print(e + " ");
        }
    }
}
