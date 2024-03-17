package leetcode_problems.sheet_arsh.greedy;

public class GasStation {

    /*
    134. Gas Station
    There are n gas stations along a circular route, where the amount of gas at the ith st is gas[i].
    You have a car with an unlimited gas tank and it costs cost[i] of gas to travel
    from the ith station to its next (i + 1)th station.
    You begin the journey with an empty tank at one of the gas stations.

    Given two integer arrays gas and cost, return the starting gas station's index
     if you can travel around the circuit once in the clockwise direction, otherwise return -1.
     If there exists a solution, it is guaranteed to be unique
     */

    //This solution gives TLE
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        for(int i = 0; i < gas.length; i++){
            if(gas[i] >= cost[i] && letsGo(gas, cost, i)) return i;
        }
        return -1;
    }

    private static boolean letsGo(int[] gas, int[] cost, int startIndex) {
        int check = 0;
        for (int i = startIndex; i < gas.length; i++){
            check += gas[i] - cost[i];
            if (check < 0) return false;
        }
        for (int i = 0; i < startIndex; i++){
            check += gas[i] - cost[i];
            if (check < 0) return false;
        }

        return true;
    }

    public static int canCompleteCircuit2(int[] gas, int[] cost) {
        int n = gas.length;
        int total_surplus = 0;
        int surplus = 0;
        int start = 0;

        for(int i = 0; i < n; i++){
            total_surplus += gas[i] - cost[i];
            surplus += gas[i] - cost[i];
            if(surplus < 0){
                surplus = 0;
                start = i + 1;
            }
        }
        return (total_surplus < 0) ? -1 : start;
    }

    public static void main(String[] args) {
        System.out.println(canCompleteCircuit(new int[]{1, 2, 3, 4, 5}, new int[]{3,4,5,1,2}));
    }
}
