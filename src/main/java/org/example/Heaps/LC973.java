package org.example.Heaps;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LC973 {
    public int[][] kClosest(int[][] points, int k) {
        int[] distances = new int[points.length];
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> distances[b] - distances[a]);
        for (int i = 0; i < points.length; i++) {
            distances[i] = points[i][0] * points[i][0] + points[i][1] * points[i][1];
            pq.offer(i);
            //System.out.println(pq);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        int[][] ans = new int[pq.size()][2];
        int i = 0;
        while (!pq.isEmpty()) {
            int index = pq.poll();
            ans[i] = points[index];
            i++;
        }
        return ans;
    }
}
