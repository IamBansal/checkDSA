package leetcode_math;

public class Question1 {

    /*
    9. Palindrome Number
    Given an integer x, return true if x is a palindrome, and false otherwise.
     */

    //String is used
    public static boolean isPalindrome(int x) {

        if (x < 0) return false;

        StringBuilder s = new StringBuilder();
        while (x > 0) {
            s.append(x % 10);
            x = x / 10;
        }

        for (int i = 0; i < s.length() / 2; i++) if (s.charAt(i) != s.charAt(s.length() - 1 - i)) return false;
        return true;

    }

    //Without use of string - reversed integer is found here.
    public static boolean isPalindrome2(int x) {
        if (x == 0) return true;
        if (x < 0 || x % 10 == 0) return false;

        int reversed_int = 0;
        while (x > reversed_int) {
            int pop = x % 10;
            x /= 10;
            reversed_int = (reversed_int * 10) + pop;
        }

        return x == reversed_int || x == reversed_int / 10;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome2(121));
        System.out.println(isPalindrome2(-121));
        System.out.println(isPalindrome2(10));
        System.out.println(isPalindrome(1));
    }
}
