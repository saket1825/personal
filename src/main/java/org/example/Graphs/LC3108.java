package org.example.Graphs;

import java.util.Arrays;

public class LC3108 {
    int[] size;
    int[] parent;

    public int[] minimumCost(int n, int[][] edges, int[][] queries) {
        parent = new int[n];
        size = new int[n];
        int[] componentCost = new int[n];
        Arrays.fill(parent, -1);
        Arrays.fill(size, 1);
        Arrays.fill(componentCost, Integer.MAX_VALUE);

        for (int[] edge : edges) {
            union(edge[0], edge[1]);
        }

        for (int[] edge : edges) {
            int root = find(edge[0]);
            componentCost[root] &= edge[2];
        }

        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int find1 = find(queries[i][0]);
            int find2 = find(queries[i][1]);
            if (find1 == find2) {
                ans[i] = componentCost[find1];
            }else{
                ans[i] = -1;
            }
        }

        return null;
    }

    private void union(int u, int v) {
        int repU = find(u);
        int repV = find(v);
        if (repU == repV) {
            return;
        }
        if (size[repU] > size[repV]) {
            int temp = repU;
            repU = repV;
            repV = temp;
        }
        parent[repU] = repV;
        size[repV] += size[repU];
    }

    private int find(int u) {
        if (parent[u] == -1) {
            return u;
        } else {
            return find(parent[u]);
        }
    }

//    public static void main(String[] args) {
//        int[][] edge = new int[][]{{0, 1}, {1, 3}, {1, 2}, {4, 5}};
//        minimumCost(6, edge, null);
//    }
}
//
//0----1
//        |
//        |
//        3