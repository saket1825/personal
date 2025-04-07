package org.example.Daily;

public class LC2161 {
    public int[] pivotArray(int[] nums, int pivot) {
        int[] ans = new int[nums.length];
        int l = 0, e = 0, g = 0;
        for (int num : nums) {
            if (num < pivot) {
                l++;
            } else if (num == pivot) {
                e++;
            } else {
                g++;
            }
        }
        g = l + e;
        e = l;
        l = 0;
        for (int num : nums) {
            if (num > pivot) {
                ans[g] = num;
                g++;
            } else if (num == pivot) {
                ans[e] = num;
                e++;
            } else {
                ans[l] = num;
                l++;
            }
        }
        return ans;
    }
}
