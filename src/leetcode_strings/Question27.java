package leetcode_strings;

import java.util.ArrayList;
import java.util.HashMap;

public class Question27 {

    /*
      Given a string s, find the length of the longest substring without repeating characters.
     */

    public static int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> mp = new HashMap<>();
        int left = 0, right = 0, len = 0;
        for (int i = 0; i < s.length(); i++) {
            if (mp.containsKey(s.charAt(i)))
                left = Math.max(mp.get(s.charAt(i)) + 1, left);
            mp.put(s.charAt(right), right);
            len = Math.max(len, right - left + 1);
            right++;
        }
        return len;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }
}
