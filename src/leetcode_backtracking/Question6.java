package leetcode_backtracking;

import java.util.ArrayList;
import java.util.List;

public class Question6 {

    public static int factorial(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return n * factorial(n - 1);
    }

    public static String getPermutation(int n, int k) {

        List<String> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(String.valueOf(i));
        }

        String str = "";
        return solve(list, n, k - 1, str);

    }

    private static String solve(List<String> list, int n, int k, String str) {

        if (list.isEmpty()) {
            return str;
        }
        int l = factorial(n) / n;
        str += list.get(k / l);
        list.remove(k / l);
        return solve(list, n - 1, k % l, str);

    }

    public static void main(String[] args) {
        System.out.println(getPermutation(3, 3));
        System.out.println(getPermutation(4, 9));
        System.out.println(getPermutation(3, 1));
    }

}
