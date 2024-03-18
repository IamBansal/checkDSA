package leetcode_problems.sheet_arsh.searching_sorting;

public class ProductArrayPuzzle {

    /*
    GFG problem
    Given an array nums[] of size n, construct a Product Array P (of same size n)
    such that P[i] is equal to the product of all the elements of nums except nums[i].
     */

    public static long[] productExceptSelf(int[] nums) {
        long product = 1;
        int count = 0;
        for (int e : nums) {
            if (e != 0) product *= e;
            else count++;
        }

        long[] res = new long[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) res[i] = count == 0 ? product / nums[i] : 0;
            else res[i] = count == 1 ? product : 0;
        }
        return res;
    }

    public static void main(String[] args) {
        productExceptSelf(new int[]{0, 1});
    }
}
