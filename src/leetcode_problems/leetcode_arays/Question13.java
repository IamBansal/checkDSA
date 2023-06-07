package leetcode_problems.leetcode_arays;

import java.util.ArrayList;

public class Question13 {

    /*
    You are given a sorted unique integer array nums.

A range [a,b] is the set of all integers from a to b (inclusive).

Return the smallest sorted list of ranges that cover all the numbers in the array exactly.
That is, each element of nums is covered by exactly one of the ranges,
and there is no integer x such that x is in one of the ranges but not in nums.

Each range [a,b] in the list should be output as:

"a->b" if a != b
"a" if a == b
     */

    public static void summaryRanges(int[] nums) {
        ArrayList<String> result = new ArrayList<>();
        ArrayList<Integer> check = new ArrayList<>();

        for (Integer e : nums
        ) {
            check.add(e);
        }
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i + 1 == check.size()) {
                if (count == 0) {
                    int val1 = check.get(i);
                    result.add(String.valueOf(val1));
                } else {
                    String val1 = String.valueOf(check.get(i - count));
                    String val2 = String.valueOf(check.get(count));
                    result.add(val1 + "->" + val2);
                }
                break;
            } else {
                if (check.get(i) + 1 != check.get(i + 1)) {
                    if (count == 0) {
                        int val1 = check.get(0);
                        result.add(String.valueOf(val1));
                        check.remove(0);
                        i = i - 1;
                    } else {
                        String val1 = String.valueOf(check.get(i - count));
                        String val2 = String.valueOf(check.get(count));
                        result.add(val1 + "->" + val2);

                        while (count >= 0) {
                            check.remove(check.get(0));
                            count--;
                        }
                        i = -1;
                        count = 0;
                    }

                } else {
                    count++;
                }
            }
        }
        for (String e : result
        ) {
            System.out.print(e + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 4, 5, 7};
        int[] nums2 = {0, 2, 3, 4, 6, 8, 9};
        summaryRanges(nums);
        summaryRanges(nums2);

    }
}
