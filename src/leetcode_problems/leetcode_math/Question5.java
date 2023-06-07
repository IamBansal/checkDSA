package leetcode_problems.leetcode_math;

public class Question5 {

    /*
    171. Excel Sheet Column Number
    Given a string columnTitle that represents the column title as appears in an Excel sheet, return its corresponding column number.
    For example:
    A -> 1
    B -> 2
    C -> 3
    Z -> 26
    AA -> 27
    AB -> 28

     */

    public static int titleToNumber(String columnTitle) {
        int sum = 0;
        for (char c : columnTitle.toCharArray()) sum = sum * 26 + c - 'A' + 1;
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(titleToNumber("A"));
        System.out.println(titleToNumber("Z"));
        System.out.println(titleToNumber("AB"));
        System.out.println(titleToNumber("ZY"));
        System.out.println(titleToNumber("FXSHRXW")); // Ans - 2147483647

    }
}
