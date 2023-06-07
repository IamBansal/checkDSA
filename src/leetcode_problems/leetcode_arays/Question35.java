package leetcode_problems.leetcode_arays;

import java.util.ArrayList;
import java.util.HashMap;

public class Question35 {

    public static int removeDuplicates(int[] nums) {

        ArrayList<Integer> result = new ArrayList<>();
        HashMap<Integer, Boolean> check = new HashMap<>();
        for (Integer e : nums) {
            check.put(e, false);
        }

        for (Integer e : nums) {
            if (!check.get(e)){
                if (result.contains(e)){
                    result.add(e);
                    check.replace(e, false, true);
                } else {
                    result.add(e);
                }
            }
        }

        for (int i = 0; i < result.size(); i++){
            nums[i] = result.get(i);
        }

        for (Integer e:nums
        ) {
            System.out.print(e + " ");
        }
        System.out.println();

        return result.size();

    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        System.out.println(removeDuplicates(nums));
    }
}
