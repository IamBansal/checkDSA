package leetcode_arays;

import java.util.ArrayList;

public class Question4 {

    /*
    Given an integer array nums and an integer val, remove all occurrences of val in nums in-place. The relative order of the elements may be changed.

Since it is impossible to change the length of the array in some languages, you must instead have the result be placed in the first part of the array nums. More formally, if there are k elements after removing the duplicates, then the first k elements of nums should hold the final result. It does not matter what you leave beyond the first k elements.

Return k after placing the final result in the first k slots of nums.
     */


    public static int removeElement(int[] arr, int val) {

        ArrayList<Integer> check = new ArrayList<>();
        for (int e: arr
        ) {
            if (e != val){
                check.add(e);
            }
        }

        System.out.println("List size : " + check.size());

        int l = 0;
        for (int i = 0; i < arr.length; i++){
            if (arr[i] != val){
                arr[l] = arr[i];
                l++;
                if (l == check.size()){
                    break;
                }
            }
        }

        System.out.print("Array : ");
        for (int e: arr
             ) {
            System.out.print(e + " ");
        }
        System.out.println();
        return check.size();
    }

    public static void main(String[] args) {
        int[] nums = {4,5};
        int[] nums2 = {3,2,2,3};
        System.out.println();
        System.out.println("Elements : " + removeElement(nums, 4));
        System.out.println(removeElement(nums2, 3));
    }
}
