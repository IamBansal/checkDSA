package leetcode_problems.leetcode_arays;

public class Question6 {

    /*
    You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer. The digits are ordered from most significant to least significant in left-to-right order. The large integer does not contain any leading 0's.

Increment the large integer by one and return the resulting array of digits.
     */

    public static void printArray(int[] arr) {
        System.out.println();
        for (int j : arr) {
            System.out.print(j + " ");
        }
        System.out.println();
    }

    public static int[] plusOne(int[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == 9) {
                arr[i] = 0;
                if (i == 0) {
                    int[] newArray = new int[arr.length + 1];
                    newArray[0] = 1;
                    System.arraycopy(arr, 0, newArray, 1, newArray.length - 1);
                    return newArray;
                }
            } else {
                arr[i]++;
                break;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] digits = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        int[] digits1 = {9, 9, 9, 9};
        int[] digits2 = {8, 9, 9, 9};
        int[] digits3 = {9, 8, 9};
        int[] digits4 = {1, 2, 3};
        int[] digits5 = {0};
        int[] digits6 = {8, 8, 5, 0, 5, 1, 9, 7};
        printArray(plusOne(digits));
        printArray(plusOne(digits1));
        printArray(plusOne(digits2));
        printArray(plusOne(digits3));
        printArray(plusOne(digits4));
        printArray(plusOne(digits5));
        printArray(plusOne(digits6));
    }
}
