package org.example.Daily;

import java.util.*;
import java.util.stream.Collectors;

public class LC1311 {
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        Queue<Integer> q = new LinkedList<>();
        q.add(id);
        int levelReached = -1;
        HashMap<String, Integer> map = new HashMap<>();
        HashSet<Integer> visited = new HashSet<>();
        while (!q.isEmpty()) {
            if (levelReached == level) {
                break;
            }
            map = new HashMap<>();
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int popped = q.poll();
                for (int j = 0; j < friends[popped].length; j++) {
                    if (!visited.contains(friends[popped][j]))
                        q.add(friends[popped][j]);
                }
                for (String watchedVideo : watchedVideos.get(popped)) {
                    map.put(watchedVideo, map.getOrDefault(watchedVideo, 0) + 1);
                }
                visited.add(popped);
            }
            levelReached++;
        }

        HashMap<String, Integer> finalMap = map;
        List<String> ans = map.keySet().stream()
                .sorted(Comparator
                        .comparingInt((String key) -> finalMap.get(key))
                        .thenComparing(Comparator.naturalOrder()))
                .toList();
        return ans;
    }
}
