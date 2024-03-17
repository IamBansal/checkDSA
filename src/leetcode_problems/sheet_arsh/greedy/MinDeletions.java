package leetcode_problems.sheet_arsh.greedy;

import java.util.*;

public class MinDeletions {

    /*
    1647. Minimum Deletions to Make Character Frequencies Unique
Medium
4.8K
72
Companies
A string s is called good if there are no two different characters in s that have the same frequency.

Given a string s, return the minimum number of characters you need to delete to make s good.

The frequency of a character in a string is the number of times it appears in the string. For example, in the string "aab", the frequency of 'a' is 2, while the frequency of 'b' is 1.


     */

    public static int minDeletions(String s) {

        //to store character frequencies
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) map.put(c, map.getOrDefault(c, 0) + 1);

        System.out.println(map);
        //to store character frequencies in decreasing order.
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        maxHeap.addAll(map.values());

        System.out.println(maxHeap);
        int delCount = 0;

        // Continue as long as there are at least two frequencies in the max-heap.
        while (maxHeap.size() > 1) {
            int top = maxHeap.poll();
            if (maxHeap.peek() != null && maxHeap.peek() == top && top != 0) {
                delCount++;
                maxHeap.add(top - 1);
            }
        }
        return delCount;
    }

    public static void main(String[] args) {
        System.out.println(minDeletions("aab"));
        System.out.println(minDeletions("aaabbbcc"));
        System.out.println(minDeletions("bbceab"));
    }
}
