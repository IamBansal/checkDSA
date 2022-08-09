package leetcode_arays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Question28 {

    /*

    Given a collection of candidate numbers (candidates) and a target number (target),
    find all unique combinations in candidates where the candidate numbers sum to target.

   Each number in candidates may only be used once in the combination.

   Note: The solution set must not contain duplicate combinations.

     */
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

    public static void main(String[] args) {
        int[] candidates = {2,5,2,1,2};
        combinationSum2(candidates, 5);
    }

}
