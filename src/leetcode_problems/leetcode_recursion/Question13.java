package leetcode_problems.leetcode_recursion;

public class Question13 {

    /*

    A digit string is good if the digits (0-indexed) at even indices are even
    and the digits at odd indices are prime (2, 3, 5, or 7).

    For example, "2582" is good because the digits (2 and 8) at even positions are even
    and the digits (5 and 2) at odd positions are prime.
    However, "3245" is not good because 3 is at an even index but is not even.
    Given an integer n, return the total number of good digit strings of length n.
    Since the answer may be large, return it modulo 109 + 7.

    A digit string is a string consisting of digits 0 through 9 that may contain leading zeros.

     */

    public static long mod = 1000000007;

    //This function is better as it can work for greater long values also.
    public static int countGoodNumbersBetter(long n) {

        long odd = n / 2;
        long even = (n + 1) / 2;
        return (int) (pow(5, even) * pow(4, odd) % mod);

    }

    public static long pow(long x, long n) {

        //Divide and conquer approach.
        if (n == 0) return 1;

        long temp = pow(x, n / 2);

        if (n % 2 == 0) {
            return (temp * temp) % mod;
        } else {
            return (x * temp * temp) % mod;
        }
    }

    public static int countGoodNumbers(long n) {

        if (n == 1) {
            return 5;
        }
        return (int) count(n, 0);
    }

    private static long count(long n, int i) {
        if (i == n) {
            return 1;
        }
        int mod = (int) (1e9 + 7);

        if (i % 2 == 0) {
            return (int) (5 * count(n, i + 1) % mod);
        }
        return (int) (4 * count(n, i + 1) % mod);
    }

    public static void main(String[] args) {
        System.out.println(countGoodNumbers(1));
        System.out.println(countGoodNumbers(2));
        System.out.println(countGoodNumbers(4));
        System.out.println(countGoodNumbersBetter(5000000));
    }

}
