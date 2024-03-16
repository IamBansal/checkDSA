package leetcode_problems.sheet_arsh.searching_sorting;

import java.util.Arrays;

public class PermutationsInArray {

    /*
    GFG Problem
    Given two arrays of equal size N and an integer K.
    The task is to check if after permuting both arrays, we get sum of their corresponding element
    greater than or equal to k i.e., Ai + Bi >= K for all i (from 0 to N-1).
    Return true if possible, else false.
     */
    public static boolean isPossible(long a[], long b[], int n, long k) {
        Arrays.sort(a);
        Arrays.sort(b);

        for(int i = 0; i < n; i++) if(a[i] + b[n - i - 1] < k) return false;
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPossible(new long[]{7, 8, 9},new long[]{2, 1, 3}, 3, 10));
    }
}
