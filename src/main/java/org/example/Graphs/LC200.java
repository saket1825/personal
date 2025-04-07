package org.example.Graphs;

public class LC200 {
    public int numIslands(char[][] grid) {
        int ans = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == '1') {
                    markKaroAageBadho(r, c, grid);
                    ans++;
                }
            }
        }
        return ans;
    }

    private void markKaroAageBadho(int r, int c, char[][] grid) {
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == '0') {
            return;
        }
        grid[r][c] = '0';
        markKaroAageBadho(r, c + 1, grid);
        markKaroAageBadho(r, c - 1, grid);
        markKaroAageBadho(r + 1, c, grid);
        markKaroAageBadho(r - 1, c, grid);
    }
}
