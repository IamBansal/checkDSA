package leetcode_problems.leetcode_strings;

public class Question28 {

    /*
    The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
    (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
     */

    public static String convert(String s, int numRows) {
        if (numRows <= 1) return s;
        int x = 2 * (numRows - 1);
        int len = s.length();
        char[] c = new char[len];
        int k = 0;
        for (int i = 0; i < numRows; i++) {
            for (int j = i; j < len; j = j + x) {
                c[k++] = s.charAt(j);
                if (i > 0 && i < numRows - 1 && j + x - 2 * i < len) {
                    c[k++] = s.charAt(j + x - 2 * i);
                }
            }
        }
        return new String(c);
    }

    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 3));
        System.out.println(convert("PAYPALISHIRING", 4));
        System.out.println(convert("G", 1));
    }
}
