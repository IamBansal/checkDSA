package leetcode_problems.sheet_arsh.mathematical;

import java.util.ArrayList;

public class KthFactorOfN {

    /*
    1492. The kth Factor of n
    You are given two positive integers n and k.
    A factor of an integer n is defined as an integer i, where n % i == 0.
    Consider a list of all factors of n sorted in ascending order,
    return the kth factor in this list or return -1 if n has less than k factors.
     */

    public static int kthFactor(int n, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        for (int i = 2; i < n; i++) {
            if (n % i == 0) list.add(i);
        }
        list.add(n);
        if (k > list.size()) return -1;
        return list.get(k - 1);
    }

    public static int kthFactorBetter(int n, int k) {
        for (int i = 1; i <= n; i++){
            if (n % i == 0) k--;
            if (k == 0) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(kthFactor(12, 3));
        System.out.println(kthFactor(7, 2));
        System.out.println(kthFactor(4, 4));
        System.out.println(kthFactorBetter(12, 3));
        System.out.println(kthFactorBetter(7, 2));
        System.out.println(kthFactorBetter(4, 4));
    }
}
