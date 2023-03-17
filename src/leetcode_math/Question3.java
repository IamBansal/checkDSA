package leetcode_math;

public class Question3 {

    /*
    2119. A Number After a Double Reversal
    Reversing an integer means to reverse all its digits.
    For example, reversing 2021 gives 1202. Reversing 12300 gives 321 as the leading zeros are not retained
    Given an integer num, reverse num to get reversed1, then reverse reversed1 to get reversed2.
    Return true if reversed2 equals num. Otherwise, return false.
     */

    public static boolean isSameAfterReversals(int num) {
        if (num == 0) return true;

        //Find last digit
        if (num % 10 == 0) return false;

        //Find first digit
        int digits = (int)(Math.log10(num));
        num = num / (int)(Math.pow(10, digits));

        return (num != 0);
    }

    public static void main(String[] args) {
        System.out.println(isSameAfterReversals(526));
        System.out.println(isSameAfterReversals(1800));
        System.out.println(isSameAfterReversals(0));
    }
}
