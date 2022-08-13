package leetcode_strings;

import java.util.Arrays;
import java.util.List;

public class Question10 {

    /*
     Given a pattern and a string s, find if s follows the same pattern.

     Here follow means a full match,
     such that there is a bijection between a letter in pattern and a non-empty word in s.
     */

    public static boolean wordPattern(String pattern, String s) {
        List<String> arr = Arrays.asList(s.split(" "));
        int n = pattern.length();
        if (n != arr.size())
            return false;
        for (int i = 0; i < n; i++) {
            if (pattern.indexOf(pattern.substring(i, i + 1)) != arr.indexOf(arr.get(i)))
                return false;
        }
        return true;

    }

    public static void main(String[] args) {
        System.out.println(wordPattern("abba", "dog cat cat dog"));
        System.out.println(wordPattern("abba", "dog cat cat rat"));
    }
}