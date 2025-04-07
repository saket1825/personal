package org.example.Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class LC663 {
    int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public void islandsAndTreasure(int[][] grid) {
        int gateConst = 2147483647;
        Queue<int[]> queue = new LinkedList<>();
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 0) {
                    queue.offer(new int[]{r, c});
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int currRow = curr[0];
            int currColumn = curr[1];
            System.out.println(currRow + " " + currColumn + " " + grid[currRow][currColumn] + " " + queue.size());
            for (int[] dir : dirs) {
                int nextRow = currRow + dir[0];
                int nextColumn = currColumn + dir[1];
                if (nextRow < 0 || nextColumn < 0 || nextRow >= grid.length || nextColumn >= grid[0].length || grid[nextRow][nextColumn] == -1) {
                    System.out.println("Continuing");
                    continue;
                }
                if (grid[nextRow][nextColumn] == gateConst) {
                    grid[nextRow][nextColumn] = grid[currRow][currColumn] + 1;
                    queue.offer(new int[]{nextRow, nextColumn});
                }
            }
        }
    }
}
