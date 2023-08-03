package leetcode_problems.sheet_arsh.stacks_queues;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElement1 {

    /*
    496. Next Greater Element I
    The next greater element of some element x in an array is the
    first greater element that is to the right of x in the same array.
    You are given two distinct 0-indexed integer arrays nums1 and nums2,
    where nums1 is a subset of nums2.
    For each 0 <= i < nums1.length, find the index j such that nums1[i] == nums2[j]
    and determine the next greater element of nums2[j] in nums2.
    If there is no next greater element, then the answer for this query is -1.
    Return an array ans of length nums1.length such that ans[i] is the next greater element
    as described above.
     */

    //This solution is not using stacks or queues
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {

        int[] result = new int[nums1.length];
        Arrays.fill(result, -1);

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            map.put(nums2[i], i);
        }
        System.out.println(map);

        for (int i = 0; i < nums1.length; i++) {
            System.out.println(map.get(nums1[i]));

            for (int j = map.get(nums1[i]) + 1; j < nums2.length; j++) {
                if (nums2[j] > nums1[i]) {
                    result[i] = nums2[j];
                    break;
                }
            }
        }

        return result;
    }

    //Using stack
    public static int[] nextGreaterElementUsingStack(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>(); // map from x to next greater element of x
        Stack<Integer> stack = new Stack<>();
        for (int num : nums2) {
            while (!stack.isEmpty() && stack.peek() < num) map.put(stack.pop(), num);
            stack.push(num);
        }
        for (int i = 0; i < nums1.length; i++) nums1[i] = map.getOrDefault(nums1[i], -1);
        return nums1;
    }

    public static void main(String[] args) {
        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};
//        int[] result = nextGreaterElement(nums1, nums2);
        int[] result = nextGreaterElementUsingStack(nums1, nums2);

        for (int num : result) System.out.print(num + " ");
        System.out.println();
    }
}
