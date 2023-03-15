package leetcode_dynamic_programming;

import java.util.Arrays;

public class Question33 {

    /*
    1312. Minimum Insertion Steps to Make a String Palindrome
    Given a string s. In one step you can insert any character at any index of the string.
    Return the minimum number of steps to make s palindrome.
    A Palindrome String is one that reads the same backward as well as forward.
     */

    public static int minInsertions(String text1) {

        StringBuilder text2 = new StringBuilder();
        for (int i = text1.length() - 1; i >= 0; i--) text2.append(text1.charAt(i));

        if (text1.equals(text2.toString())) return 0;

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

        return (text1.length() - prev[text2.length()]);
    }

    public static void main(String[] args) {
        System.out.println(minInsertions("zzazz"));
        System.out.println(minInsertions("mbadm"));
        System.out.println(minInsertions("leetcode"));
    }
}
