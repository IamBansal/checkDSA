package leetcode_arays;

public class Question7 {

/*
You are given two integer arrays nums1 and nums2, sorted in non-decreasing order,
 and two integers m and n, representing the number of elements in nums1 and nums2 respectively.

Merge nums1 and nums2 into a single array sorted in non-decreasing order.

The final sorted array should not be returned by the function, but instead be stored inside the array nums1.
 To accommodate this, nums1 has a length of m + n,
 where the first m elements denote the elements that should be merged,
 and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
 */

    public static void merge(int[] arr1, int[] arr2, int m, int n) {

        int i = 0;
        int j = 0;
        int k = 0;

        int[] ans = new int[m + n];

        while (i < m && j < n) {
            if (arr1[i] < arr2[j]) {
                ans[k] = arr1[i];
                i++;
            } else {
                ans[k] = arr2[j];
                j++;
            }
            k++;
        }
        while (i < m) {
            ans[k] = arr1[i];
            k++;
            i++;
        }
        while (j < n) {
            ans[k] = arr2[j];
            k++;
            j++;
        }

        System.arraycopy(ans, 0, arr1, 0, ans.length);

    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;

        merge(nums1, nums2, m, n);

    }
}
