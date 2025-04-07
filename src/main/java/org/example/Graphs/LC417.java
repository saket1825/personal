package org.example.Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC417 {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int R = heights.length;
        int C = heights[0].length;
        boolean[][] pacificOcean = new boolean[R][C];
        boolean[][] atlanticOcean = new boolean[R][C];
        Queue<int[]> pacificQueue = new LinkedList<>();
        Queue<int[]> atlanticQueue = new LinkedList<>();

        for (int c = 0; c < C; c++) {
            pacificOcean[0][c] = true;
            pacificQueue.add(new int[]{0, c});
            atlanticOcean[R - 1][c] = true;
            atlanticQueue.add(new int[]{R - 1, c});
        }
        for (int r = 0; r < R; r++) {
            pacificQueue.add(new int[]{r, 0});
            pacificOcean[r][0] = true;
            atlanticOcean[r][C - 1] = true;
            atlanticQueue.add(new int[]{r, C - 1});
        }
        bfs(heights, pacificOcean, pacificQueue);
        bfs(heights, atlanticOcean, atlanticQueue);
        List<List<Integer>> ans = new ArrayList<>();
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (pacificOcean[r][c] && atlanticOcean[r][c]) {
                    ans.add(List.of(r, c));
                }
            }
        }
        return ans;
    }

    int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    private void bfs(int[][] heights, boolean[][] ocean, Queue<int[]> queue) {
        while (!queue.isEmpty()) {
            int[] coordinates = queue.poll();
            ocean[coordinates[0]][coordinates[1]] = true;
            for (int[] dir : dirs) {
                int currRow = coordinates[0] + dir[0];
                int currCol = coordinates[1] + dir[1];
                if (currRow >= 0 && currCol >= 0
                        && currRow < heights.length && currCol < heights[0].length
                        && heights[currRow][currCol] >= heights[coordinates[0]][coordinates[1]]
                        && !ocean[currRow][currCol]) {
                    queue.offer(new int[]{currRow, currCol});
                }
            }
        }
    }
}
