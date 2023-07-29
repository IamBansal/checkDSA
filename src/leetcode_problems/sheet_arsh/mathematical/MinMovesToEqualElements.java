package leetcode_problems.sheet_arsh.mathematical;

public class MinMovesToEqualElements {

    /*
    453. Minimum Moves to Equal Array Elements
    Given an integer array nums of size n,
    return the minimum number of moves required to make all array elements equal.
    In one move, you can increment n - 1 elements of the array by 1.
     */

    //This solution gives TLE
    public static int minMoves(int[] nums) {
        if (nums.length == 1) return 0;

        int max = nums[0], min = nums[0], j = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
                j = i;
            } else if (nums[i] < min) min = nums[i];
        }

        int diff = max - min;
        if (diff == 0) return 0;
        for (int i = 0; i < nums.length; i++) {
            if (i != j) nums[i] += diff;
        }

        return diff + minMoves(nums);
    }

    //Subtracting 1 from n - 1 elements is same as subtracting 1 from bigger one element only
    public static int minMovesBetter(int[] nums) {
        if (nums.length == 1) return 0;
        int min = nums[0];
        for (int n : nums) min = Math.min(min, n);
        int res = 0;
        for (int n : nums) res += n - min;
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(minMoves(nums));
        System.out.println(minMovesBetter(nums));
        int[] nums1 = {5, 6, 8, 8, 5};
        System.out.println(minMoves(nums1));
        System.out.println(minMovesBetter(nums1));
    }
}