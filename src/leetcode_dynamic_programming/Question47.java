package leetcode_dynamic_programming;

import java.util.Arrays;

public class Question47 {

    /*
    1547. Minimum Cost to Cut a Stick

    Given a wooden stick of length n units. The stick is labelled from 0 to n.
    For example, a stick of length 6 is labelled as follows:
    Given an integer array cuts where cuts[i] denotes a position you should perform a cut at.
    You should perform the cuts in order, you can change the order of the cuts as you wish.
    The cost of one cut is the length of the stick to be cut, the total cost is the sum of costs of all cuts.
    When you cut a stick, it will be split into two smaller sticks
    (i.e. the sum of their lengths is the length of the stick before the cut).
    Please refer to the first example for a better explanation.

    Return the minimum total cost of the cuts.

     */

    //memoized solution
    public static int minCost(int n, int[] cuts) {
        int[] cutsArray = new int[cuts.length + 2];
        System.arraycopy(cuts, 0, cutsArray, 1, cuts.length);
        cutsArray[0] = 0;
        cutsArray[cutsArray.length - 1] = n;

        Arrays.sort(cutsArray);

        int[][] dp = new int[cuts.length + 1][cuts.length + 1];
        for (int[] ints : dp) Arrays.fill(ints, -1);

        return helper(cutsArray, 1, cuts.length, dp);

    }

    private static int helper(int[] cutsArray, int i, int j, int[][] dp) {
        if (i > j) return 0;

        if (dp[i][j] != -1) return dp[i][j];

        int min = (int) 1e9;
        for (int index = i; index <= j; index++) {
            int cost = cutsArray[j + 1] - cutsArray[i - 1] + helper(cutsArray, i, index - 1, dp) + helper(cutsArray, index + 1, j, dp);
            min = Math.min(min, cost);
        }
        return dp[i][j] = min;
    }

    //Tabulated solution
    public static int minCostTabulated(int n, int[] cuts) {
        int c = cuts.length;
        int[] cutsArray = new int[c + 2];
        System.arraycopy(cuts, 0, cutsArray, 1, c);
        cutsArray[0] = 0;
        cutsArray[cutsArray.length - 1] = n;

        Arrays.sort(cutsArray);

        int[][] dp = new int[c + 2][c + 2];

        for (int i = c; i > 0; i--) {
            for (int j = 1; j <= c; j++) {
                if (i > j) continue;
                int min = (int) 1e9;
                for (int index = i; index <= j; index++) {
                    int cost = cutsArray[j + 1] - cutsArray[i - 1] + dp[i][index - 1] + dp[index + 1][j];
                    min = Math.min(min, cost);
                }
                dp[i][j] = min;
            }
        }

        return dp[1][c];
    }


    public static void main(String[] args) {
        int[] cuts = {1, 3, 4, 5};
        int[] cuts1 = {5, 6, 1, 4, 2};
        System.out.println(minCost(7, cuts));
        System.out.println(minCost(9, cuts1));
        System.out.println();
        System.out.println(minCostTabulated(7, cuts));
        System.out.println(minCostTabulated(9, cuts1));
    }
}
