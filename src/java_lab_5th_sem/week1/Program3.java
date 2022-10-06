package java_lab_5th_sem.week1;

import java.util.Scanner;

public class Program3 {

    public static void fibonacci(int n) {

        int[] result = new int[n];
        result[0] = 0;
        result[1] = 1;
        for (int i = 2; i < n; i++) {
            result[i] = result[i - 1] + result[i - 2];
        }

        for (int e : result) {
            System.out.print(e + " ");
        }
        System.out.println();

    }

    public static int fibRec(int n) {
        if (n <= 1) {
            return n;
        }

        return fibRec(n - 1) + fibRec(n - 2);
    }

    public static void main(String[] args) {
        System.out.println("Enter the number of elements.");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.print("Series is : ");
        fibonacci(n);

        System.out.print("Series is (recursion): ");
        for (int i = 0; i < n; i++) {
            System.out.print(fibRec(i) + " ");
        }

    }

}
