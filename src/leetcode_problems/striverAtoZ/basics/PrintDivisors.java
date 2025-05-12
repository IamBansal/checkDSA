package leetcode_problems.striverAtoZ.basics;

import java.util.ArrayList;

public class PrintDivisors {

    public static int[] divisors(int n) {
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            if(n % i == 0) arr.add(i);
        }
        return arr.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        System.out.println(divisors(6));
    }
}