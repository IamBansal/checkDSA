package leetcode_arays;

public class Question5 {

    /*
    Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You must write an algorithm with O(log n) runtime complexity.
     */

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

    public static int[] selectionSort(int[] arr) {

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
        return arr;
    }
    public static int searchInsert(int[] nums, int target) {
        int index = binarySearch(nums, target);
        if (index >= 0){
            return index;
        } else {
            int[] arr = new int[nums.length + 1];
            System.arraycopy(nums, 0, arr, 0, nums.length);
            arr[nums.length] = target;
            return binarySearch(selectionSort(arr),target);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        System.out.println(searchInsert(nums, 2));
    }

}
