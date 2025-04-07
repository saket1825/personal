package org.example.Daily;

import java.util.Arrays;

public class LC2140 {
    public long mostPoints(int[][] questions) {
        long[] arr = new long[questions.length];
        Arrays.fill(arr, -1);
        return Math.max(recur(questions, 0, arr), recur(questions, 0, arr));
    }

    private long recur(int[][] questions, int i, long[] arr) {
        if (i >= arr.length) {
            return 0;
        }
        if (arr[i] != -1) {
            return arr[i];
        }

        long maxPick = questions[i][0] + recur(questions, i + questions[i][1] + 1, arr);
        long maxNotPick = recur(questions, i + 1, arr);

        return arr[i] = Math.max(maxPick, maxNotPick);

    }
}
