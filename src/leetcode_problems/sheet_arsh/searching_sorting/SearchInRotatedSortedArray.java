package leetcode_problems.sheet_arsh.searching_sorting;

public class SearchInRotatedSortedArray {

    /*
    33. Search in Rotated Sorted Array
    
    There is an integer array nums sorted in ascending order (with distinct values).
    Prior to being passed to your function, nums is possibly rotated at an unknown
    pivot index k (1 <= k < nums.length) such that the resulting array is
    [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed).
    For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
    Given the array nums after the possible rotation and an integer target,
    return the index of target if it is in nums, or -1 if it is not in nums.

    You must write an algorithm with O(log n) runtime complexity.
     */

    public static int search(int[] nums, int target) {
        return findElementInner(nums, 0, nums.length - 1, target);
    }

    private static int findElementInner(int[] nums, int start, int end, int target) {
        if (start < 0 || end >= nums.length) return -1;

        if (start == end) return nums[start] == target ? start : -1;
        int mid = (start + end) / 2;

        int left = findElementInner(nums, start, mid, target);
        int right = findElementInner(nums, mid + 1, end, target);
        return Math.max(left, right);
    }

    public static void main(String[] args) {
        System.out.println(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
        System.out.println(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));
    }
}
