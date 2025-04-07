package org.example.DP;

public class LC5 {
    public String longestPalindrome(String s) {
        String max = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                if (isPalindrome(s, j, i)) {
                    if (i - j + 1 > max.length()) {
                        max = s.substring(j, i + 1);
                    }
                }
            }
        }
        return max;
    }

    private boolean isPalindrome(String s, int start, int end) {
        while (start <= end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
