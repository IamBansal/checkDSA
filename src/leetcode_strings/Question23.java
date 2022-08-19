package leetcode_strings;

public class Question23 {

    /*
    We define the usage of capitals in a word to be right when one of the following cases holds:

All letters in this word are capitals, like "USA".
All letters in this word are not capitals, like "leetcode".
Only the first letter in this word is capital, like "Google".
Given a string word, return true if the usage of capitals in it is right.

     */

    public static boolean detectCapitalUse(String word) {
        if (word.length() == 1) {
            return true;
        }
        if (word.toUpperCase().equals(word) || word.toLowerCase().equals(word)) {
            return true;
        } else {
            if ((int) word.charAt(0) < 65 || (int) word.charAt(0) > 90) {
                return false;
            } else {
                for (int i = 1; i < word.length(); i++) {
                    if ((int) word.charAt(i) >= 65 && (int) word.charAt(i) <= 90) {
                        return false;
                    }
                }
                return true;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(detectCapitalUse("USA"));
        System.out.println(detectCapitalUse("a"));
        System.out.println(detectCapitalUse("leetcode"));
        System.out.println(detectCapitalUse("Leetcode"));
        System.out.println(detectCapitalUse("flaG"));
        System.out.println(detectCapitalUse("FlaG"));
    }
}
