package leetcode_strings;

import java.util.ArrayList;

public class Question21 {

    /*
    You are given a license key represented as a string s that consists of only alphanumeric characters and dashes.
    The string is separated into n + 1 groups by n dashes. You are also given an integer k.

We want to reformat the string s such that each group contains exactly k characters,
except for the first group, which could be shorter than k but still must contain at least one character.
Furthermore, there must be a dash inserted between two groups, and you should convert all lowercase letters to uppercase.

Return the reformatted license key.
     */

    public static String licenseKeyFormatting(String s, int k) {
        String str = s.toUpperCase();

        ArrayList<Character> check = new ArrayList<>();
        for (int i = str.length() - 1; i >= 0; i--) {
            if (str.charAt(i) != '-') {
                check.add(str.charAt(i));
            }
        }
        StringBuilder result = new StringBuilder();
        int count = 0;
        for (int i = 0; i < check.size(); i++) {
            if (count == k) {
                count = 0;
                result.append('-');
                i--;
            } else {
                count++;
                result.append(check.get(i));
            }
        }
        return result.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(licenseKeyFormatting("5F3Z-2e-9-w", 4));
        System.out.println(licenseKeyFormatting("2-5g-3-J", 2));
    }
}
