package leetcode_problems.leetcode_strings;

public class Question2 {

    /*
    Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".
     */

    public static String longestCommonPrefix(String[] strs) {
        String result = strs[0];

        if (result == null || result.length() == 0)
            return "";

        for (int i = 1; i < strs.length; i++) {
            if (!strs[i].startsWith(result)) {
                while (true) {
                    result = result.substring(0, result.length() - 1);
                    if (strs[i].startsWith(result)) {
                        break;
                    } else if (result.length() == 0)
                        return "";
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String[] strings = {"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix(strings));
        String[] strings1 = {"dog", "racecar", "car"};
        System.out.println(longestCommonPrefix(strings1));
    }
}
