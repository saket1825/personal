package org.example.Graphs;

import java.util.Arrays;

public class DSU {
    int[] parent;
    int[] size;
    int n;

    public DSU(int n) {
        this.parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        this.size = new int[n];
        Arrays.fill(size, 1);
        this.n = n;
    }

    public boolean makeUnion(int a, int b) {
        int parentA = findRep(a);
        int parentB = findRep(b);

        if (parentA != parentB) {
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
        return false;
    }

    private int findRep(int a) {
        if (a == parent[a]) {
            return a;
        }
        return parent[a] = findRep(parent[a]);
    }

    private void printParent() {
        for (int i = 0; i < n; i++) {
            System.out.println(parent[i] + " is parent of " + i);
        }

        System.out.println();
    }

    private void printSize() {
        for (int i = 0; i < n; i++) {
            System.out.println(size[i] + " is parent of " + i);
        }

        System.out.println();
    }

    public static void main(String[] args) {
        DSU dsu = new DSU(6);
        dsu.makeUnion(1, 2);
        dsu.printParent();
        dsu.makeUnion(1, 3);
        dsu.printParent();
        dsu.makeUnion(4, 5);
        dsu.printParent();
        dsu.makeUnion(3, 5);
        dsu.printParent();
        dsu.printSize();
    }
}
