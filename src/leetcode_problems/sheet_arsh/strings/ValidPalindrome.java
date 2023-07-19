package leetcode_problems.sheet_arsh.strings;

public class ValidPalindrome {

    /*
    680. Valid Palindrome II
    Given a string s, return true if the s can be palindrome after deleting at most one character from it.
     */

    public static boolean validPalindrome(String s) {
        return validPalindrome(s, true);
    }

    private static boolean validPalindrome(String s, boolean canRemove) {
        if (s.length() == 1) return true;
        int start = 0;
        int end = s.length() - 1;
        for (int i = start; i < s.length() / 2; i++) {
            if (s.charAt(i) == s.charAt(end)) {
                end--;
                start++;
            } else {
                if (canRemove) {
                    return validPalindrome(s.substring(start, end), false) || validPalindrome(s.substring(start + 1, end + 1), false);
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(validPalindrome("aba"));
        System.out.println(validPalindrome("abca"));
        System.out.println(validPalindrome("abc"));
    }
}
