package leetcode_problems.sheet_arsh.strings;

import java.util.HashMap;

public class IntegerToRoman {

    /*
    12. Integer to Roman
    Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
     */

    public static String intToRoman(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] strings = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                num -= values[i];
                result.append(strings[i]);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(intToRoman(3));
        System.out.println(intToRoman(58));
        System.out.println(intToRoman(1994));
    }
}
