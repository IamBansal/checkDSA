package leetcode_problems.sheet_arsh.stacks_queues;

public class TheCelebrityProblem {

    /*
    GFG Problem

    The Celebrity Problem
    A celebrity is a person who is known to all but does not know anyone at a party.
    If you go to a party of N people, find if there is a celebrity in the party or not.
    A square NxN matrix M[][] is used to represent people at the party such that if
    an element of row i and column j  is set to 1 it means ith person knows jth person.
    Here M[i][i] will always be 0.

    - Note: Follow 0 based indexing.
    - Follow Up: Can you optimize it to O(N)
     */

    public static int celebrity(int[][] array, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (array[i][j] == 1 && checkIfJIsCeleb(j, array)) return j;
            }
        }
        return -1;
    }

    private static boolean checkIfJIsCeleb(int j, int[][] array) {

        //The person knows someone.
        for (int k = 0; k < array.length; k++) if (array[j][k] == 1) return false;

        //How many person knows him.
        int count = 0;
        for (int[] ints : array) if (ints[j] == 1) count++;

        return count == array.length - 1;
    }

    public static void main(String[] args) {
        System.out.println(celebrity(new int[][]{
                {0, 1, 0},
                {0, 0, 0},
                {0, 1, 0}}, 3));
        System.out.println(celebrity(new int[][]{
                {0, 1},
                {1, 0}}, 2));
    }
}
