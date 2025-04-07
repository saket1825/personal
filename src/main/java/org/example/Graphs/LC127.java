package org.example.Graphs;

import java.util.*;

public class LC127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        Set<String> words = new HashSet<>();
        words.add(beginWord);
        words.addAll(wordList);

        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        int changes = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String polledWord = q.poll();
                int m = polledWord.length();
                if (polledWord.equals(endWord)) {
                    return changes;
                }
                for (int j = 0; j < m; j++) {
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        char arr[] = polledWord.toCharArray();
                        arr[j] = (char) ch;
                        String str = new String(arr);
                        if (words.contains(str)) {
                            words.remove(str);
                            q.add(str);
                        }
                    }
                }
            }
            changes++;
        }
        return 0;
    }
}
