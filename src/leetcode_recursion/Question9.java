package leetcode_recursion;

public class Question9 {

    /*
    You have a list arr of all integers in the range [1, n] sorted in a strictly increasing order.
    Apply the following algorithm on arr:

     Starting from left to right, remove the first number and every other number afterward until you reach the end of the list.
     Repeat the previous step again, but this time from right to left,
     remove the rightmost number and every other number from the remaining numbers.
     Keep repeating the steps again, alternating left to right and right to left,
     until a single number remains.
     Given the integer n, return the last number that remains in arr.

     */

    public static int lastRemaining(int n) {

        if (n == 1) return n;

        return 2 * (1 + n / 2 - lastRemaining(n / 2));
    }

    public static int lastRemainingNormal(int n) {
        boolean left = true;
        int remaining = n;
        int step = 1;
        int head = 1;
        while (remaining > 1) {
            if (left || remaining % 2 == 1) {
                head = head + step;
            }
            remaining = remaining / 2;
            step = step * 2;
            left = !left;
        }
        return head;
    }

    public static void main(String[] args) {
        System.out.println(lastRemaining(4));
        System.out.println(lastRemainingNormal(4));
    }

}
