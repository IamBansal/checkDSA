package leetcode_problems.leetcode_backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Question7 {

    /*

    A happy string is a string that:

    - consists only of letters of the set ['a', 'b', 'c'].
    - s[i] != s[i + 1] for all values of i from 1 to s.length - 1 (string is 1-indexed).
    For example, strings "abc", "ac", "b" and "abcbabcbcb" are all happy strings
    and strings "aa", "baa" and "ababbc" are not happy strings.

    Given two integers n and k, consider a list of all happy strings of length n
    sorted in lexicographical order and return the kth string of this list or
    return an empty string if there are less than k happy strings of length n.

     */

//    public static String getHappyString(int n, int k) {
//
//        if (n == 1) {
//            return get(k);
//        }
//        String str = "";
//        int l = (int) (Math.pow(2, n - 1));
//        str += get(k / l + 1);
//        return solve(n - 1, k % l, str);
//    }
//
//    private static String solve(int n, int k, String str) {
//
//        if (n == 1) {
//            return str + get(k + 1);
//        }
//
//        int l = (int) (Math.pow(2, n - 1));
//        str += get(k / l + 1);
//        return solve(n - 1, k % l, str);
//
//    }
//
//    static String get(int k){
//        if (k == 1){
//            return "a";
//        } else if (k == 2) {
//            return "b";
//        } else if (k == 3) {
//            return "c";
//        } else {
//            return "";
//        }
//    }

    public static String getHappyString(int n, int k) {

        if (k > 3 * Math.pow(2, n - 1)) return "";

        List<String> result = new ArrayList<>();
        List<String> helper = new ArrayList<>();
        String[] arr = {"a", "b", "c"};
        solve(n, result, arr, helper);
        return result.get(k - 1);
    }

    private static void solve(int n, List<String> result, String[] arr, List<String> helper) {
        if (n == 0) {
            StringBuilder str = new StringBuilder();
            for (String c : helper) {
                str.append(c);
            }
            result.add(str.toString());
            return;
        }

        for (String c : arr) {
            if (helper.isEmpty()) {
                helper.add(c);
                solve(n - 1, result, arr, helper);
                helper.remove(helper.size() - 1);
            } else {
                String lastElement = helper.get(helper.size() - 1);
                if (!lastElement.equals(c)) {
                    helper.add(c);
                    solve(n - 1, result, arr, helper);
                    helper.remove(helper.size() - 1);
                }
            }
        }
    }

    public static String getHappyStringBetter(int n, int k) {
        if (n == 0) return "";

        if (k > 3 * Math.pow(2, n - 1)) return "";

        k--;

        StringBuilder sb = new StringBuilder();
        Map<Character, char[]> map = new HashMap<>();
        map.put(' ', new char[]{'a', 'b', 'c'});
        map.put('a', new char[]{'b', 'c'});
        map.put('b', new char[]{'a', 'c'});
        map.put('c', new char[]{'a', 'b'});

        char prev = ' ';
        while (n > 1) {
            int nextAmount = (int) Math.pow(2, n - 1);
            int rank = k / nextAmount;

            sb.append(map.get(prev)[rank]);
            prev = map.get(prev)[rank];
            k = k % nextAmount;

            n--;
        }

        sb.append(map.get(prev)[k]);
        return sb.toString();
    }

    public static void main(String[] args) {

//        System.out.println(getHappyString(1, 3));
//        System.out.println(getHappyString(1, 4));
//        System.out.println(getHappyString(2, 1));
//        System.out.println(getHappyString(3, 9));
//        System.out.println(getHappyString(3, 10));
//        System.out.println(getHappyString(4, 1));

        System.out.println(getHappyStringBetter(20,3));
        System.out.println(getHappyString(20,3));

    }
}
