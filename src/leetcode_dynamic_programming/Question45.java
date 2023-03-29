package leetcode_dynamic_programming;

import java.util.Arrays;
import java.util.Comparator;

public class Question45 {

    /*
    1048. Longest String Chain
    You are given an array of words where each word consists of lowercase English letters.
    wordA is a predecessor of wordB if and only if we can insert exactly one letter anywhere in wordA
     without changing the order of the other characters to make it equal to wordB.

     For example, "abc" is a predecessor of "abac", while "cba" is not a predecessor of "bcad".
     A word chain is a sequence of words [word1, word2, ..., wordk] with k >= 1,
     where word1 is a predecessor of word2, word2 is a predecessor of word3, and so on.
     A single word is trivially a word chain with k == 1.

     Return the length of the longest possible word chain with words chosen from the given list of words.
     */

    public static int longestStrChain(String[] words) {

        int[] arr = new int[words.length];
        Arrays.sort(words, Comparator.comparingInt(String::length));
        Arrays.fill(arr, 1);

        int max = 1;
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < i; j++) {
                if (isPossible(words[i], words[j]) && 1 + arr[j] > arr[i]) arr[i] = 1 + arr[j];
            }
            max = Math.max(max, arr[i]);
        }
        return max;

    }

    private static boolean isPossible(String s1, String s2) {
        if (s1.length() != 1 + s2.length()) return false;

        int first = 0, second = 0;
        while (first < s1.length() ) {
            if (second < s2.length() && s1.charAt(first) == s2.charAt(second)) {
                first++;
                second++;
            } else {
                first++;
            }
        }

        return first == s1.length() && second == s2.length();
    }

    public static void main(String[] args) {

        String[] words = {"a", "b", "ba", "bca", "bda", "bdca"};
        String[] words1 = {"xbc", "pcxbcf", "xb", "cxbc", "pcxbc"};
        String[] words2 = {"abcd", "dbqca"};
        System.out.println(longestStrChain(words));
        System.out.println(longestStrChain(words1));
        System.out.println(longestStrChain(words2));

    }
}
