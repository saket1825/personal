package org.example.Graphs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class LC994 {
    public int orangesRotting(int[][] grid) {
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
        Queue<int[]> queue = new LinkedList<>();
        int numberOfOranges = 0;
        int ans = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 2) {
                    queue.offer(new int[]{r, c});
                }
                if (grid[r][c] == 2 || grid[r][c] == 1) {
                    numberOfOranges++;
                }
            }
        }
        int rottenOranges = 0;
        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                int[] currOrange = queue.poll();
                rottenOranges++;
                int currRow = currOrange[0];
                int currCol = currOrange[1];
                for (int[] dir : dirs) {
                    int nextRow = currRow + dir[0];
                    int nextCol = currCol + dir[1];
                    if (nextRow < 0 || nextCol < 0 || nextRow >= grid.length || nextCol >= grid[0].length || grid[nextRow][nextCol] != 1) {
                        continue;
                    }
                    grid[nextRow][nextCol] = 2;
                    queue.offer(new int[]{nextRow, nextCol});
                }
            }
            ans++;
        }
        return numberOfOranges == 0 ? 0 : rottenOranges == numberOfOranges ? ans - 1 : -1;
    }

    public String removeOccurrences(String s, String part) {
        Stack<Character> st = new Stack<>();
        int n = s.length();
        int m = part.length();
        for (int i = 0; i < n; i++) {
            st.push(s.charAt(i));
            if (st.size() >= m) {
                String x = "";
                for (int j = m - 1; j >= 0; j--) {
                    char ch = part.charAt(j);
                    if (ch != st.peek()) {
                        for (int k = 0; k < x.length(); k++) {
                            st.push(x.charAt(k));
                        }
                        break;
                    } else {
                        x = st.peek() + x;
                        st.pop();
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while (st.size() != 0) {
            sb.append(st.pop());
        }
        sb.reverse();
        return sb.toString();
    }
}
