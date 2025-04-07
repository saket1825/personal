package org.example.Daily;

import java.util.ArrayList;
import java.util.HashMap;

public class LC2467 {

    ArrayList<ArrayList<Integer>> vertices;
    HashMap<Integer, Integer> nodeToTimeMap;
    int ans = Integer.MIN_VALUE;

    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        vertices = new ArrayList<>();
        nodeToTimeMap = new HashMap<>();
        int n = amount.length;
        for (int i = 0; i < n; i++) {
            vertices.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            vertices.get(edge[0]).add(edge[1]);
            vertices.get(edge[1]).add(edge[0]);
        }
        findBobPath(bob, new boolean[n], 0);
        findAliceMaxCost(0, 0, 0, new boolean[n], amount);
        return ans;
    }

    private void findAliceMaxCost(int source, int time, int income, boolean[] visited, int[] amount) {
        visited[source] = true;
        if (!nodeToTimeMap.containsKey(source) || time < nodeToTimeMap.get(source)) {
            income += amount[source];
        } else if (time == nodeToTimeMap.get(source)) {
            income += amount[source] / 2;
        }
        if (vertices.get(source).size() == 1 && source != 0) {
            ans = Math.max(ans, income);
        }
        for (int adjacentNode : vertices.get(source)) {
            if (!visited[adjacentNode]) {
                findAliceMaxCost(adjacentNode, time + 1, income, visited, amount);
            }
        }
    }

    private boolean findBobPath(int bob, boolean[] visited, int time) {
        visited[bob] = true;
        nodeToTimeMap.put(bob, time);
        if (bob == 0) {
            return true;
        }
        for (int vertex : vertices.get(bob)) {
            if (!visited[vertex] && findBobPath(bob, visited, time + 1)) {
                return true;
            }
        }
        nodeToTimeMap.remove(bob);
        return false;
    }
}
