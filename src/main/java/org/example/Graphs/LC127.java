package org.example.Graphs;

import java.util.*;

public class LC127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        if (!set.contains(endWord)) {
            return 0;
        }
        set.add(beginWord);
        set.add(endWord);
        int changes = 0;
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        while (!q.isEmpty()) {
            int n = q.size();
            for (int i = 0; i < n; i++) {
                String popped = q.poll();
                int m = popped.length();
                if (popped.equals(endWord)) {
                    return changes + 1;
                }
                for (int j = 0; j < m; j++) {
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        char[] arr = popped.toCharArray();
                        arr[j] = (char) ch;
                        String newString = new String(arr);
                        if (wordList.contains(newString)) {
                            q.add(newString);
                            set.remove(newString);
                        }
                    }
                }
            }
            changes++;
        }
        return 0;
    }
}
