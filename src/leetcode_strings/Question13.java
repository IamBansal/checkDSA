package leetcode_strings;

import java.util.ArrayList;

public class Question13 {

    /*
Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.

Each letter in magazine can only be used once in ransomNote.

      */

    public static boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }

        ArrayList<Character> magazineCheck = new ArrayList<>();
        for (int i = 0; i < magazine.length(); i++) {
            char ch = magazine.charAt(i);
            magazineCheck.add(ch);
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            Character ch = ransomNote.charAt(i);
            if (magazineCheck.contains(ch)) {
                magazineCheck.remove(ch);
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(canConstruct("a", "b"));
        System.out.println(canConstruct("aa", "ba"));
        System.out.println(canConstruct("aa", "aab"));
        System.out.println(canConstruct("aa", "aba"));
        System.out.println(canConstruct("aa", "a"));
    }
}
