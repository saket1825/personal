package org.example.Daily;

public class LC1524 {
    public int numOfSubarrays(int[] arr) {
        int prefixSum = 0, even = 1, odd = 0, ans = 0;
        for (int num : arr) {
            prefixSum += num;
            if (prefixSum % 2 == 0) {
                ans += odd;
                even++;
            } else {
                ans += even;
                odd++;
            }
        }
        return ans;
    }
}
