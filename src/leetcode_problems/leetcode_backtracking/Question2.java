package leetcode_problems.leetcode_backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Question2 {

    //TODO - Incomplete
    public static List<String> letterCombinations(String digits) {

        List<String> result = new ArrayList<>();

        HashMap<Integer, ArrayList<String>> map = new HashMap<>();
//        map.put(2, {"a", });

        helper(digits, result, "");
        return result;
    }

    private static void helper(String digits, List<String> result, String str) {

        if (digits.length() == 0){
            return;
        }



    }

    public static void main(String[] args) {
        List<String> result = letterCombinations("23");
        for (String str : result) {
            System.out.println(str);
        }
        System.out.println();
        List<String> result2 = letterCombinations("");
        for (String str : result2) {
            System.out.println(str);
        }
        System.out.println();
        List<String> result3 = letterCombinations("2");
        for (String str : result3) {
            System.out.println(str);
        }


        System.out.println(('a'+1));

    }

}
