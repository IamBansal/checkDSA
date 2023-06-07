package leetcode_problems.leetcode_dynamic_programming;

public class Question5 {

   /*
   1137. N-th Tribonacci Number
   The Tribonacci sequence Tn is defined as follows:
   T0 = 0, T1 = 1, T2 = 1, and Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0.
   Given n, return the value of Tn.

    */

    public static int tribonacci(int n) {
        if (n <= 1) return n;
        if (n == 2) return 1;

        int prev = 1;
        int pre2 = 1;
        int pre3 = 0;

        for (int i = 3; i <= n; i++){
            int curr = prev + pre2 + pre3;
            pre3 = pre2;
            pre2 = prev;
            prev = curr;
        }
        return prev;
    }

    public static void main(String[] args) {
        System.out.println(tribonacci(4));
        System.out.println(tribonacci(25));
    }
}
