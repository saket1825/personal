package org.example.DP;

import java.util.Arrays;

public class LC213 {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length < 4) {
            return Arrays.stream(nums).max().orElse(0);
        }
        return Math.max(individualAnswers(Arrays.copyOfRange(nums, 0, nums.length - 1)), individualAnswers(Arrays.copyOfRange(nums, 1, nums.length)));
    }

    private int individualAnswers(int[] houses) {
        int[] dp = new int[houses.length];
        dp[0] = houses[0];
        dp[1] = Math.max(houses[0], houses[1]);
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + houses[i]);
        }
        return dp[dp.length - 1];
    }
}
