package org.example.Daily;

public class LC2145 {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = 1; i < differences.length; i++) {
            differences[i] += differences[i - 1];
            min = Math.min(min, differences[i]);
            max = Math.max(max, differences[i]);
        }
        return (upper - lower) - (max - min) + 1;
    }
}
