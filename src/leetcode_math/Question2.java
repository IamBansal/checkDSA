package leetcode_math;

public class Question2 {

    /*
    7. Reverse Integer
    Given a signed 32-bit integer x, return x with its digits reversed.
    If reversing x causes the value to go outside the signed 32-bit integer range [-2^31, 2^31 - 1], then return 0.
    Assume the environment does not allow you to store 64-bit integers (signed or unsigned).

    //2147483648 == 2^31

     */

    public static int reverse(int x) {
        boolean isNegative = false;
        if (x < 0) {
            isNegative = true;
            x = -x;
        }
        int reversed_int = 0;
        while (x > 0) {
            int pop = x % 10;
            x /= 10;
            if (reversed_int > Integer.MAX_VALUE / 10) return 0;
            reversed_int = (reversed_int * 10) + pop;
        }

        if (isNegative) return -reversed_int;
        return reversed_int;
    }

    public static void main(String[] args) {
        System.out.println(reverse(321));
        System.out.println(reverse(-321));
        System.out.println(reverse(1534236469));
        System.out.println(reverse(-2147483412));

    }
}
