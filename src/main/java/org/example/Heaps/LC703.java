package org.example.Heaps;

import java.util.PriorityQueue;

public class LC703 {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    int k;

    public LC703(int k, int[] nums) {
        for (int num : nums) {
            pq.add(num);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        this.k = k;
    }

    public int add(int val) {
        pq.add(val);
        if (pq.size() > k) {
            pq.poll();
        }
        return pq.isEmpty() ? -1 : pq.peek();
    }
}
