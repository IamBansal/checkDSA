package leetcode_problems.leetcode_backtracking;

import java.util.LinkedList;
import java.util.List;

public class Question3 {

    /*

    N-QUEENS PROBLEM

    The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.

    Given an integer n, return all distinct solutions to the n-queens puzzle.
    You may return the answer in any order.

    Each solution contains a distinct board configuration of the n-queens placement,
    where 'Q' and '.' both indicate a queen and an empty space, respectively.

     */

    public static List<List<String>> solveNQueens(int n) {

        List<List<String>> ans = new LinkedList<>();
        List<String> board = new LinkedList<>();
        List<Integer> leftRow = new LinkedList<>();
        List<Integer> upperDiagonal = new LinkedList<>();
        List<Integer> lowerDiagonal = new LinkedList<>();
        for (int i = 0; i <= n * n - 1; i++) {
            board.add(".");
        }

        solve(0, board, leftRow, upperDiagonal, lowerDiagonal, ans, n);
        return ans;

    }

    private static void solve(int column, List<String> board, List<Integer> leftRow, List<Integer> upperDiagonal, List<Integer> lowerDiagonal, List<List<String>> ans, int n) {

        if (column == n) {
            ans.add(construct(board));
            return;
        }

        for (int row = 0; row < n; row++) {
            if (!leftRow.contains(row) && !upperDiagonal.contains(n - 1 + column - row) && !lowerDiagonal.contains(row + column)) {
                board.set(n * row + column, "Q");
                leftRow.add(row);
                upperDiagonal.add(n - 1 + column - row);
                lowerDiagonal.add(row + column);
                solve(column + 1, board, leftRow, upperDiagonal, lowerDiagonal, ans, n);
                board.set(n * row + column, ".");
                leftRow.remove((Integer) row);
                upperDiagonal.remove((Integer) (n - 1 + column - row));
                lowerDiagonal.remove((Integer) (row + column));
            }
        }
    }

    static List<String> construct(List<String> board) {
        List<String> res = new LinkedList<>();
        int n = (int) Math.sqrt(board.size());

        StringBuilder str = new StringBuilder();
        for (String s : board) {
            str.append(s);
        }

        for (int i = 0; i < board.size(); i = i + n) {
            String string = str.substring(i, i + n);
            res.add(string);
        }
        return res;
    }

    //Better answer - STRIVER

    /*

    public static List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                board[i][j] = '.';
        List<List<String>> res = new ArrayList<>();
        int[] leftRow = new int[n];
        int[] upperDiagonal = new int[2 * n - 1];
        int[] lowerDiagonal = new int[2 * n - 1];
        solve(0, board, res, leftRow, lowerDiagonal, upperDiagonal);
        return res;
    }

    static void solve(int col, char[][] board, List<List<String>> res, int[] leftRow, int[] lowerDiagonal, int[] upperDiagonal) {
        if (col == board.length) {
            res.add(construct(board));
            return;
        }

        for (int row = 0; row < board.length; row++) {
            if (leftRow[row] == 0 && lowerDiagonal[row + col] == 0 && upperDiagonal[board.length - 1 + col - row] == 0) {
                board[row][col] = 'Q';
                leftRow[row] = 1;
                lowerDiagonal[row + col] = 1;
                upperDiagonal[board.length - 1 + col - row] = 1;
                solve(col + 1, board, res, leftRow, lowerDiagonal, upperDiagonal);
                board[row][col] = '.';
                leftRow[row] = 0;
                lowerDiagonal[row + col] = 0;
                upperDiagonal[board.length - 1 + col - row] = 0;
            }
        }
    }

    static List<String> construct(char[][] board) {
        List<String> res = new LinkedList<>();
        for (char[] chars : board) {
            String s = new String(chars);
            res.add(s);
        }
        return res;
    }

    public static void main(String[] args) {
        int N = 4;
        List<List<String>> queen = solveNQueens(N);
        for (List<String> it : queen) {
            System.out.println("Arrangement ");
            for (String s : it) {
                System.out.println(s);
            }
            System.out.println();
        }

    }

     */

    public static void main(String[] args) {
        List<List<String>> ans = solveNQueens(4);
        for (List<String> an : ans) {
            System.out.println("Arrangement...");
            for (String s : an) {
                System.out.println(s);
            }
            System.out.println();
        }

    }


}
