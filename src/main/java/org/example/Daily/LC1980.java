package org.example.Daily;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LC1980 {
    int n;
    Set<String> numsSet = new HashSet<String>();

    private String generate(String curr) {
        if (curr.length() == n) {
            if (!numsSet.contains(curr)) {
                return curr;
            }

            return "";
        }

        String addZero = generate(curr + "0");
        if (!addZero.isEmpty()) {
            return addZero;
        }

        return generate(curr + "1");
    }

    public String findDifferentBinaryString(String[] nums) {
        n = nums.length;
        numsSet.addAll(Arrays.asList(nums));

        return generate("");
    }
}
