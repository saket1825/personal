package org.example.Daily;

public class LC1749 {
    public int maxAbsoluteSum(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int currSum = 0;
            for (int j = i; j >= 0; j--) {
                currSum += nums[j];
                ans = Math.max(Math.abs(currSum), ans);
            }
        }
        return ans;
    }
}
