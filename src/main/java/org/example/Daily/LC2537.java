package org.example.Daily;

import java.util.HashMap;

public class LC2537 {
    public long countGood(int[] nums, int k) {
        long ans = 0;
        HashMap<Integer, Integer> freq = new HashMap<>();
        int validPairs = 0;
        for (int i = 0, j = -1; i < nums.length; i++) {
            while (validPairs < k && j + 1 < nums.length) {
                j++;
                validPairs += freq.getOrDefault(nums[j], 0);
                freq.put(nums[j], freq.getOrDefault(nums[j], 0) + 1);
            }
            if (validPairs >= k) {
                ans += nums.length - j;
            }
            freq.put(nums[i], freq.get(nums[i]) - 1);
            validPairs -= freq.get(nums[i]);
        }
        return ans;
    }
}
