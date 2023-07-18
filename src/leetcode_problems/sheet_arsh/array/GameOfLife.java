package leetcode_problems.sheet_arsh.array;

public class GameOfLife {

    /*
    289. Game of Life
    According to Wikipedia's article: "The Game of Life, also known simply as Life,
    is a cellular automaton devised by the British mathematician John Horton Conway in 1970."

    The board is made up of an m x n grid of cells, where each cell has an initial state:
    live (represented by a 1) or dead (represented by a 0).
    Each cell interacts with its eight neighbors (horizontal, vertical, diagonal)
    using the following four rules (taken from the above Wikipedia article):
    - Any live cell with fewer than two live neighbors dies as if caused by under-population.
    - Any live cell with two or three live neighbors lives on to the next generation.
    - Any live cell with more than three live neighbors dies, as if by over-population.
    - Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.

    The next state is created by applying the above rules simultaneously to every cell in the
    current state, where births and deaths occur simultaneously.
    Given the current state of the m x n grid board, return the next state.
     */

    public static void gameOfLife(int[][] board) {

        int[][] result = new int[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int liveNeigh = countLiveNeighbours(board, i, j);
                if (board[i][j] == 0) {
                    if (liveNeigh == 3) result[i][j] = 1;
                } else {
                    if (liveNeigh == 2 || liveNeigh == 3) result[i][j] = 1;
                }

            }
        }

        for (int i = 0; i < board.length; i++){
            System.arraycopy(result[i], 0, board[i], 0, board[0].length);
        }

        for (int[] arr : board) {
            for (int num : arr) System.out.print(num + " ");
            System.out.println();
        }
        System.out.println();

    }

    private static int countLiveNeighbours(int[][] board, int i, int j) {

        int count = 0;

        //Up
        if (i != 0) {
            if (board[i - 1][j] == 1) count++;
        }
        //Down
        if (i != board.length - 1) {
            if (board[i + 1][j] == 1) count++;
        }
        //left
        if (j != 0) {
            if (board[i][j - 1] == 1) count++;
        }
        //right
        if (j != board[0].length - 1) {
            if (board[i][j + 1] == 1) count++;
        }

        //left up
        if (i != 0 && j != 0) {
            if (board[i - 1][j - 1] == 1) count++;
        }

        //left down
        if (i != board.length - 1 && j != 0) {
            if (board[i + 1][j - 1] == 1) count++;
        }

        //right up
        if (i != 0 && j != board[0].length - 1) {
            if (board[i - 1][j + 1] == 1) count++;
        }

        //right down
        if (i != board.length - 1 && j != board[0].length - 1) {
            if (board[i + 1][j + 1] == 1) count++;
        }

        return count;
    }

    public static void main(String[] args) {
        int[][] board = {{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}};
        gameOfLife(board);
        int[][] board1 = {{1, 1}, {1, 0}};
        gameOfLife(board1);
    }
}
