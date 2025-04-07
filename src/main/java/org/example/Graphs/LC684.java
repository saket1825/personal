package org.example.Graphs;

import java.util.ArrayList;

public class LC684 {
    public int[] findRedundantConnection(int[][] edges) {
        int[] parent = new int[edges.length + 1];
        int[] size = new int[edges.length + 1];
        for (int i = 0; i < edges.length + 1; i++) {
            parent[i] = i;
            size[i] = 1;
        }
        for (int[] edge : edges) {
            if (!union(edge[0], edge[1], parent, size)) {
                return new int[]{edge[0], edge[1]};
            }
        }
        return new int[0];
    }

    private boolean union(int a, int b, int[] parent, int[] size) {
        int parentA = findRep(a, parent);
        int parentB = findRep(b, parent);
        if (parentA == parentB) {
            return false;
        }
        int sizeA = size[parentA];
        int sizeB = size[parentB];
        if (sizeA >= sizeB) {
            parent[parentB] = parentA;
            size[parentA] += sizeB;
        } else {
            parent[parentA] = parentB;
            size[parentB] += sizeA;
        }
        return true;
    }

    private int findRep(int a, int[] parent) {
        if (parent[a] == a) {
            return a;
        }
        return parent[a] = findRep(parent[a], parent);
    }
}
