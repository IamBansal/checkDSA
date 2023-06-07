package leetcode_problems.leetcode_strings;

public class Question6 {

    /*

Given two binary strings a and b, return their sum as a binary string.
     */
    public static String addBinary(String a, String b) {

        int len = Math.max(a.length(), b.length());
        int temp, carry = 0;
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < len; i++) {
            int p = (i < a.length()) ? (a.charAt(a.length() - i - 1) - '0') : 0;
            int q = (i < b.length()) ? (b.charAt(b.length() - i - 1) - '0') : 0;

            temp = p + q + carry;
            carry = temp / 2;
            res.insert(0, temp % 2);
        }

        return (carry == 0) ? res.toString() : "1" + res;
    }

    public static void main(String[] args) {
        System.out.println(addBinary("1010", "1011"));
        System.out.println(addBinary("11", "1"));
        System.out.println(addBinary("0", "0"));
    }
}
