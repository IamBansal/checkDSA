package leetcode_arays;

public class Question6 {

    /*
    You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer. The digits are ordered from most significant to least significant in left-to-right order. The large integer does not contain any leading 0's.

Increment the large integer by one and return the resulting array of digits.
     */

    public static int[] plus(int[] digits){

        String num = "";
        for (int digit : digits) {
            num = num + digit;
        }
        int value = Integer.parseInt(num);
        System.out.println(value);
        value++;
        String finaLs = Integer.toString(value);
        System.out.println(finaLs);
        int[] ans = new int[finaLs.length()];
        for (int i = 0; i < ans.length; i++){
            ans[i] = Integer.parseInt(String.valueOf(finaLs.charAt(i)));
        }
        return ans;
    }
    public static int[] plusOne(int[] digits) {
        int val = digits[digits.length -1 ];

        if (val == 9){
            int[] ans = new int[digits.length + 1];
            System.arraycopy(digits, 0, ans, 0, digits.length);
            for (int i = digits.length - 1; i >= 0; i--){
                if (ans[i] == 9 && i != 0){
                    ans[i] = 0;
                } else {
                    if (ans[i] == 9 && i == 0){
                        ans[i] = 1;
                    } else {
                        ans[i] += 1;
                    }
                }
            }
            ans[digits.length] = 0;
            for (int e:ans
                 ) {
                System.out.print(e + " ");
            }
            return ans;
        } else {
            val++;
            digits[digits.length -1 ] = val;
            return digits;
        }
    }

    public static void main(String[] args) {
        int[] digits = {9,8,7,6,5,4,3,2,1,0};
        plus(digits);
    }
}
