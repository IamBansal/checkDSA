package leetcode_strings;

public class Question20 {

    /*
    Given a string s, check if it can be constructed by taking a substring of it
    and appending multiple copies of the substring together.
     */

    public static boolean repeatedSubstringPattern(String s) {
        for (int i = 1; i < s.length(); i++) {
            String str = s.substring(0, i);
            int n = 0, num = 1, b = 1;
            int j = i;
            for (; j <= s.length() - str.length(); j++) {
                String sub = s.substring(j, j + str.length());
                n = j;
                if (sub.equals(str)) {
                    b = 0;
                    num++;
                    j += sub.length();
                    j--;
                } else {
                    b = 1;
                    break;
                }

            }
            if (b == 0 && j == s.length()) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(repeatedSubstringPattern("abab"));
        System.out.println(repeatedSubstringPattern("aba"));
        System.out.println(repeatedSubstringPattern("abcabcabcabc"));
    }
}
