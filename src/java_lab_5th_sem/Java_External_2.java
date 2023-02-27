package java_lab_5th_sem;

public class Java_External_2 {

    public static void multiplyMatrix(int[][] arr1, int[][] arr2) {

        if (arr1[0].length != arr2.length) {
            System.out.println("Can't perform multiplication with this order.");
            return;
        }

        int[][] result = new int[arr1.length][arr2[0].length];

        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2[0].length; j++) {
                result[i][j] = 0;
                for (int k = 0; k < arr2[0].length; k++) {
                    result[i][j] += arr1[i][k] * arr2[k][j];

                }
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {

        int[][] arr1 = {{1, 2, 3}, {3, 2, 1}, {0, 1, 2}};
        int[][] arr2 = {{3, 2, 1}, {0, 0, 0}, {1, 2, 3}};
        multiplyMatrix(arr1, arr2);


    }

}
