package org.example.Heaps;

import java.util.Collections;
import java.util.PriorityQueue;

public class LC295 {
    public LC295() {
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap = new PriorityQueue<>();
    }

    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    int length;

    public void addNum(int num) {
        maxHeap.add(num);
        if (!minHeap.isEmpty() && maxHeap.peek() > minHeap.peek()) {
            minHeap.add(maxHeap.poll());
        }
        if (maxHeap.size() - minHeap.size() > 1) {
            minHeap.add(maxHeap.poll());
        } else if (minHeap.size() > maxHeap.size()) {
            maxHeap.add(minHeap.poll());
        }
        length++;
    }

    public double findMedian() {
        if ((length & 1) == 1) {
            return maxHeap.peek();
        } else {
            return (minHeap.peek() * 1.0 + maxHeap.peek() * 1.0) / 2;
        }
    }
}
