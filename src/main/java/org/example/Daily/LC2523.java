package org.example.Daily;

public class LC2523 {
    public int[] closestPrimes(int left, int right) {
        boolean[] sieve = new boolean[right + 1];
        for (int i = 2; i * i <= right; i++) {
            if (!sieve[i]) {
                for (int j = i; j <= right; j += i) {
                    sieve[j] = true;
                }
            }
        }
        int prev = Integer.MIN_VALUE;
        int ans = Integer.MAX_VALUE;
        int[] ansArr = new int[2];
        for (int i = left; i <= right; i++) {
            if (!sieve[i]) {
                if (prev == Integer.MIN_VALUE) {
                    prev = i;
                } else {
                    int curr = i - prev;
                    prev = i;
                    if (curr < ans) {
                        ans = curr;
                        ansArr[0] = prev;
                        ansArr[1] = i;
                    }
                }
            }
        }
        return ans == Integer.MAX_VALUE ? new int[]{-1, -1} : ansArr;
    }
}
