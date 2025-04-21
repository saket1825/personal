package org.example.Daily;

import java.util.Arrays;
import java.util.TreeMap;

public class LC2563 {
    public long countFairPairs(int[] nums, int lower, int upper) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(Integer.MIN_VALUE, -1);
        Arrays.sort(nums);
        long ans  = 0;

        for (int i = 0; i < nums.length; i++) {
            int low = lower - nums[i];
            int up = upper - nums[i];

            int left = map.floorEntry(low - 1).getValue();
            int right = map.floorEntry(up).getValue();

            ans += right-left;
            map.put(nums[i],i);
        }
        return ans;
    }
}
