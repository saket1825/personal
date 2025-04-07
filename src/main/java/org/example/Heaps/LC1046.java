package org.example.Heaps;

import java.util.PriorityQueue;

public class LC1046 {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        for (int stone : stones)
            pq.offer(stone);
        while (pq.size() > 1) {
            pq.offer(Math.abs(pq.poll() - pq.poll()));
        }
        return pq.poll();
    }
}
