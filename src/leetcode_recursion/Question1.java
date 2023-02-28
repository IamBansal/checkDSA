package leetcode_recursion;

import java.util.Vector;

public class Question1 {

    //Print 1 to n
    public static void print1ton(int n){

        if (n == 1){
            System.out.print(n + " ");
            return;
        }

        print1ton(n -1);
        System.out.print(n + " ");

    }

    //Print n to 1
    public static void printNto1(int n){

        if (n == 1){
            System.out.print(n + " ");
            return;
        }

        System.out.print(n + " ");
        printNto1(n -1);
    }

    //factorial value
    public static int factorial(int n){
        if (n == 0 || n == 1){
            return n;
        }

        return n * factorial(n-1);

    }

    //Sort an array
    public static void sortArray(Vector<Integer> arr){

        if (arr.size() == 0 || arr.size() == 1){
            return;
        }

        int temp = arr.elementAt(arr.size() - 1);

        arr.removeElementAt(arr.size() - 1);
        sortArray(arr);
        insert(arr, temp);
        printVector(arr);

    }

    private static void insert(Vector<Integer> arr, int temp) {

        if (arr.size() == 0 || arr.elementAt(arr.size() - 1) <= temp){
            arr.addElement(temp);
            return;
        }

        int val = arr.elementAt(arr.size() - 1);

        arr.removeElementAt(arr.size() - 1);
        insert(arr, temp);
        arr.addElement(val);

    }

    public static void printVector(Vector<Integer> arr){
        for (Integer e: arr
             ) {
            System.out.print(e + " ");
        }
        System.out.println();
    }

    public static int fib(int n) {
        if(n == 0 || n == 1){
            return n;
        }

        return fib(n-1) + fib(n-2);

    }




    public static void main(String[] args) {

//        print1ton(7);
//        System.out.println();
//
//        printNto1(7);
//        System.out.println();
//
//        System.out.println(factorial(5));
//
//        Vector<Integer> input = new Vector<>();
//        input.add(3);
//        input.add(5);
//        input.add(6);
//        input.add(2);
//        input.add(1);
//        input.add(0);
//        sortArray(input);

        System.out.println(fib(3));
        System.out.println(fib(7));
        System.out.println(fib(5));

    }

}
