package leetcode_problems.sheet_arsh.stacks_queues;

public class DistanceOfNearestCellHaving1 {

    /*
    GFG Problem

    Distance of the nearest cell having 1
    Given a binary grid of n*m. Find the distance of the nearest 1 in the grid for each cell.
    The distance is calculated as |i1  - i2| + |j1 - j2|, where i1, j1 are the row and column number
    of the current cell n i2, j2 are the row and column number of the nearest cell having value 1.
    There should be at least one 1 in the grid.
     */

    public static void nearest(int[][] grid) {
        int[][] result = new int[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                if (grid[i][j] == 1) result[i][j] = 0;
                else result[i][j] = minDis(grid, i, j, i, j, result);
            }
        }

        for (int[] ints: result){
            for (int num: ints) System.out.print(num + " ");
            System.out.println();
        }
    }

    private static int minDis(int[][] grid, int i, int j, int i1, int j1, int[][] result) {
        if (i < 0 || j < 0 || i == grid.length || j == grid[0].length) return 99999999;

        if (grid[i][j] == 1) return Math.abs(i - i1) + Math.abs(j - j1);

        int up = 0, upLeft = 0, upRight = 0, left = 0;
        if (i > 0) up = 1 + result[i - 1][j];
//        minDis(grid, i - 1, j, i1, j1, result);
        if (i > 0 && j > 0) upLeft = 2 + result[i - 1][j - 1];
//        minDis(grid, i - 1, j - 1, i1, j1, result);
        if (i > 0 && j < grid[0].length - 1) upRight = 2 + result[i - 1][j + 1];
//        minDis(grid, i - 1, j + 1, i1, j1, result);

        int down = minDis(grid, i + 1, j, i1, j1, result);
        int downLeft = minDis(grid, i + 1, j - 1, i1, j1, result);
        int downRight = minDis(grid, i + 1, j + 1, i1, j1, result);

        if (j > 0) left = 1 + result[i][j - 1];
//        minDis(grid, i, j - 1, i1, j1, result);
        int right = minDis(grid, i, j + 1, i1, j1, result);

        return Math.min(up, Math.min(upLeft, Math.min(upRight, Math.min(downLeft, Math.min(downRight, Math.min(down, Math.min(left, right)))))));
    }

    public static void main(String[] args) {
        nearest(new int[][]{{0,1,1,0},{1,1,0,0},{0,0,1,1}});
        System.out.println();
        nearest(new int[][]{{1,0,1},{1,1,0},{1,0,0}});
    }
}