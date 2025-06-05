package org.example.Daily;

import java.util.Arrays;
import java.util.Collections;

public class LC3068 {
    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        Integer[] diff = new Integer[nums.length];
        long ans = 0;
        for (int i = 0; i < nums.length; i++) {
            diff[i] = (nums[i] ^ k) - nums[i];
            ans += nums[i];
        }

        Arrays.sort(diff, Collections.reverseOrder());

        for(int i = 0; i< nums.length ;i+= 2){
            if(i+1 ==nums.length)
                break;

            int inc = diff[i]+ diff[i+1];

            if(inc>0){
                ans+= inc;
            }
        }
        return ans;
    }
}
