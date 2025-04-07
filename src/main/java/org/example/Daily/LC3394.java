package org.example.Daily;

import java.util.Arrays;
import java.util.Comparator;

public class LC3394 {
    public boolean checkValidCuts(int n, int[][] rectangles) {
        return checkCuts(rectangles, 0) || checkCuts(rectangles, 1);
    }

    private boolean checkCuts(int[][] rectangles, int x) {
        Arrays.sort(rectangles, Comparator.comparingInt(a -> a[x]));
        int partition = 0, lastEnd = rectangles[0][x];

        for (int i = 0;i<rectangles.length;i++) {
            int[] rectangle = rectangles[i];
            if (rectangle[x] >= lastEnd) {
                partition++;
                if(partition == 2){
                    return true;
                }
            }
            lastEnd = Math.max(lastEnd, rectangle[x+2]);
        }
        return false;
    }
}
