package org.example.Daily;

public class LC1718 {
    public int[] constructDistancedSequence(int n) {
        int[] ans = new int[2 * n - 1];
        boolean[] visited = new boolean[n + 1];
        backTrack(0, n, ans, visited);
        return ans;
    }

    private boolean backTrack(int i, int n, int[] ans, boolean[] visited) {
        if (i == (2 * n - 1)) {
            return true;
        }
        if (ans[i] != 0)
            return backTrack(i + 1, n, ans, visited);

        for (int j = n; j > 0; j--) {
            if (visited[j])
                continue;
            ans[i] = j;
            visited[j] = true;
            if (j == 1) {
                if (backTrack(i + 1, n, ans, visited)) {
                    return true;
                }
            } else if (i + j < ans.length && ans[i + j] == 0) {
                ans[i + j] = j;
                if (backTrack(i + 1, n, ans, visited)) {
                    return true;
                }
                ans[i + j] = 0;
            }
            visited[j] = false;
            ans[i] = 0;
        }
        return false;
    }
}
