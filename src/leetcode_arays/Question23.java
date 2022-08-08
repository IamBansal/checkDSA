package leetcode_arays;

import java.util.Arrays;

public class Question23 {

    /*
    Given an integer array nums of length n and an integer target,
    find three integers in nums such that the sum is closest to target.

   Return the sum of the three integers.

    You may assume that each input would have exactly one solution.
     */

    public static int threeSumClosest(int[] nums, int target) {
        int close = Integer.MAX_VALUE;
        int result = 0;

        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (Math.abs(target - sum) < close) {
                    close = Math.abs(target - sum);
                    result = sum;
                } if (sum > target) k--;
                else j++;
                if (target == sum) return result;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 2, 1, -4};
        int[] nums1 = {833,736,953,-584,-448,207,128,-445,126,248,871,860,333,-899,463,488,-50,-331,903,575,265,162,-733,648,678,549,579,-172,-897,562,-503,-508,858,259,-347,-162,-505,-694,300,-40,-147,383,-221,-28,-699,36,-229,960,317,-585,879,406,2,409,-393,-934,67,71,-312,787,161,514,865,60,555,843,-725,-966,-352,862,821,803,-835,-635,476,-704,-78,393,212,767,-833,543,923,-993,274,-839,389,447,741,999,-87,599,-349,-515,-553,-14,-421,-294,-204,-713,497,168,337,-345,-948,145,625,901,34,-306,-546,-536,332,-467,-729,229,-170,-915,407,450,159,-385,163,-420,58,869,308,-494,367,-33,205,-823,-869,478,-238,-375,352,113,-741,-970,-990,802,-173,-977,464,-801,-408,-77,694,-58,-796,-599,-918,643,-651,-555,864,-274,534,211,-910,815,-102,24,-461,-146};
        System.out.println(threeSumClosest(nums, 1));
        System.out.println(threeSumClosest(nums1, -7111));
    }

}
