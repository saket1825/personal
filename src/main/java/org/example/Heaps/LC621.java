package org.example.Heaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class LC621 {

//    public int leastInterval(char[] tasks, int n) {
//        HashMap<Character, Integer> map = new HashMap<>();
//        for(char ch : tasks){
//            map.put(ch, map.getOrDefault(ch, 0) + 1);
//        }
//        PriorityQueue<Character>
//    }


//    public int[][] sortMatrix(int[][] grid) {
//        int n = grid.length;
//        int[][] ans = new int[n][n];
//        for(int c = 0;c<n; c++){
//            ArrayList<Integer> currList = new ArrayList<>();
//            int i = 0;
//            for(int r = 0;r<n && i<n;r++){
//                currList.add(grid[r][i])
//            }
//        }
//
//    }

    public int[] assignElements(int[] groups, int[] elements) {
        int[] ans = new int[groups.length];
        Arrays.fill(ans, -1);
        for (int i = 0; i < elements.length; i++) {
            for (int j = 0; j < groups.length; j++) {
                if (ans[j] == -1) {
                    if (groups[j] % elements[i] == 0) {
                        ans[j] = i;
                    }
                }
            }
        }
        return ans;
    }

//    public long maxScore(int[] points, int m) {
//        int n = points.length;
//        if (m < n) {
//            return Arrays.stream(points).min().orElse(0);
//        }
//        PriorityQueue<Integer> pq = new PriorityQueue<>();
//
//    }
}
