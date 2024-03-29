package leetcode_problems.sheet_arsh.strings;

import java.util.ArrayList;
import java.util.HashMap;

public class ValidNumber {

    /*
    65. Valid Number
    A valid number can be split up into these components (in order):
    - A decimal number or an integer.
    - (Optional) An 'e' or 'E', followed by an integer.

    A decimal number can be split up into these components (in order):
    - (Optional) A sign character (either '+' or '-').
    - One of the following formats:
      - One or more digits, followed by a dot '.'.
      - One or more digits, followed by a dot '.', followed by one or more digits.
      - A dot '.', followed by one or more digits.

    An integer can be split up into these components (in order):
    - (Optional) A sign character (either '+' or '-').
    - One or more digits.

    For example, all the following are valid numbers:
    ["2", "0089", "-0.1", "+3.14", "4.", "-.9", "2e10", "-90E3", "3e+7", "+6e-1", "53.5e93", "-123.456e789"],
    while the following are not valid numbers: ["abc", "1a", "1e", "e3", "99e2.5", "--6", "-+3", "95a54e53"].

    Given a string s, return true if s is a valid number.
     */

    public static boolean isNumber(String s) {
        if (s.length() == 1) return Character.isDigit(s.charAt(0));

        ArrayList<Character> check = new ArrayList<>();
        for (int i = 0; i < s.length(); i++){

            if (s.charAt(i) == '.'){
                if (check.contains('.')) return false;
                check.add('.');
                if (i + 1 != s.length() && !Character.isDigit(s.charAt(i + 1))) return false;
            } else if (s.charAt(i) == 'e' || s.charAt(i) == 'E'){
                if (check.contains('e')) return false;
                check.add('e');
                if (i + 1 != s.length() && !Character.isDigit(s.charAt(i + 1))) return false;
            }


        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(isNumber("0"));
        System.out.println(isNumber("e"));
        System.out.println(isNumber("."));
    }
}
