package leetcode_problems.sheet_arsh.dynamic_programming;

public class CountingBits {

    /*
    338. Counting Bits
    Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n),
    ans[i] is the number of 1's in the binary representation of i.
     */

    public static int[] countBits(int n) {

        int[] result = new int[n + 1];
        for (int i = 0; i < result.length; i++) result[i] = (i % 2) + result[i / 2];
        return result;
    }

    public static void printArray(int[] arr){
        for (int c: arr) System.out.print(c + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        printArray(countBits(5));
        printArray(countBits(2));
    }
}
