package leetcode_arays;

public class Question34 {

    /*
    Write an efficient algorithm that searches for a value target in an m x n integer matrix.
    This matrix has the following properties:

     - Integers in each row are sorted from left to right.
     - The first integer of each row is greater than the last integer of the previous row.

     */

    public static boolean binarySearch(int[] arr, int n) {

        if (arr[0] < arr[arr.length - 1] && (n > arr[arr.length - 1] || n < arr[0])) {
            return false;
        }

        int startIndex = 0;
        int endIndex = arr.length - 1;
        while (startIndex <= endIndex) {
            int mid = (startIndex + endIndex) / 2;
            if (arr[mid] == n) {
                return true;
            } else if (arr[mid] > n) {
                endIndex = mid - 1;
            } else {
                startIndex = mid + 1;
            }
        }
        return false;
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int[] result = new int[matrix.length * matrix[0].length];

        int index = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                result[index] = matrix[i][j];
                index++;
            }
        }

        return binarySearch(result, target);
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        System.out.println(searchMatrix(matrix, 3));
        System.out.println(searchMatrix(matrix, 9));
    }
}
