package leetcode_problems.sheet_arsh.mathematical;

public class ExcelColumnTitle {

    /*
    168. Excel Sheet Column Title
    Given an integer columnNumber, return its corresponding column title as it appears in an Excel sheet.
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
        System.out.println(convertToTitle(1));
        System.out.println(convertToTitle(28));
        System.out.println(convertToTitle(701));
    }
}
