package org.example.Daily;

import java.util.HashMap;

public class LC873 {
    public int lenLongestFibSubseq(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }
        int ans = 0;
        int[][] dp = new int[arr.length][arr.length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                int diff = arr[i] - arr[j];
                int index = map.getOrDefault(diff, -1);
                if (index >= 0 && arr[j] > diff) {
                    dp[i][j] = Math.max(dp[j][index] + 1, dp[i][j]);
                } else {
                    dp[i][j] = 2;
                }
                ans = Math.max(dp[i][j], ans);
            }
        }
        return ans;
    }
}
