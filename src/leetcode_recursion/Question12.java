package leetcode_recursion;

public class Question12 {

    /*

    Given two positive integers n and k, the binary string Sn is formed as follows:

    S1 = "0"
    Si = Si - 1 + "1" + reverse(invert(Si - 1)) for i > 1
    Where + denotes the concatenation operation, reverse(x) returns the reversed string x,
    and invert(x) inverts all the bits in x (0 changes to 1 and 1 changes to 0).

    For example, the first four strings in the above sequence are:

    S1 = "0"
    S2 = "011"
    S3 = "0111001"
    S4 = "011100110110001"
    Return the kth bit in Sn. It is guaranteed that k is valid for the given n.

     */

    public static char findKthBit(int n, int k) {

        if (n == 1 || k == 1) {
            return '0';
        }

        return stringMaker(n).charAt(k - 1);

    }

    private static String stringMaker(int n) {

        if (n == 1) {
            return "0";
        }

        String previousString = stringMaker(n - 1);
        return previousString + "1" + reverse(invert(previousString));

    }

    public static String invert(String str) {
        StringBuilder result = new StringBuilder();
        for (Character c : str.toCharArray()
        ) {
            if (c == '0') {
                result.append('1');
            } else {
                result.append('0');
            }
        }
        return result.toString();
    }

    public static String reverse(String str) {
        if (str.length() <= 1) {
            return str;
        }

        StringBuilder result = new StringBuilder();

        for (int i = str.length() - 1; i >= 0; i--) {
            result.append(str.charAt(i));
        }

        return result.toString();
    }

    //Better Solution
    public static char kthBitBetter(int n, int k) {
        if (n == 1 || k == 1) {
            return '0';
        }

        int mid = (int) (Math.pow(2, n) / 2);

        if (k == mid) {
            return '1';
        } else if (k < mid) {
            return kthBitBetter(n - 1, k);
        } else {
            int kValue = (int) (Math.pow(2, n) - k);
            return (kthBitBetter(n - 1, kValue) == '1') ? '0' : '1';
        }
    }

    public static void main(String[] args) {

        System.out.println(findKthBit(3, 1));
        System.out.println(findKthBit(4, 11));
        System.out.println(findKthBit(4, 12));

        System.out.println();

        System.out.println(kthBitBetter(3, 1));
        System.out.println(kthBitBetter(4, 11));
        System.out.println(kthBitBetter(4, 12));

    }
}