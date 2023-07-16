package leetcode_problems.sheet_arsh.array;

public class MaxPointsFromCards {

    /*
    1423. Maximum Points You Can Obtain from Cards
    There are several cards arranged in a row, and each card has an associated number of points.
    The points are given in the integer array cardPoints.
    In one step, you can take one card from the beginning or from the end of the row.
    You have to take exactly k cards.
    Your score is the sum of the points of the cards you have taken.
    Given the integer array cardPoints and the integer k, return the maximum score you can obtain.
     */

    //This solution gives TLE
    public static int maxScore(int[] cardPoints, int k) {
        if (k == cardPoints.length) {
            int sum = 0;
            for (int num : cardPoints) sum += num;
            return sum;
        }

        return maxScoreHelper(cardPoints, 0, cardPoints.length - 1, k);
    }

    private static int maxScoreHelper(int[] cardPoints, int start, int end, int k) {
        if (k == 1) return Math.max(cardPoints[start], cardPoints[end]);

        int leftPick = cardPoints[start] + maxScoreHelper(cardPoints, start + 1, end, k - 1);
        int rightPick = cardPoints[end] + maxScoreHelper(cardPoints, start, end - 1, k - 1);

        System.out.println(leftPick + ", " + rightPick + " at " + k);

        return Math.max(leftPick, rightPick);
    }

    /*
    In it, just combinations of the card from beginning and end are taken.
    i.e.,
    for 3 cards... combinations are..
    beginning - end
        3     -  0
        2     -  1
        1     -  2
        0     -  3

    and then, prefix array is used for calculation.
     */
    public static int maxScoreBetter(int[] cardPoints, int k){

        int[] preSum = new int[cardPoints.length];
        preSum[0] = cardPoints[0];
        for (int i = 1; i < preSum.length; i++){
            preSum[i] = preSum[i - 1] + cardPoints[i];
        }

        int last = preSum.length - 1;
        if (k == cardPoints.length) return preSum[last];

        int max = 0;
        for (int i = k; i >= 0; i--){
            if (i == 0) max = Math.max(max, preSum[last] - preSum[last + i - k]);
            else max = Math.max(max, preSum[i - 1] + preSum[last] - preSum[last + i - k]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] points = {1, 2, 3, 4, 5, 6, 1};
        System.out.println(maxScore(points, 3));
        System.out.println(maxScoreBetter(points, 3));
    }
}
