package leetcode_problems.sheet_arsh.mathematical;

public class AddBinary {

    /*
    67. Add Binary
    Given two binary strings a and b, return their sum as a binary string.
     */

    //This solution fails on much larger inputs
    public static String addBinary(String a, String b) {
        long one = 0, two = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == '1') one += Math.pow(2, a.length() - 1 - i);
        }
        for (int i = 0; i < b.length(); i++) {
            if (b.charAt(i) == '1') two += Math.pow(2, b.length() - 1 - i);
        }

        return Long.toBinaryString(one + two);
    }

    public static String addBinaryBetter(String a, String b) {
        StringBuilder res = new StringBuilder();

        if (a.length() < b.length()) {
            String temp = b;
            b = a;
            a = temp;
        }

        int carry = 0;
        for (int i = 0; i < b.length(); i++) {
            switch (carry + b.charAt(b.length() - 1 - i) + a.charAt(a.length() - 1 - i) - 96) {
                case 0 -> {
                    res.append("0");
                    carry = 0;
                }
                case 1 -> {
                    res.append("1");
                    carry = 0;
                }
                case 2 -> {
                    res.append("0");
                    carry = 1;
                }
                case 3 -> {
                    res.append("1");
                    carry = 1;
                }
            }
        }

        for (int i = b.length(); i < a.length(); i++) {
            switch (carry + a.charAt(a.length() - 1 - i) - 48) {
                case 0 -> {
                    res.append("0");
                    carry = 0;
                }
                case 1 -> {
                    res.append("1");
                    carry = 0;
                }
                case 2 -> {
                    res.append("0");
                    carry = 1;
                }
                case 3 -> {
                    res.append("1");
                    carry = 1;
                }
            }
        }
        if (carry == 1) res.append(carry);
        return res.reverse().toString();
    }

    public static String addBinaryOptimised(String a, String b) {

        int index1 = a.length() - 1, index2 = b.length() - 1;
        StringBuilder sb = new StringBuilder();
        boolean carry = false;
        char char1, char2;

        while ((index1 >= 0) || (index2 >= 0) || carry) {
            char1 = (index1 >= 0) ? a.charAt(index1) : '0';
            char2 = (index2 >= 0) ? b.charAt(index2) : '0';

            char sum;
            if (char1 == '0' && char2 == '0') {
                sum = carry ? '1' : '0';
                carry = false;
            } else if (char1 == '1' && char2 == '1') {
                sum = carry ? '1' : '0';
                carry = true;
            } else {
                sum = carry ? '0' : '1';
            }

            sb.append(sum);

            index1--;
            index2--;
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(addBinary("11", "1"));
        System.out.println(addBinary("1010", "1011"));
        System.out.println(addBinaryBetter("11", "1"));
        System.out.println(addBinaryBetter("1010", "1011"));
    }
}
