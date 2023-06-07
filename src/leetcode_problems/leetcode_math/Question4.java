package leetcode_problems.leetcode_math;

public class Question4 {

    /*
    258. Add Digits
    Given an integer num, repeatedly add all its digits until the result has only one digit, and return it.
     */

    public static int addDigits(int num) {
        if (num / 10 == 0) return num;

        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }

        return addDigits(sum);

    }

    public static int addDigitsBetter(int num) {
        return num == 0 ? 0 : num % 9 == 0 ? 9 : num % 9;
    }

    public static void main(String[] args) {
        System.out.println(addDigits(38));
        System.out.println(addDigits(3));
        System.out.println(addDigits(0));
        System.out.println(addDigits(4567));
        System.out.println();
        System.out.println(addDigitsBetter(38));
        System.out.println(addDigitsBetter(3));
        System.out.println(addDigitsBetter(0));
        System.out.println(addDigitsBetter(4567));
    }
}
