package leetcode_problems.leetcode_strings;

import java.util.ArrayList;

public class Question12 {

    /*
    Given a string s, reverse only all the vowels in the string and return it.

The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both cases.

     */

    public static String reverseVowels(String s) {
        ArrayList<Character> vowels = new ArrayList<>();
        char[] string = s.toCharArray();
        for (Character c : string
        ) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'
                    || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
                vowels.add(c);
            }
        }
        Object[] vowelsArray = vowels.toArray();

        int n = vowelsArray.length;
        for (int i = 0; i < n / 2; i++) {
            char temp = (char) vowelsArray[i];
            vowelsArray[i] = vowelsArray[n - 1 - i];
            vowelsArray[n - 1 - i] = temp;
        }
        int j = 0;
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < string.length; i++) {
            if (string[i] == 'a' || string[i] == 'e' || string[i] == 'i' || string[i] == 'o' || string[i] == 'u'
                    || string[i] == 'A' || string[i] == 'E' || string[i] == 'I' || string[i] == 'O' || string[i] == 'U') {
                string[i] = (char) vowelsArray[j];
                j++;
            }
            result.append(string[i]);
        }
        return String.valueOf(result);
    }

    public static void main(String[] args) {
        System.out.println(reverseVowels("hello"));
        System.out.println(reverseVowels("leetcode"));
        System.out.println(reverseVowels("Akshat"));
    }
}
