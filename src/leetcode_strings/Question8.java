package leetcode_strings;

public class Question8 {

    /*
    Given an integer columnNumber, return its corresponding column title as it appears in an Excel sheet.

     For example:

     A -> 1
     B -> 2
     C -> 3
     ...
     Z -> 26
     AA -> 27
     AB -> 28
     ...
     */

    public static String convertToTitle(int columnNumber) {
        StringBuilder ans = new StringBuilder();
        while (columnNumber > 0) {
            columnNumber--;
            ans.insert(0, (char) ('A' + (int) ((26 + (long) columnNumber) % 26)));
            columnNumber /= 26;
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println(convertToTitle(701));
        System.out.println(convertToTitle(1));
        System.out.println(convertToTitle(28));
    }
}
