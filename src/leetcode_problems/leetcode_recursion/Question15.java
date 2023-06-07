package leetcode_problems.leetcode_recursion;

public class Question15 {

    public static long mod = 1000000007;

    public static int monkeyMove(int n) {

        return (int) ((mod + pow(2, n) - 2) % mod);

    }
    public static long pow(int x, int n) {
        //Divide and conquer approach.
        if (n == 1) return 2;

        long temp = pow(x, n / 2);

        if (n % 2 == 0) {
            return  ((temp * temp) % mod);
        } else {
            return  ((x * (temp * temp)) % mod);
        }
    }

    public static void main(String[] args) {
        System.out.println(monkeyMove(3));
        System.out.println(monkeyMove(4));
        System.out.println(monkeyMove(500000003));
        System.out.println(monkeyMove(6));

    }
}
