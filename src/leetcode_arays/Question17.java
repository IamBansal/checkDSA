package leetcode_arays;

import java.util.ArrayList;

public class Question17 {

    /*
    Given two integer arrays nums1 and nums2, return an array of their intersection.
    Each element in the result must be unique,and you may return the result in any order.
     */

    public static void intersection(int[] nums1, int[] nums2) {
        ArrayList<Integer> check = new ArrayList<>();
        ArrayList<Integer> check2 = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();
        check = removeDuplicates(nums1);
        check2 = removeDuplicates(nums2);

        for (Integer e:check2
             ) {
            if (check.contains(e)){
                result.add(e);
            }
        }
        int[] results = new int[result.size()];
        for (int i = 0; i < results.length; i++){
            results[i] = result.get(i);
        }

         for (Integer e:result
             ) {
             System.out.print(e + " ");
        }
        System.out.println();

    }

    public static ArrayList<Integer> removeDuplicates(int[] arr){
        int l = 1;
        for (int i = 0; i < arr.length -1; i++){
            if (arr[i] != arr[i + 1]){
                arr[l] = arr[i + 1];
                l++;
            }
        }

        ArrayList<Integer> check = new ArrayList<>();
        for (int e: arr
        ) {
            if (!check.contains(e)){
                check.add(e);
            }
        }
        return check;
    }

    public static void main(String[] args) {
        int[] nums1 = {4,7,9,7,6,7};
        int[] nums2 = {5,0,0,6,1,6,2,2,4};
        int[] nums3 = {9,4,9,8,4};
        int[] nums4 = {4,9,5};
        intersection(nums1, nums2);
        intersection(nums4, nums3);
    }

}
