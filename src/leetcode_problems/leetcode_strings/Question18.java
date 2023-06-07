package leetcode_problems.leetcode_strings;

import java.math.BigInteger;

public class Question18 {

    /*
    Given two non-negative integers, num1 and num2 represented as string,
    return the sum of num1 and num2 as a string.

     You must solve the problem without using any built-in library for handling large integers (such as BigInteger).
     You must also not convert the inputs to integers directly.
     */

    public static String addStrings(String num1, String num2) {
        BigInteger number1 = new BigInteger(num1);
        BigInteger number2 = new BigInteger(num2);
        return String.valueOf(number1.add(number2));
    }

    public static String addStringsLogical(String num1, String num2) {
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;
        StringBuilder ans = new StringBuilder();
        while (i >= 0 || j >= 0 || carry != 0) {
            int val1 = i >= 0 ? num1.charAt(i) - '0' : 0;
            int val2 = j >= 0 ? num2.charAt(j) - '0' : 0;
            i--;
            j--;
            int sum = val1 + val2 + carry;
            carry = sum / 10;
            ans.append(sum % 10);
        }
        return ans.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(addStringsLogical("11", "123"));
        System.out.println(addStringsLogical("456", "77"));
        System.out.println(addStringsLogical("0", "0"));
        System.out.println(addStringsLogical("3876620623801494171", "6529364523802684779"));
    }
}
