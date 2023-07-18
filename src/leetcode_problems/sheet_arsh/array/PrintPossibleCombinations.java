package leetcode_problems.sheet_arsh.array;

public class PrintPossibleCombinations {

    /*
    -> GFG problem
    Print all possible combinations of r elements in a given array of size n
    Given an array of size n, generate and print all possible combinations of r elements in array.

    For example, if input array is {1, 2, 3, 4} and r is 2,
    then output should be {1, 2}, {1, 3}, {1, 4}, {2, 3}, {2, 4} and {3, 4}.
     */

    public static void printCombination(int[] arr, int n, int r) {
        helper(arr, 0, n - r, r, new int[r], 0);
    }

    private static void helper(int[] arr, int start, int end, int r, int[] data, int index) {

        if (index == r - 1) {
            for (int i = start; i <= end; i++) {
                data[index] = arr[i];
                //For printing the result
                for (int num : data) System.out.print(num + " ");
                System.out.println();
            }
            return;
        }

        for (int i = start; i <= end; i++) {
            data[index] = arr[i];
            helper(arr, i + 1, end + 1, r, data, index + 1);
        }

    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int[] arr1 = {1, 2, 3, 4};
        printCombination(arr, arr.length, 3);
        printCombination(arr1, arr1.length, 2);
    }
}
