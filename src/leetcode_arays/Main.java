package leetcode_arays;

import java.util.Scanner;

public class Main {

    public static int binarySearch(int[] arr, int n) {

        if (arr[0] < arr[arr.length - 1] && (n > arr[arr.length - 1] || n < arr[0])) {
            return -1;
        }

        int startIndex = 0;
        int endIndex = arr.length - 1;
        while (startIndex <= endIndex) {
            int mid = (startIndex + endIndex) / 2;
            if (arr[mid] == n) {
                return mid;
            } else if (arr[mid] > n) {
                endIndex = mid - 1;
            } else {
                startIndex = mid + 1;
            }
        }
        return -1;
    }

    public static void selectionSort(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {
            int min = arr[i];
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
        }

        for (int j : arr) {
            System.out.print(j + " ");
        }

    }

    public static void bubbleSort(int[] input) {
        for (int i = 0; i < input.length - 1; i++) {
            for (int j = 0; j < input.length - i - 1; j++) {
                if (input[j] > input[j + 1]) {
                    int temp = input[j];
                    input[j] = input[j + 1];
                    input[j + 1] = temp;
                }
            }
        }
        for (int e : input) {
            System.out.print(e + " ");
        }
    }

    public static void insertionSort(int[] input) {

        for (int i = 0; i < input.length; i++) {
            int j = i - 1;
            int temp = input[i];
            while (j >= 0 && input[j] > temp) {
                input[j + 1] = input[j];
                j--;
            }
            input[j + 1] = temp;
        }
        for (int j : input) {
            System.out.print(j + " ");
        }

    }

    public static void mergeTwoSortedArrays(int[] arr1, int[] arr2) {

        int i = 0;
        int j = 0;
        int k = 0;

        int[] ans = new int[arr1.length + arr2.length];

        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                ans[k] = arr1[i];
                i++;
            } else {
                ans[k] = arr2[j];
                j++;
            }
            k++;
        }
        while (i < arr1.length) {
            ans[k] = arr1[i];
            k++;
            i++;
        }
        while (j < arr2.length) {
            ans[k] = arr2[j];
            k++;
            j++;
        }

        for (int e : ans) {
            System.out.print(e + " ");
        }

    }

    public static void main(String[] args) {

        int[] arr = {6, 7, 8, 9, 10};
        int[] arr2 = {1, 2, 3, 4, 11, 52, 65, 77, 8, 9, 10};
        int[] arr3 = {1, 2, 3, 4, 5};
        System.out.println(binarySearch(arr, 10));
        selectionSort(arr2);
        System.out.println("");
        bubbleSort(arr2);
        System.out.println("");
        insertionSort(arr2);
        System.out.println();
        mergeTwoSortedArrays(arr, arr3);

    }
}