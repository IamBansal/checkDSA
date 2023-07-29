package leetcode_problems.sheet_arsh.mathematical;

public class IsPowerOfTwo {

    /*
    231. Power of Two
    Given an integer n, return true if it is a power of two. Otherwise, return false.
    An integer n is a power of two, if there exists an integer x such that n == 2x.
     */

    public static boolean isPowerOfTwo(int n) {
        if (n == 1) return true;
        else if (n % 2 != 0 || n <= 0) return false;
        return isPowerOfTwo(n / 2);
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(1));
        System.out.println(isPowerOfTwo(16));
        System.out.println(isPowerOfTwo(3));
    }
}
