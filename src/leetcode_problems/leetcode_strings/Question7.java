package leetcode_problems.leetcode_strings;

import java.util.ArrayList;

public class Question7 {

    /*
    A phrase is a palindrome if, after converting all uppercase letters into lowercase letters
    and removing all non-alphanumeric characters, it reads the same forward and backward.
    Alphanumeric characters include letters and numbers.

    Given a string s, return true if it is a palindrome, or false otherwise.
     */

    public static boolean isPalindrome(String s) {
        if (s.length() != 0) {
            ArrayList<Character> check = new ArrayList<>();
            char[] charArray = s.toLowerCase().toCharArray();
            for (char e : charArray) {
                //ASCII value for 0-9 is [48,57] and for a-z is [97, 122]
                if (((int) e >= 48 && (int) e <= 57) || ((int) e >= 97 && (int) e <= 122)) {
                    check.add(e);
                }
            }
            for (int i = 0; i < check.size(); i++) {
                if (check.get(i) != check.get(check.size() - 1 - i)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(isPalindrome("race a car"));
        System.out.println(isPalindrome("9,8"));
        System.out.println(isPalindrome(" "));
    }
}
