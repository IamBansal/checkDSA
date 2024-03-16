package leetcode_problems.sheet_arsh.searching_sorting;

public class CeilingInSortedArray {

    /*
    GFG Problem
    Given a sorted array and a value x, the ceiling of x is the smallest element in an array
    greater than or equal to x, and the floor is the greatest element smaller than or equal to x.
    Assume that the array is sorted in non-decreasing order.
    Write efficient functions to find the floor and ceiling of x.
     */

    public static int findCeiling(int[] array, int x) {
        return ceilSearch(array, 0, array.length - 1, x);
    }

    public static int ceilSearch(int[] array, int low, int high, int x) {

        if (x <= array[low]) return array[low];
        if (x > array[high]) return -1;

        int mid = (low + high) / 2;
        if (array[mid] == x) return x;

        else if (array[mid] < x) {
            if (mid + 1 <= high && x <= array[mid + 1])
                return mid + 1;
            else
                return ceilSearch(array, mid + 1, high, x);
        } else {
            if (mid - 1 >= low && x > array[mid - 1])
                return mid;
            else
                return ceilSearch(array, low, mid - 1, x);
        }

    }

    public static void main(String[] args) {
        System.out.println(findCeiling(new int[]{1,2,8,10,10,12,19}, 3));
    }
}
