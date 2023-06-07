package leetcode_problems.leetcode_strings;

public class Question25 {

    /*
    You are given a string s representing an attendance record for a student where each character
     signifies whether the student was absent, late, or present on that day.
     The record only contains the following three characters:

     'A': Absent.
     'L': Late.
     'P': Present.
     The student is eligible for an attendance award if they meet both of the following criteria:

     The student was absent ('A') for strictly fewer than 2 days total.
     The student was never late ('L') for 3 or more consecutive days.
     Return true if the student is eligible for an attendance award, or false otherwise.

     */

    public static boolean checkRecord(String s) {
        int A = 0;
        int L = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == 'A') {
                A++;
                L = 0;
            }
            if (ch == 'L') {
                L++;
                if (L >= 3) return false;
            } else {
                L = 0;
            }
        }
        return A < 2;
    }

    public static void main(String[] args) {
        System.out.println(checkRecord("PPALLP"));
        System.out.println(checkRecord("PPALLL"));
    }
}
