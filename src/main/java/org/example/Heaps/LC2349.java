package org.example.Heaps;

import java.util.HashMap;
import java.util.PriorityQueue;

public class LC2349 {
    public LC2349() {
        this.indexToNumMap = new HashMap<>();
        this.numToIndexMap = new HashMap<>();

    }

    HashMap<Integer, PriorityQueue<Integer>> numToIndexMap;
    HashMap<Integer, Integer> indexToNumMap;

    public void change(int index, int number) {
        numToIndexMap.computeIfAbsent(number, k -> new PriorityQueue<>()).add(index);
        indexToNumMap.put(index, number);
    }

    public int find(int number) {
        while (true) {
            if (numToIndexMap.containsKey(number)) {
                PriorityQueue<Integer> pq = numToIndexMap.get(number);
                while (!pq.isEmpty()) {
                    int index = pq.poll();
                    if (indexToNumMap.get(index) == number) {
                        pq.add(index);
                        return index;
                    }
                }
                return -1;
            } else {
                return -1;
            }
        }
    }
}
