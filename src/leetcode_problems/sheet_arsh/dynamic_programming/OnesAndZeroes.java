package leetcode_problems.sheet_arsh.dynamic_programming;

public class OnesAndZeroes {

    /*
    474. Ones and Zeroes
    You are given an array of binary strings strs and two integers m and n.
    Return the size of the largest subset of strs such that there are at most m 0's and n 1's
    in the subset.

    A set x is a subset of a set y if all elements of x are also elements of y.
     */

    //TODO - INCOMPLETE

    public static int findMaxForm(String[] strings, int m, int n) {
        int minLength = Math.min(m, n);

        int result = 0;
        for (String str: strings){
            if (str.length() > minLength){
                if (isEligible(str, m, n)) result++;
            } else {
                result++;
            }
        }

        return result;
    }

    private static boolean isEligible(String str, int m, int n) {
        for (int i = 0; i < str.length(); i++){
            if (str.charAt(i) == '1') n--;
            else m--;

            if(m < 0 || n < 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(findMaxForm(new String[]{"10", "0001", "111001", "1", "0"}, 5, 3));
        System.out.println(findMaxForm(new String[]{"10","0","1"}, 1, 1));
    }
}
