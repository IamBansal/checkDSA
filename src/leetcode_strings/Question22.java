package leetcode_strings;

import java.util.ArrayList;

public class Question22 {

    /*
    Given an array of strings words, return the words that can be typed using
    letters of the alphabet on only one row of American keyboard like the image below.

In the American keyboard:

the first row consists of the characters "qwertyuiop",
the second row consists of the characters "asdfghjkl", and
the third row consists of the characters "zxcvbnm".
     */

    public static String[] findWords(String[] words) {
        ArrayList<String> result = new ArrayList<>();

        String firstRow = "qwertyuiop";
        String secondRow = "asdfghjkl";
        String thirdRow = "zxcvbnm";

        ArrayList<Character> first = new ArrayList<>();
        ArrayList<Character> second = new ArrayList<>();
        ArrayList<Character> third = new ArrayList<>();

        for (Character ch : firstRow.toCharArray()) {
            first.add(ch);
        }
        for (Character ch : secondRow.toCharArray()) {
            second.add(ch);
        }
        for (Character ch : thirdRow.toCharArray()) {
            third.add(ch);
        }

        int check;

        for (String string : words) {
            if (string.length() == 1) {
                result.add(string);
                continue;
            } else if (string.length() == 0 || string.toLowerCase().equals(string.toUpperCase())) {
                continue;
            }
            String str = string.toLowerCase();
            if (first.contains(str.charAt(0))) {
                check = 1;
            } else if (second.contains(str.charAt(0))) {
                check = 2;
            } else {
                check = 3;
            }
            for (int i = 1; i < str.length(); i++) {
                if (check == 1 && !first.contains(str.charAt(i))) {
                    break;
                } else if (check == 2 && !second.contains(str.charAt(i))) {
                    break;
                } else if (check == 3 && !third.contains(str.charAt(i))) {
                    break;
                }
                if (i == str.length() - 1) {
                    result.add(string);
                }
            }
        }

        String[] finalResult = new String[result.size()];
        for (int i = 0; i < finalResult.length; i++) {
            finalResult[i] = result.get(i);
        }
        return finalResult;
    }

    public static void printArray(String[] arr) {
        for (String ch : arr
        ) {
            System.out.print(ch + ", ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        String[] words = {"Hello", "Alaska", "Dad", "Peace"};
        printArray(findWords(words));
        String[] words1 = {"adsdf", "sfd"};
        printArray(findWords(words1));
        String[] words2 = {"omk"};
        printArray(findWords(words2));
        String[] words3 = {"a", "b"};
        printArray(findWords(words3));
        String[] words4 = {"a", ""};
        printArray(findWords(words4));
    }
}
