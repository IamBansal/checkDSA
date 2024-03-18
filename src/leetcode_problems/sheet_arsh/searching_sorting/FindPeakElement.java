package leetcode_problems.sheet_arsh.searching_sorting;

public class FindPeakElement {

    /*
    162. Find Peak Element
    A peak element is an element that is strictly greater than its neighbors.
    Given a 0-indexed integer array nums, find a peak element, and return its index.
    If the array contains multiple peaks, return the index to any of the peaks.
    You may imagine that nums[-1] = nums[n] = -∞. In other words,
    an element is always considered to be strictly greater than a neighbor that is outside the array.

    You must write an algorithm that runs in O(log n) time.
     */

    public static int findPeakElement(int[] nums) {
        if (nums.length == 1) return 0;
        return findPeakElementInner(nums, 0, nums.length - 1);
    }

    private static int findPeakElementInner(int[] nums, int start, int end) {
        if (start < 0 || end >= nums.length) return -1;

        if (start == end) {
            if (start == 0) return nums[0] > nums[1] ? 0 : -1;
            if (start == nums.length - 1) return nums[nums.length - 1] > nums[nums.length - 2] ? nums.length - 1 : -1;
            else return (nums[start] > nums[start - 1] && nums[end] > nums[end + 1]) ? start : -1;
        }

        int mid = (start + end) / 2;

        int left = findPeakElementInner(nums, start, mid);
        int right = findPeakElementInner(nums, mid + 1, end);
        return Math.max(left, right);
    }

    public static void main(String[] args) {
        System.out.println(findPeakElement(new int[]{1}));
        System.out.println(findPeakElement(new int[]{1, 2}));
        System.out.println(findPeakElement(new int[]{1, 2, 3, 1}));
        System.out.println(findPeakElement(new int[]{1, 2, 1, 3, 5, 6, 4}));
    }
}
