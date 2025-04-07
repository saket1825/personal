package org.example.Heaps;

import java.util.HashMap;

public class LC2364 {

    public long countBadPairs(int[] a) {
        long cnt = 0;
        HashMap<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            int prev = mp.getOrDefault(i - a[i], 0);
            cnt += i - prev;
            mp.put(i - a[i], prev + 1);
        }
        return cnt;
    }
}
