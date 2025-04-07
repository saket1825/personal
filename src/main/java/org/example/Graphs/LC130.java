package org.example.Graphs;

import java.util.ArrayList;

public class LC130 {
    public void solve(char[][] board) {
        int ROW = board.length;
        int COL = board[0].length;
        boolean[][] visited = new boolean[ROW][COL];
        for (int r = 0; r < ROW; r++) {
            for (int c = 0; c < COL; c++) {
                if (board[r][c] == 'O' && !visited[r][c]) {
                    ArrayList<int[]> borderElements = new ArrayList<>();
                    dfs(board, r, c, borderElements, visited);
                    if (!borderElements.isEmpty()) {
                        modifyBoard(board, borderElements);
                    }
                }
            }
        }
    }

    private void modifyBoard(char[][] board, ArrayList<int[]> borderElements) {
        boolean shouldModify = true;
        for (int[] coordinates : borderElements) {
            int row = coordinates[0];
            int col = coordinates[1];
            if (board.length - 1 == row || row == 0) {
                shouldModify = false;
            }
            if (board[0].length - 1 == col || col == 0) {
                shouldModify = false;
            }
        }
        if (shouldModify) {
            for (int[] coordinates : borderElements) {
                int row = coordinates[0];
                int col = coordinates[1];
                board[row][col] = 'X';
            }
        }
    }

    int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    private void dfs(char[][] board, int r, int c, ArrayList<int[]> borderElements, boolean[][] visited) {
        if (visited[r][c]) {
            return;
        }
        visited[r][c] = true;
        boolean isAnyOrderXOrEnd = false;
        for (int[] dir : dirs) {
            int row = r + dir[0];
            int col = c + dir[1];
            if (row < 0 || col < 0 || row >= board.length || col >= board[0].length) {
                isAnyOrderXOrEnd = true;
                continue;
            }
            if (board[row][col] == 'X') {
                isAnyOrderXOrEnd = true;
            } else {
                dfs(board, row, col, borderElements, visited);
            }
        }
        if (isAnyOrderXOrEnd) {
            borderElements.add(new int[]{r, c});
        }
    }


    public static class Solution { // better correct : border ke saare
        // O se reachable ko T mark kardo fir jo O bach gaye hain unko X kar do aur jo T reh gaye hain unko O kar do
        private int ROWS, COLS;

        public void solve(char[][] board) {
            ROWS = board.length;
            COLS = board[0].length;

            for (int r = 0; r < ROWS; r++) {
                if (board[r][0] == 'O') {
                    capture(board, r, 0);
                }
                if (board[r][COLS - 1] == 'O') {
                    capture(board, r, COLS - 1);
                }
            }

            for (int c = 0; c < COLS; c++) {
                if (board[0][c] == 'O') {
                    capture(board, 0, c);
                }
                if (board[ROWS - 1][c] == 'O') {
                    capture(board, ROWS - 1, c);
                }
            }

            for (int r = 0; r < ROWS; r++) {
                for (int c = 0; c < COLS; c++) {
                    if (board[r][c] == 'O') {
                        board[r][c] = 'X';
                    } else if (board[r][c] == 'T') {
                        board[r][c] = 'O';
                    }
                }
            }
        }

        private void capture(char[][] board, int r, int c) {
            if (r < 0 || c < 0 || r >= ROWS ||
                    c >= COLS || board[r][c] != 'O') {
                return;
            }
            board[r][c] = 'T';
            capture(board, r + 1, c);
            capture(board, r - 1, c);
            capture(board, r, c + 1);
            capture(board, r, c - 1);
        }
    }
}
