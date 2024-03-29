package leetcode_problems.leetcode_arays;

import java.util.ArrayList;

public class Question3 {

    /*
    Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same.

Since it is impossible to change the length of the array in some languages, you must instead have the result be placed in the first part of the array nums. More formally, if there are k elements after removing the duplicates, then the first k elements of nums should hold the final result. It does not matter what you leave beyond the first k elements.

Return k after placing the final result in the first k slots of nums.

Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.

     */


    public static int removeDuplicates(int[] arr){
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

//        for (int e:check
//             ) {
//            System.out.print(e + " ");
//        }

        return check.size();
    }

    public static void main(String[] args) {
        int[] grades = {2,2,4,5};
        int[] grades1 = {3,2,4,4,4,4,5,6,7,2,3};

        removeDuplicates(grades);
        System.out.println();
        System.out.println(removeDuplicates(grades1));
    }

}
