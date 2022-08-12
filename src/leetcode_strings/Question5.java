package leetcode_strings;

import java.util.ArrayList;

public class Question5 {

    /*
    Given a string s consisting of words and spaces,
    return the length of the last word in the string.

    A word is a maximal substring consisting of non-space characters only.
     */

    public static int lengthOfLastWord(String s) {
        if (s.length() == 0 || s.toUpperCase().equals(s.toLowerCase())) {
            return 0;
        } else {
            StringBuilder reverse = new StringBuilder("");
            for (int i = s.length() - 1; i >= 0; i--) {
                reverse.append(s.charAt(i));
            }
            ArrayList<Character> check = new ArrayList<>();
            for (Character c : reverse.toString().toCharArray()
            ) {
                if (c.equals(' ')) {
                    if (!check.isEmpty()) {
                        break;
                    }
                } else {
                    check.add(c);
                }
            }
            return check.size();
        }
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("Hello World"));
        System.out.println(lengthOfLastWord("a"));
        System.out.println(lengthOfLastWord("   fly me   to   the moon  "));
        System.out.println(lengthOfLastWord("luffy is still joyboy"));
    }
}
