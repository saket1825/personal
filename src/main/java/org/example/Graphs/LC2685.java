package org.example.Graphs;

import java.util.*;

public class LC2685 {
    public int countCompleteComponents(int n, int[][] edges) {
        List<Integer>[] matrix = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            matrix[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            matrix[edge[0]].add(edge[1]);
            matrix[edge[1]].add(edge[0]);
        }

        int count = 0;
        Set<Integer> visit = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (visit.contains(i))
                continue;
            int[] dfsAns = new int[2];
            dfsKaro(i, matrix, visit, dfsAns);
            if (dfsAns[0] * (dfsAns[0] - 1) == dfsAns[1]) {
                count++;
            }
        }
        return count;
    }

    private void dfsKaro(int i, List<Integer>[] matrix, Set<Integer> visit, int[] dfsAns) {
        visit.add(i);
        dfsAns[0]++;
        dfsAns[1] += matrix[i].size();
        for (int agla : matrix[i]) {
            if (!visit.contains(agla)) {
                dfsKaro(agla, matrix, visit, dfsAns);
            }
        }
    }


    public int countCompleteComponentsDSU(int n, int[][] edges) {
        UnionFind unionFind = new UnionFind(n);
        for (int[] edge : edges) {
            unionFind.connect(edge[0], edge[1]);
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] edge : edges) {
            int parent = unionFind.find(edge[0]);
            map.put(parent, map.getOrDefault(parent, 0) + 1);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            // Agar parebnt hu
            if (unionFind.find(i) == i) {
                int vertices = unionFind.size[i];
                int expectationsMostlyExceeded = vertices * (vertices - 1) / 2;
                if (map.get(i) == expectationsMostlyExceeded) {
                    ans++;
                }
            }
        }
        return ans;
    }

    static class UnionFind {
        int n;
        int[] parent;
        int[] size;

        public UnionFind(int n) {
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = i;
            }
        }

        public int find(int u) {
            if (u == parent[u]) {
                return u;
            }
            return parent[u] = find(parent[u]);
        }

        public boolean connect(int u, int v) {
            int pU = find(u);
            int pV = find(v);
            if (pV == pU) {
                return false;
            }
            if (size[pV] > size[pU]) {
                parent[pU] = pV;
                size[pV] += size[pU];
            } else {
                parent[pV] = pU;
                size[pU] += size[pV];
            }
            return true;
        }

    }
}
