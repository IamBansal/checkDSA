package leetcode_problems.sheet_arsh.strings;

import java.util.*;

public class GroupAnagrams {

    /*
    49. Group Anagrams
    Given an array of strings, group the anagrams together. You can return the answer in any order.
    An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
    typically using all the original letters exactly once.
     */

    public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String keyStr = String.valueOf(c);
            if (!map.containsKey(keyStr)) map.put(keyStr, new ArrayList<>());
            map.get(keyStr).add(s);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {

        String[] strings = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strings));

        String[] strings1 = {""};
        System.out.println(groupAnagrams(strings1));

        String[] strings2 = {"a"};
        System.out.println(groupAnagrams(strings2));
    }
}
