package leetcode_problems.sheet_arsh.greedy;

import java.util.Hashtable;

public class RestoreArrayFromAdjacentPairs {

    /*
    1743. Restore the Array From Adjacent Pairs
    There is an integer array nums that consists of n unique elements, but you have forgotten it.
    However, you do remember every pair of adjacent elements in nums.
    You are given a 2D integer array adjacentPairs of size n - 1 where each adjacentPairs[i] = [ui, vi]
    indicates that the elements ui and vi are adjacent in nums.
    It is guaranteed that every adjacent pair of elements nums[i] and nums[i+1]
     will exist in adjacentPairs, either as [nums[i], nums[i+1]] or [nums[i+1], nums[i]].
     The pairs can appear in any order.

     Return the original array nums. If there are multiple solutions, return any of them.
     */

    public static int[] restoreArray(int[][] adjacentPairs) {
        int[] result = new int[adjacentPairs.length * 2];
        Hashtable<Integer, Integer> map = new Hashtable<>();
        for (int[] arr: adjacentPairs){
            for (int i : arr) map.put(i, map.getOrDefault(i, 0));
        }

//        result[0] = map.get

        return result;
    }

    public static void main(String[] args) {

    }
}
