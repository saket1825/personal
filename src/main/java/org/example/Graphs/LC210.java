package org.example.Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC210 {
    // kahn's algoeithm

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> arr = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            arr.add(new ArrayList<Integer>());
        }
        int[] vertices = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            int preSubject = prerequisite[1];
            int subject = prerequisite[0];
            vertices[subject]++;
            arr.get(preSubject).add(subject);
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (vertices[i] == 0) {
                q.add(i);
            }
        }
        int index = 0;
        int[] ans = new int[numCourses];
        while (!q.isEmpty()) {
            int curr = q.poll();
            ans[index++] = curr;
            for (int i : arr.get(curr)) {
                vertices[i]--;
                if (vertices[i] == 0) {
                    q.offer(i);
                }
            }
        }
        if (index == numCourses) return ans;
        else return new int[0];
    }


}
