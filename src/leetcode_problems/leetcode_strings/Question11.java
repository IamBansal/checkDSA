package leetcode_problems.leetcode_strings;

public class Question11 {

    /*
    Write a function that reverses a string. The input string is given as an array of characters s.

You must do this by modifying the input array in-place with O(1) extra memory.
     */

    public static void reverseString(char[] s) {
        int n = s.length;
        for (int i = 0; i < n / 2; i++){
            char temp = s[i];
            s[i] = s[n - 1 - i];
            s[n - 1 - i] = temp;
        }
        for (Character c:s
             ) {
            System.out.print(c);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        char[] s = {'H','a','n','n','a','h'};
        char[] s1 = {'h','e','l','l','o'};
        reverseString(s);
        reverseString(s1);
    }
}
