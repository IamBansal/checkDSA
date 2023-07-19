package leetcode_problems.sheet_arsh.strings;

public class LongestCommonPrefix {

    /*
    14. Longest Common Prefix
    Write a function to find the longest common prefix string amongst an array of strings.
    If there is no common prefix, return an empty string "".
     */

    public static String longestCommonPrefix(String[] strings) {
        String result = strings[0];
        for (int i = 1; i < strings.length; i++){
            if (!strings[i].startsWith(result)) {
                do {
                    result = result.substring(0, result.length() - 1);
                } while (!strings[i].startsWith(result));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String[] strings = {"flower","flow","flight"};
        String[] strings1 = {"flower","low","eight"};
        System.out.println(longestCommonPrefix(strings));
        System.out.println(longestCommonPrefix(strings1));
    }
}
