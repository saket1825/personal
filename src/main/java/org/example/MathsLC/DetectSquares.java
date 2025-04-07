package org.example.MathsLC;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DetectSquares {
    List<int[]> points;
    Map<String, Integer> frequencyMap;

    public DetectSquares() {
        points = new ArrayList<>();
        frequencyMap = new HashMap<>();
    }

    public void add(int[] point) {
        String key = point[0] + "," + point[1];
        if (frequencyMap.containsKey(key)) {
            frequencyMap.put(key, frequencyMap.get(key) + 1);
        } else {
            frequencyMap.put(key, 1);
            points.add(point);
        }
    }

    public int count(int[] point) {
        int pointX = point[0];
        int pointY = point[1];
        int sum = 0;
        for (int[] pointToConsider : points) {
            int currX = pointToConsider[0];
            int currY = pointToConsider[1];
            if (pointX == currX || pointY == currY || Math.abs(pointX - currX) != Math.abs(pointY - currY)) {
                continue;
            }
            sum += frequencyMap.getOrDefault(pointX + "," + currY, 0) * frequencyMap.getOrDefault(currX + "," + pointY, 0) * frequencyMap.getOrDefault(currX + "," + currY, 0);
        }
        return sum;
    }
}
