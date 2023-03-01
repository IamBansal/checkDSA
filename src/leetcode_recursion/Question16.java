package leetcode_recursion;

import java.util.LinkedList;

public class Question16 {

    /*
    JOSEPHUS PROBLEM - (ADITYA VERMA YOUTUBE)

    There are n friends that are playing a game.
    The friends are sitting in a circle and are numbered from 1 to n in clockwise order.
    More formally, moving clockwise from the ith friend brings you to the (i+1)th friend for 1 <= i < n,
    and moving clockwise from the nth friend brings you to the 1st friend.

    The rules of the game are as follows:

    Start at the 1st friend.
    Count the next k friends in the clockwise direction including the friend you started at.
    The counting wraps around the circle and may count some friends more than once.
    The last friend you counted leaves the circle and loses the game.
    If there is still more than one friend in the circle,
    go back to step 2 starting from the friend immediately clockwise of the friend who just lost and repeat.
    Else, the last friend in the circle wins the game.
    Given the number of friends, n, and an integer k, return the winner of the game
     */
//
//    public static int findTheWinner(int n, int k) {
//
//        LinkedList<Integer> check = new LinkedList<>();
//        int i = 1;
//        while (i <= n){
//            check.add(i);
//            i++;
//        }
//
//        return helper(k, k - 1, check).get(0);
//    }
//
//    private static LinkedList<Integer> helper(int k, int index, LinkedList<Integer> check) {
//
//        if (check.size() == 1){
//            return check;
//        }
//
//        check.remove(index);
//        int newIndex = ((index + k - 1) % check.size()) ;
//        return helper(k, newIndex, check);
//
//    }


    //Better solution
    public static int findTheWinner(int n, int k) {
        return solve(n, k) + 1;
    }

    public static int solve(int n, int k) {
        if (n == 1) return 0;
        return (solve(n - 1, k) + k) % n;
    }

    public static void main(String[] args) {
        System.out.println(findTheWinner(5, 2));
        System.out.println(findTheWinner(6, 5));
    }
}
