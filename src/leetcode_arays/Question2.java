package leetcode_arays;

public class Question2 {

    /*
    You are given a positive integer array grades which represents the grades of students in a university. You would like to enter all these students into a competition in ordered non-empty groups, such that the ordering meets the following conditions:

        The sum of the grades of students in the ith group is less than the sum of the grades of students in the (i + 1)th group, for all groups (except the last).
        The total number of students in the ith group is less than the total number of students in the (i + 1)th group, for all groups (except the last).
        Return the maximum number of groups that can be formed.

     */


    public static int[] twoSum(int[] nums, int target) {
        int i;
        int[] arr = new int[2];
        int j;
        for (i = 0; i < nums.length; i++){
            for (j = 0; j < nums.length; j++){
                if (i != j && (nums[i] + nums[j] == target)){
                    arr[0] = i;
                    arr[1] = j;
                    return arr;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] grades = {2,2,4,5};
        int[] grades1 = {3,2,4,4,4,4,5,6,7,2,3};
        int[] grades2 = {3,3};
        twoSum(grades, 9);
        twoSum(grades1, 6);
        twoSum(grades2, 6);
    }

}
