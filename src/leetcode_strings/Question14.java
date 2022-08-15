package leetcode_strings;

import java.util.ArrayList;

public class Question14 {

    /*

Given a string s, find the first non-repeating character in it and return its index.
If it does not exist, return -1.
     */

    public static int firstUniqChar(String s) {
        ArrayList<Character> check = new ArrayList<>();
        char[] string = s.toLowerCase().toCharArray();
        for (Character c : string
        ) {
            check.add(c);
        }

        int index = -1;
        ArrayList<Character> removed = new ArrayList<>();
        for (int i = 0; i < string.length; i++) {
            Character ch = string[i];
            check.remove(ch);
            if (!check.contains(ch) && !removed.contains(ch)) {
                index = i;
                return index;
            }
            removed.add(ch);
        }
        return index;
    }

    public static void main(String[] args) {
        System.out.println(firstUniqChar("leetcode"));
        System.out.println(firstUniqChar("loveleetcode"));
        System.out.println(firstUniqChar("aabb"));
        System.out.println(firstUniqChar("akshat"));
    }
}
