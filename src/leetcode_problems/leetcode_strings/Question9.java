package leetcode_problems.leetcode_strings;

import java.util.ArrayList;

public class Question9 {

    /*
    Given two strings s and t, return true if t is an anagram of s, and false otherwise.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
typically using all the original letters exactly once.

     */

    public static boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }
        ArrayList<Character> check1 = new ArrayList<>();
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        for (Character e : sArray) {
            check1.add(e);
        }

        for (Character e : tArray) {
            if (check1.contains(e)) {
                check1.remove(e);
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram"));
        System.out.println(isAnagram("cat", "car"));
    }

}
