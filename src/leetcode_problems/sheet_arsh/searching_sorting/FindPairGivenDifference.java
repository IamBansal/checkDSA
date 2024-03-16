package leetcode_problems.sheet_arsh.searching_sorting;

import java.util.Arrays;
import java.util.HashSet;

public class FindPairGivenDifference {

    /*

    GFG Problem

    Given an array Arr[] of size L and a number N, you need to write a program to find
    if there exists a pair of elements in the array whose difference is N.
     */

    public static boolean findPair(int[] arr, int size, int n){
         Arrays.sort(arr);
         int i =0, j = 1;
         while (i<size && j<size){
             if (i != j && arr[j]-arr[i] == n) return true;
             else if (arr[j]-arr[i] < n) j++;
             else i++;
              if (i == j) j++;
         }
         return false;
    }

    public static boolean findPairBetter(int[] array, int size, int n){
        HashSet<Integer> set = new HashSet<>();
        for(int e: array){
            if(set.contains(n + e) || set.contains(n - e) || set.contains(e - n)) return true;
            else set.add(e);
        }
        return false;
    }


    public static void main(String[] args) {
        System.out.println(findPair(new int[]{5, 20, 3, 2, 5, 80}, 6, 78));
        System.out.println(findPairBetter(new int[]{5, 20, 3, 2, 5, 80}, 6, 78));
    }
}
