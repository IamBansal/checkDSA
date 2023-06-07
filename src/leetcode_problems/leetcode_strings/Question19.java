package leetcode_problems.leetcode_strings;

public class Question19 {

    /*
    Given a string s, return the number of segments in the string.

    A segment is defined to be a contiguous sequence of non-space characters.
     */

    public static int countSegments(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ' && (i == 0 || s.charAt(i - 1) == ' ')) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countSegments("Hello, my name is Akshat"));
        System.out.println(countSegments("Hello"));
        System.out.println(countSegments("H  e"));
        System.out.println(countSegments(" H  e"));
        System.out.println(countSegments(""));
        System.out.println(countSegments("                     "));
        System.out.println(countSegments("Of all the gin joints in all the towns in all the world,   "));
        System.out.println(countSegments(", , , ,        a, eaefa"));
    }
}
