package leetcode_problems.sheet_arsh.array;

public class WordSearch {

    /*
    79. Word Search
    Given an m x n grid of characters board and a string word, return true if word exists in the grid.
    The word can be constructed from letters of sequentially adjacent cells,
    where adjacent cells are horizontally or vertically neighboring.
    The same letter cell may not be used more than once.
     */

    public static boolean exist(char[][] board, String word) {

        //Each item is iterated because the word can start from any cell.
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (helper(board, word.toCharArray(), 0, i, j)) return true;
            }
        }
        return false;
    }

    private static boolean helper(char[][] board, char[] word, int length, int i, int j) {

        if (length == word.length) return true;
        if (i == board.length || j == board[0].length || i < 0 || j < 0) return false;
        if (board[i][j] != word[length]) return false;

        //This bit-masking (bitwise XOR here) is done as it will perform XOR with char's ASCII value
        //and, store the result, later if in another iteration, this cell came,
        // then it will not match with any of the character and hence returns false.
        // Basically, it reduces the need of separate boolean check array to mark visited or unvisited..
        board[i][j] ^= 256;
        boolean exist = helper(board, word, length + 1, i, j - 1)
                || helper(board, word, length + 1, i - 1, j)
                || helper(board, word, length + 1, i, j + 1)
                || helper(board, word, length + 1, i + 1, j);
        board[i][j] ^= 256;
        return exist;
    }

    public static void main(String[] args) {
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        char[][] board1 = {{'A', 'B', 'C', 'C', 'E', 'D'}};
        System.out.println(exist(board, "ABCCED"));
        System.out.println(exist(board, "SEE"));
        System.out.println(exist(board, "ABCB"));
        System.out.println(exist(board1, "ABCCED"));
    }
}