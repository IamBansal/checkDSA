package leetcode_problems.sheet_arsh.mathematical;

public class PalindromeNumber {

    /*
    9. Palindrome Number
    Given an integer x, return true if x is a palindrome, and false otherwise.
     */

    public static boolean isPalindrome(int x) {
        if (x < 0) return false;

        char[] num = String.valueOf(x).toCharArray();

        for (int i = 0; i < num.length / 2; i++){
            if (num[i] != num[num.length - 1 - i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(-121));
        System.out.println(isPalindrome(10));
    }
}
