package org.example.Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC207 {
    // kahn's algorithm indegree 0 se process start karo aur fir jo jo 0 ho raha hai usko enQ karo BFS
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] vertex = new int[numCourses];
        List<List<Integer>> nodes = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            nodes.add(new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            int preSubject = prerequisite[1];
            int subject = prerequisite[0];
            vertex[subject]++;
            nodes.get(preSubject).add(subject);
        }
        for (int i = 0; i < nodes.size(); i++) {
            List<Integer> node = nodes.get(i);
            for (int value : node) {
                System.out.println(value + " " + i);
            }
            System.out.println();
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
//            System.out.println(i + " " + vertex[i]);
            if (vertex[i] == 0) {
                q.offer(i);
            }
        }
        int processed = 0;
        while (!q.isEmpty()) {
            processed++;
            int lastSubject = q.poll();
            for (int children : nodes.get(lastSubject)) {
                vertex[children]--;
                if (vertex[children] == 0) {
                    q.offer(children);
                }
            }
        }
//        System.out.println(processed);

        return processed == numCourses;
    }
}
