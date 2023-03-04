package leetcode_backtracking;

import java.util.ArrayList;
import java.util.List;

public class Question5 {

    public static int minCut(String s){
        List<List<String>> res = partition(s);
        int min = Integer.MAX_VALUE;
        for (List<String> list:res
             ) {
            if (list.size() - 1 < min){
                min = list.size() - 1;
            }
        }
        return min;
    }

    public static List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> path = new ArrayList<>();
        partitionHelper(0, s, path, res);
        return res;
    }

    static void partitionHelper(int index, String s, List<String> path, List<List<String>> res) {
        if (index == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = index; i < s.length(); ++i) {
            if (isPalindrome(s, index, i)) {
                path.add(s.substring(index, i + 1));
                partitionHelper(i + 1, s, path, res);
                path.remove(path.size() - 1);
            }
        }
    }

    static boolean isPalindrome(String s, int start, int end) {
        while (start <= end) {
            if (s.charAt(start++) != s.charAt(end--))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "aabb";
        List<List<String>> ans = partition(s);
        System.out.println("The Palindromic partitions are :-");
        System.out.print(" [ ");
        for (List<String> an : ans) {
            System.out.print("[ ");
            for (String value : an) {
                System.out.print(value + " ");
            }
            System.out.print("] ");
        }
        System.out.print("]");


    }
}
