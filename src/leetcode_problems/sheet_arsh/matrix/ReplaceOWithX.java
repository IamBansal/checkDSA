package leetcode_problems.sheet_arsh.matrix;

public class ReplaceOWithX {

    /*
    GFG Problem
    Replace O's with X's
    Given a matrix mat of size N x M where every element is either O or X.
    Replace all O with X that are surrounded by X.
    A O (or a set of O) is considered to be surrounded by X if there are X at locations just below,
    just above, just left and just right of it.
     */

    public static char[][] fill(int n, int m, char[][] a) {

        for (int i = 1; i <= n - 2; i++) {
            for (int j = 1; j <= m - 2; j++) {
                if (a[i][j] == 'O') a[i][j] = '-';
            }
        }

        boolean[][] check = new boolean[n][m];

        for (int i = 1; i <= n - 2; i++) {
            for (int j = 1; j <= m - 2; j++) {
                if (a[i][j] == '-') floodFill(a, i, j, check);
            }
        }

        return a;
    }

    private static boolean floodFill(char[][] a, int i, int j, boolean[][] check) {
        if (check[i][j]) return true;
        check[i][j] = true;
        if (i == 0 || j == 0 || i == a.length - 1 || j == a[0].length - 1) return a[i][j] != 'O';
        if (a[i][j] == 'X') return true;
        boolean bool = false;

        if (a[i][j] == '-') {
            bool = floodFill(a, i - 1, j, check) && floodFill(a, i + 1, j, check) && floodFill(a, i, j + 1, check) && floodFill(a, i, j - 1, check);
            if (bool) a[i][j] = 'X';
            else a[i][j] = 'O';
        }

        return bool;
    }

    public static void main(String[] args) {
        char[][] a = {{'X', 'X', 'X', 'X'},
                {'X', 'O', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'O', 'X', 'X'},
                {'X', 'X', 'O', 'O'}};
        printArray(fill(5, 4, a));

        char[][] b = {{'X', 'O', 'X', 'X', 'X', 'X'},
                {'X', 'O', 'X', 'X', 'O', 'X'},
                {'X', 'X', 'X', 'O', 'O', 'X'},
                {'O', 'X', 'X', 'X', 'X', 'X'},
                {'X', 'X', 'X', 'O', 'X', 'O'},
                {'O', 'O', 'X', 'O', 'O', 'O'}};
        printArray(fill(6, 6, b));
    }

    public static void printArray(char[][] matrix) {
        //Print the result
        for (char[] array : matrix) {
            for (char num : array) System.out.print(num + " ");
            System.out.println();
        }
        System.out.println();
    }
}
