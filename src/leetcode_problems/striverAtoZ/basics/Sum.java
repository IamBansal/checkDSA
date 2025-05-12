package leetcode_problems.striverAtoZ.basics;

public class Sum {

    public static int sumOfFirstNNumbers(int n){
        if(n == 0) return n;
        return sumOfFirstNNumbers(n - 1) + n;
    }

    public static int factorial(int n){
        if(n == 1) return n;
        return factorial(n - 1) * n;
    }

    public static void reverseArray(int n, int[] arr){
        if (n <= arr.length / 2) return;

        int temp = arr[n - 1];
        arr[n - 1] = arr[arr.length - n];
        arr[arr.length - n] = temp;
        reverseArray(n - 1, arr);
    }

    public static boolean checkPalindrome(String s){
        return checkPalindromeHelper(s.toCharArray(), s.length());
    }

    private static boolean checkPalindromeHelper(char[] s, int length) {
        if (length <= s.length / 2) {
          if (length % 2 == 0) return s[length - 1] == s[s.length - length];
          else return true;
        }

        if(s[length - 1] == s[s.length - length]) return checkPalindromeHelper(s, length - 1);
        else return false;
    }

    public static int fibonacci(int n){
        if (n == 0 || n == 1) return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        System.out.println(sumOfFirstNNumbers(5));
        System.out.println(factorial(5));

        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        reverseArray(7, arr);
        for (int e: arr){
            System.out.print(e + " ");
        }
        System.out.println();

        System.out.println(fibonacci(3));
        System.out.println(fibonacci(5));
        System.out.println(fibonacci(8));

        System.out.println(checkPalindrome("aba"));
    }

}
