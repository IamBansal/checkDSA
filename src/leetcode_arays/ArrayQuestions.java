package leetcode_arays;

public class ArrayQuestions {

    /*
    You are given a non-negative integer array nums. In one operation, you must:

       Choose a positive integer x such that x is less than or equal to the smallest non-zero element in nums.
       Subtract x from every positive element in nums.
       Return the minimum number of operations to make every element in nums equal to 0.

     */

    public static int minOperations(int[] arr) {
        if (checkPegs(arr)) {
            return 0;
        }
        return minOperationsHelper(arr, 0);
    }

    public static boolean checkPegs(int arr[]) {
        for (int j : arr) {
            if (j != 0) {
                return false;
            }
        }
        return true;
    }

    public static int minOperationsHelper(int[] arr, int count) {

        if (checkPegs(arr)) {
            return count;
        }

        count++;
        int min = Integer.MAX_VALUE;
        for (int j : arr) {
            if (j != 0 && j < min) {
                min = j;
            }
        }
        System.out.println("min : " + min);
        System.out.println("count : " + count);

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                arr[i] = arr[i] - min;
            }
        }
        return minOperationsHelper(arr, count);

    }

    public static void main(String[] args) {
        int[] arr = {1, 5, 0, 3, 5};
        int[] arr2 = {1};
        System.out.println(minOperations(arr2));
    }

}
