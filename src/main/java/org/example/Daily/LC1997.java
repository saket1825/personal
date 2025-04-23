package org.example.Daily;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;

public class LC1997 {
    public int firstDayBeenInAllRooms(int[] nextVisit) {
        long[] dp = new long[nextVisit.length];
        int mod = 1000000007, n = nextVisit.length;
        dp[0] = 0;
        for(int i = 1;i<n;i++){
            dp[i] = (dp[i-1]+dp[i-1]-dp[nextVisit[i-1]]+2+mod)%mod;
        }
        return (int)dp[n-1];
    }

    public int maxScore(int[] nums) {
        Integer[] boxed = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Arrays.sort(boxed, Comparator.reverseOrder());
        int count = 0;
        int curr = 0;
        for (int num : boxed) {
            curr += num;
            if (curr < 0) {
                return count;
            }
            count++;
        }
        return 0;
    }
}
