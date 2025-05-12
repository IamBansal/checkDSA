package leetcode_problems.striverAtoZ.basics;

import java.util.ArrayList;

class ArmStrongNumber {
    public static boolean isArmstrong(int n) {
        ArrayList<Integer> arr = new ArrayList<>();

        int num  = n;
        int count = 0;
        while(n > 0){
            arr.add(n%10);
            count++;
            n=n/10;
        }
        int sum = 0;
        System.out.println(count);
        System.out.println(arr);
        for(int e: arr){
            sum += Math.pow(e, count);
        }
        System.out.println(sum);
        return sum == num;
    }

    public static void main(String[] args) {
        System.out.println(isArmstrong(153));
    }
}
