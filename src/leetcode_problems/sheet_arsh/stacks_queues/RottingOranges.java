package leetcode_problems.sheet_arsh.stacks_queues;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {

    /*
    994. Rotting Oranges
    You are given an m x n grid where each cell can have one of three values:
    - 0 representing an empty cell,
    - 1 representing a fresh orange, or
    - 2 representing a rotten orange.
    Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.
    Return the minimum number of minutes that must elapse until no cell has a fresh orange.
    If this is impossible, return -1.
     */

    public static int orangesRotting(int[][] grid) {
        int totalMin = 0, totalOranges = 0, rottenCount = 0;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) queue.offer(new int[]{i, j});
                if (grid[i][j] != 0) totalOranges++;
            }
        }

        if (totalOranges == 0) return 0;

        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        while (!queue.isEmpty()) {
            int size = queue.size();
            rottenCount += size;

            for (int i = 0; i < size; i++) {
                int[] point = queue.poll();

                for (int j = 0; j < 4; j++) {
                    int x = point[0] + dx[j];
                    int y = point[1] + dy[j];

                    if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == 2 || grid[x][y] == 0) continue;

                    grid[x][y] = 2;
                    queue.offer(new int[]{x, y});
                }
            }
            if (queue.size() != 0) totalMin++;
        }

        return totalOranges == rottenCount ? totalMin : -1;
    }

    public static void main(String[] args) {
        System.out.println(orangesRotting(new int[][]{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}}));
    }
}
