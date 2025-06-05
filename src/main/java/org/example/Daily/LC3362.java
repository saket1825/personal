package org.example.Daily;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class LC3362 {
    public int maxRemoval(int[] nums, int[][] queries) {
        Arrays.sort(queries, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int[] lineSweep = new int[nums.length + 1];
        int ops = 0;
        for (int i = 0, j = 0; i < nums.length; i++) {
            ops += lineSweep[i];
            while (j < queries.length && queries[j][0] == i) {
                pq.add(queries[j][1]);
                j++;
            }

            while (ops < nums[i] && !pq.isEmpty() && pq.peek() >= i) {
                ops += 1;
                lineSweep[pq.poll() + 1] -= 1;
            }
            if (ops < nums[i]) {
                return -1;
            }
        }
        return pq.size();
    }
}
