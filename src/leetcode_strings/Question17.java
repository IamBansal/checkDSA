package leetcode_strings;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class Question17 {

    /*
    Given an integer n, return a string array answer (1-indexed) where:

      answer[i] == "FizzBuzz" if i is divisible by 3 and 5.
      answer[i] == "Fizz" if i is divisible by 3.
      answer[i] == "Buzz" if i is divisible by 5.
      answer[i] == i (as a string) if none of the above conditions are true.
     */

    public static List<String> fizzBuzz(int n) {
        String[] result = new String[n];
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0) {
                if (i % 5 == 0) {
                    result[i - 1] = "FizzBuzz";
                } else {
                    result[i - 1] = "Fizz";
                }
            } else if (i % 5 == 0) {
                result[i - 1] = "Buzz";
            } else {
                result[i - 1] = String.valueOf(i);
            }
        }
        return Arrays.stream(result).toList();
    }

    public static void printArray(List<String> arr) {
        for (String ch : arr
        ) {
            System.out.print(ch + ", ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        printArray(fizzBuzz(3));
        printArray(fizzBuzz(5));
        printArray(fizzBuzz(15));
    }
}
