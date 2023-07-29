package leetcode_problems.sheet_arsh.mathematical;

public class ReverseInteger {

    /*
    7. Reverse Integer
    Given a signed 32-bit integer x, return x with its digits reversed.
    If reversing x causes the value to go outside the signed 32-bit integer range [-2^31, 2^31 - 1],
    then return 0.
    Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
     */

    public static int reverse(int x) {
        if (x / 10 == 0) return x;

        boolean isNegative = false;
        StringBuilder res = new StringBuilder();
        if (x < 0) {
            isNegative = true;
            x = -x;
            if (x == Integer.MIN_VALUE) return 0;
        }
        while (x > 0) {
            res.append(x % 10);
            x /= 10;
        }

        if (Long.parseLong(res.toString()) > Integer.MAX_VALUE) {
            return 0;
        } else {
            int result = (int) Long.parseLong(res.toString());
            if (isNegative) return -result;
            else return result;
        }
    }

    public static int reverseBetter(int x) {
        int max = Integer.MAX_VALUE;
        long reverse = 0;

        while (x != 0) {
            reverse = reverse * 10 + x % 10;
            x /= 10;
            if (Math.abs(reverse) > max) return 0;
        }

        return (int) reverse;
    }

    public static void main(String[] args) {
        System.out.println(reverse(123));
        System.out.println(reverse(-123));
        System.out.println(reverse(120));
        System.out.println(reverse(1534236469));
        System.out.println(reverse(0));
        System.out.println(reverse(-2147483648));
    }
}
