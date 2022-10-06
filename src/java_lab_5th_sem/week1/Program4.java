package java_lab_5th_sem.week1;

import java.util.Scanner;

public class Program4 {

    public static void main(String[] args) {
        System.out.println("Enter the numbers you want to add.");
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        System.out.print("Sum is : " + addition(a, b));
    }

    public static int addition(int a, int b) {
        return a + b;
    }

}
