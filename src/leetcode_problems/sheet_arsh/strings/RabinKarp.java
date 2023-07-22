package leetcode_problems.sheet_arsh.strings;

public class RabinKarp {

    /*
    GFG Problem

    Rabin-Karp Algorithm for Pattern Searching
    Given a text txt[0. . .n-1] and a pattern pat[0. . .m-1], write a function search(char pat[], char txt[])
    that prints all occurrences of pat[] in txt[]. You may assume that n > m.
     */

    public static void search(String pattern, String text, int q) {
        int patternSum = 0, n = pattern.length();
        for (char c : pattern.toCharArray()) patternSum += c;
        int mod = patternSum % q;

        char[] textArray = text.toCharArray();

        int sum = 0;
        for (int i = 0; i < text.length() - n; i++) {
            if (i == 0) {
                for (int j = i; j < i + n; j++) {
                    sum += textArray[j];
                }
            } else {
                sum -= textArray[i - 1];
                sum += textArray[i + n - 1];
            }
            if (sum % q == mod && text.startsWith(pattern, i)) System.out.println("Pattern found at index: " + i);
        }
    }

    public static void main(String[] args) {
        search("geek", "geeks for geeks", 11);
    }
}
