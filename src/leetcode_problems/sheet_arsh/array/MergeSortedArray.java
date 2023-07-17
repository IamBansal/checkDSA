package leetcode_problems.sheet_arsh.array;

public class MergeSortedArray {

    /*
    88. Merge Sorted Array
    You are given two integer arrays nums1 and nums2, sorted in non-decreasing order,
    and two integers m and n, representing the number of elements in nums1 and nums2 respectively.

    Merge nums1 and nums2 into a single array sorted in non-decreasing order.
    The final sorted array should not be returned by the function, but instead be stored inside the array nums1.
    To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements
    that should be merged, and the last n elements are set to 0 and should be ignored.
    nums2 has a length of n.
     */

    public static void merge(int[] arr1, int m, int[] arr2, int n) {

//        int i = 0;
//        int j = 0;
//        int k = 0;
//
//        int[] ans = new int[m + n];
//
//        while (i < m && j < arr2.length) {
//            if (arr1[i] < arr2[j]) {
//                ans[k] = arr1[i];
//                i++;
//            } else {
//                ans[k] = arr2[j];
//                j++;
//            }
//            k++;
//        }
//        while (i < m) {
//            ans[k] = arr1[i];
//            k++;
//            i++;
//        }
//        while (j < arr2.length) {
//            ans[k] = arr2[j];
//            k++;
//            j++;
//        }
//
//        System.arraycopy(ans, 0, arr1, 0, ans.length);

        int[] tempArr1 = new int[m];
        System.arraycopy(arr1, 0, tempArr1, 0, m);

        int i = 0, j = 0, index = 0;
        while (i < m && j < n){
            if (tempArr1[i] <= arr2[j]) {
                arr1[index] = tempArr1[i];
                i++;
            } else {
                arr1[index] = arr2[j];
                j++;
            }
            index++;
        }
        if (i < m) {
            for (;i < m; i++){
                arr1[index] = tempArr1[i];
                index++;
            }
        }
        if (j < n){
            for (;j < n; j++){
                arr1[index] = arr2[j];
                index++;
            }
        }

//        for (int num: arr1) System.out.print(num + " ");
//        System.out.println();

    }

    public static void main(String[] args) {
        int[] arr1 = {1,2,3,0,0,0};
        int[] arr2 = {2,3,6};
        merge(arr1, 3, arr2, 3);
    }
}
