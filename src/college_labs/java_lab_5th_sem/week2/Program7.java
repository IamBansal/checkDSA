package college_labs.java_lab_5th_sem.week2;

public class Program7 {

    public static void multiplyMatrix(int[][] arr1, int[][]arr2) {

        int[][] result = new int[arr1.length][arr2[0].length];
        if (arr2.length != arr1[0].length) {
            System.out.println("Condition not satisfied.");
            return;
        }

        for(int i = 0; i < arr1.length; i++){
            for (int j = 0; j < arr2[0].length; j++){
                result[i][j] = 0;
                for (int k = 0; k < arr2[0].length; k++){
                    result[i][j] += arr1[i][k] * arr2[k][j];

                }
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] arr1 = {{1, 1, 1}, {2, 2, 2}, {3, 3, 3}};
        int[][] arr2 = {{1, 1, 1}, {2, 2, 2}, {3, 3, 3}};
        multiplyMatrix(arr1, arr2);
    }
}
