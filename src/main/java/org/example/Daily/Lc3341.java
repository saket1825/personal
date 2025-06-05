package org.example.Daily;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Lc3341 {
    int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public int minTimeToReach(int[][] moveTime) {
        int rows = moveTime.length;
        int columns = moveTime[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{0, 0, 0});
        int[][] time = new int[rows][columns];

        for(int[] t: time){
            Arrays.fill(t, Integer.MAX_VALUE);
        }
        time[0][0] = 0;
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int currentTime = current[0], x = current[1], y = current[2];
            if(x == rows - 1 && y == columns-1){
                return currentTime;
            }
            // System.out.println(currentTime);

            for (int[] dir : directions) {
                int newX = x + dir[0], newY = y + dir[1];

                if (newX >= 0 && newX < rows && newY >= 0 && newY < columns) {
                    int waitTime = Math.max(moveTime[newX][newY] - currentTime, 0);
                    int newTime = currentTime + 1 + waitTime;

                    if (newTime < time[newX][newY]) {
                        // System.out.println(currentTime);
                        time[newX][newY] = newTime;
                        pq.offer(new int[]{newTime, newX, newY});
                    }
                }
            }
        }
        return -1;
    }
}
