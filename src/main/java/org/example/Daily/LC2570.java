package org.example.Daily;

import java.util.HashSet;

public class LC2570 {

    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int resLen = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int[] num1 : nums1) {
            set.add(num1[0]);
        }
        resLen = n;
        for (int[] num2 : nums2) {
            if (!set.contains(num2[0])) {
                resLen++;
            }
        }
        int[][] ans = new int[resLen][2];
        int i = 0, j = 0, k = 0;
        while (i < n && j < m) {
            if (nums1[i][0] == nums2[j][0]) {
                ans[k][0] = nums1[i][0];
                ans[k][1] = nums1[i][1] + nums2[j][1];
                i++;
                j++;
            } else if (nums1[i][0] > nums2[j][0]) {
                ans[k][0] = nums2[j][0];
                ans[k][1] = nums2[j][1];
                j++;
            } else {
                ans[k][0] = nums1[i][0];
                ans[k][1] = nums1[i][1];
                i++;
            }
            k++;
        }

        while (i < n) {
            ans[k][0] = nums1[i][0];
            ans[k][1] = nums1[i][1];
            i++;
            k++;
        }

        while (j < m) {
            ans[k][0] = nums2[j][0];
            ans[k][1] = nums2[j][1];
            j++;
            k++;
        }
        return ans;

    }
}
