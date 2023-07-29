package leetcode_problems.sheet_arsh.mathematical;

public class HappyNumber {

    /*
    202. Happy Number
    Write an algorithm to determine if a number n is happy.
    A happy number is a number defined by the following process:
     - Starting with any positive integer, replace the number by the sum of the squares of its digits.
    - Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a
      cycle which does not include 1.
    - Those numbers for which this process ends in 1 are happy.

    Return true if n is a happy number, and false if not.
     */

    public static boolean isHappy(int n) {
        int slow = n, fast = n;
        do {
            slow = digitSquareSum(slow);
            fast = digitSquareSum(fast);
            fast = digitSquareSum(fast);
        } while (slow != fast);
        return slow == 1;
    }

    public static int digitSquareSum(int n) {
        if (n == 1) return 1;
        int result = 0;
        while (n > 0) {
            result += (n % 10) * (n % 10);
            n = n / 10;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(isHappy(19));
        System.out.println(isHappy(2));
    }
}
