package leetcode_problems.sheet_arsh.strings;

import java.util.HashMap;

public class PrintDuplicates {

    /*
    GFG Problem
    Print all the duplicates in the input string.
    Write an efficient program to print all the duplicates and their counts in the input string
     */

    public static void printDuplicates(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) map.replace(c, map.get(c), map.get(c) + 1);
            else map.put(c, 1);
        }

        for (char c : s.toCharArray()) {
            if (map.get(c) < 2) map.remove(c);
        }
        System.out.println(map);
    }

    public static void main(String[] args) {
        printDuplicates("geeksforgeeks");
        printDuplicates("test string");
    }
}
