package org.example.Graphs;

import java.util.ArrayList;
import java.util.HashSet;

public class LC178 {
    public boolean validTree(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        HashSet<Integer> set = new HashSet<>();
        if (!dfs(0, -1, set, graph)) {
            return false;
        }
        return set.size() == n;
    }

    private boolean dfs(int node, int parent, HashSet<Integer> visit, ArrayList<ArrayList<Integer>> graph) {
        if(visit.contains(node)){
            return false;
        }
        visit.add(node);
        for(int child : graph.get(node)){
            if(child == parent){
                continue;
            }
            if (!dfs(child, node, visit, graph)) {
                return false;
            }
        }
        return true;
    }
}
