package college_labs.java_lab_5th_sem.week1;

import java.util.Scanner;

public class Program5 {

    public static void main(String[] args) {
        System.out.println("Enter the number of rows you want to have in triangle.");
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();

        drawTriangle(a);
    }

    public static void drawTriangle(int a) {

        for (int i = 0; i < a; i++) {
            for (int j = 0; j <= i; j++) {
                if (i == a - 1) {
                    System.out.print("*");
                } else {
                    if (j == 0 || i == j) {
                        System.out.print("*");
                    } else {
                        System.out.print(" ");
                    }
                }

            }
            System.out.println();
        }

    }
}
