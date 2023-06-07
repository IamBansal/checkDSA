package leetcode_problems.leetcode_recursion;

public class Question3 {

    public static boolean isPowerOfTwo(int n) {
        if (n == 1) {
            return true;
        } else if (n % 2 != 0 || n <= 0) {
            return false;
        }

        return isPowerOfTwo(n / 2);
    }

    public static boolean isPowerOfFour(int n) {
        if (n == 1) {
            return true;
        } else if (n % 4 != 0 || n <= 0) {
            return false;
        }

        return isPowerOfFour(n / 4);
    }

    public static boolean isPowerOfThree(int n) {
        if (n == 1) {
            return true;
        } else if (n % 3 != 0 || n <= 0) {
            return false;
        }

        return isPowerOfThree(n / 3);
    }

    public static void main(String[] args) {
//        System.out.println(isPowerOfTwo(0));
//        System.out.println(isPowerOfTwo(3));
//        System.out.println(isPowerOfTwo(16));

//        System.out.println(isPowerOfThree(0));
//        System.out.println(isPowerOfThree(1));
//        System.out.println(isPowerOfThree(-3));
//        System.out.println(isPowerOfThree(27));
//        System.out.println(isPowerOfThree(21));

        System.out.println(isPowerOfFour(-4));
        System.out.println(isPowerOfFour(4));
        System.out.println(isPowerOfFour(64));
        System.out.println(isPowerOfFour(21));
        System.out.println(isPowerOfFour(24));

    }

}
