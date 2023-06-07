package leetcode_problems.leetcode_recursion;

public class Question6 {

    /*
    Implement pow(x, n), which calculates x raised to the power n (i.e., xn).
     */

    public static double myPow(double x, int n) {

        //  This is because any number raised to max. or min. value of integer,
        //  gives infinity as answer (and that will give stackoverflow error)

        if (n == Integer.MAX_VALUE) return (x == 1) ? 1 : (x == -1) ? -1 : 0;
        if (n == Integer.MIN_VALUE) return (x == 1 || x == -1) ? 1 : 0;

        double result;
        if (n < 0) {
            n = -n;
            result = 1 / pow(x, n);
        } else {
            result = pow(x, n);
        }

        return result;
    }

    public static double pow(double x, int n) {

        if (n == 0) {
            return 1;
        }

        return x * pow(x, n - 1);
    }

    public static void main(String[] args) {
        System.out.println(myPow(-1, Integer.MAX_VALUE));
    }

}
