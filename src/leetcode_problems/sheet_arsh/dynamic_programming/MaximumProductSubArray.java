package leetcode_problems.sheet_arsh.dynamic_programming;

public class MaximumProductSubArray {

    /*
    152. Maximum Product SubArray
    Given an integer array nums, find a subArray that has the largest product, and return the product.
    The test cases are generated so that the answer will fit in a 32-bit integer.
     */

    public static int maxProduct(int[] nums){
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++){
            int product = nums[i];
            max = Math.max(max, product);
            for (int j = i + 1; j < nums.length; j++){
                product *= nums[j];
                max = Math.max(max, product);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxProduct(new int[]{2, 3, -2, 4}));
        System.out.println(maxProduct(new int[]{-2, 0, -1}));
        System.out.println(maxProduct(new int[]{-3, -1, -1}));
        System.out.println(maxProduct(new int[]{0, 2}));
        System.out.println(maxProduct(new int[]{3, 0, 1, -2}));
    }
}
