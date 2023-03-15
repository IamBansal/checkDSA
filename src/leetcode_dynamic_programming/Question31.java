package leetcode_dynamic_programming;

import java.util.Arrays;

public class Question31 {

    /*
    583. Delete Operation for Two Strings
    Given two strings word1 and word2, return the minimum number of steps
    required to make word1 and word2 the same.
    In one step, you can delete exactly one character in either string.
     */

    public static int minDistance(String text1, String text2) {
        int[] prev = new int[text2.length() + 1];
        int[] curr = new int[text2.length() + 1];
        Arrays.fill(prev, 0);

        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j < prev.length; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) curr[j] = 1 + prev[j - 1];
                else curr[j] = Math.max(prev[j], curr[j - 1]);
            }
            System.arraycopy(curr, 0, prev, 0, prev.length);
        }

        return (text1.length() + text2.length() - 2 * prev[text2.length()]);
    }

    public static void main(String[] args) {
        System.out.println(minDistance("sea","eat"));
        System.out.println(minDistance("leetcode","etco"));
    }
}
