package org.example.Graphs;

import java.util.ArrayList;
import java.util.HashSet;

public class LC3651 {
    public int countComponents(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            arr.get(edge[0]).add(edge[1]);
            arr.get(edge[1]).add(edge[0]);
        }
        HashSet<Integer> visited = new HashSet<>();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (!visited.contains(i)) {
                dfs(i, -1, visited, arr);
                ans++;
            }
        }
        return ans;
    }

    private boolean dfs(int node, int parent, HashSet<Integer> visited, ArrayList<ArrayList<Integer>> arr) {
        if (visited.contains(node)) {
            return false;
        }
        visited.add(node);
        for (int child : arr.get(node)) {
            if (child == parent) {
                continue;
            }
            if (!dfs(child, node, visited, arr)) {
                return false;
            }
        }
        return true;
    }
}
