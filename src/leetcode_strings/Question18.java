package leetcode_strings;

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

    public static void main(String[] args) {
        System.out.println(addStrings("11", "123"));
        System.out.println(addStrings("456", "77"));
        System.out.println(addStrings("0", "0"));
        System.out.println(addStrings("3876620623801494171", "6529364523802684779"));
    }
}
