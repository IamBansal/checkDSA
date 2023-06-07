package leetcode_problems.leetcode_arays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Question27 {

    /*

    Given an array of non-negative integers nums,
    you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

You can assume that you can always reach the last index.
     */


    // INCOMPLETE

    public static void combinationSum(int idx, List<Integer> ds, List<List<Integer>> ans, int target, int[] arr) {
        if (target == 0) {
            ans.add(new ArrayList<>(ds));
            return;
        }

        for (int i = idx; i < arr.length; i++) {
            if (i > idx && arr[i] == arr[i - 1])
                continue;
            if (target < arr[i])
                break;

            ds.add(arr[i]);
            combinationSum(i + 1, ds, ans, target - arr[i], arr);
            ds.remove(ds.size() - 1);
        }

    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);

        List<Integer> ds = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();

        combinationSum(0, ds, ans, target, candidates);

        return ans;
    }

    public static int jump(int[] nums) {
        List<List<Integer>> ans;
        ans = combinationSum2(nums, nums.length);

        int jump = Integer.MAX_VALUE;

        if (ans.isEmpty()){
            jump = 0;
        }
        for (List<Integer> list : ans) {
            jump = Math.min(jump, list.size());
        }

        return jump;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(jump(nums));
    }
}
