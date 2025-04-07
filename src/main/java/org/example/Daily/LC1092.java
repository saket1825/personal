package org.example.Daily;

public class LC1092 {
    String[][] dp;

    public String shortestCommonSupersequenceNaive(String str1, String str2) { // memory limit exceeded
        int i = 0, j = 0;
        dp = new String[str1.length() + 1][str2.length() + 1];
        return recur(str1, str2, i, j);
    }

    private String recur(String str1, String str2, int i, int j) {
        if (dp[i][j] != null) {
            return dp[i][j];
        }
        if (i == str1.length()) {
            if (j == str2.length()) {
                dp[i][j] = "";
                return "";
            }
            dp[i][j] = str2.charAt(j) + recur(str1, str2, i, j + 1);
            return dp[i][j];
        }
        if (j == str2.length()) {
            dp[i][j] = str1.charAt(i) + recur(str1, str2, i + 1, j);
            return dp[i][j];
        }

        if (str1.charAt(i) == str2.charAt(j)) {
            dp[i][j] = str1.charAt(i) + recur(str1, str2, i + 1, j + 1);
            return dp[i][j];

        } else {
            String ans1 = str1.charAt(i) + recur(str1, str2, i + 1, j);
            String ans2 = str2.charAt(j) + recur(str1, str2, i, j + 1);
            dp[i][j] = ans1;
            if (ans1.length() > ans2.length()) {
                dp[i][j] = ans2;
                return ans2;
            }
            return dp[i][j];
        }
    }

    public String shortestCommonSupersequence(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int[][] dp = new int[n + 1][m + 1];

        for (int row = 0; row <= n; row++) {
            dp[row][0] = row;
        }

        for (int col = 0; col <= m; col++) {
            dp[0][col] = col;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + 1;
                }
            }
        }

        StringBuilder ans = new StringBuilder();
        int row = n, col = m;

        while (row > 0 && col > 0) {
            if (str1.charAt(row - 1) == str2.charAt(col - 1)) {
                ans.append(str1.charAt(row - 1));
                row--;
                col--;
            } else if (dp[row - 1][col] < dp[row][col - 1]) {
                ans.append(str1.charAt(row - 1));
                row--;
            } else {
                ans.append(str2.charAt(col - 1));
                col--;
            }
        }

        while (row > 0) {
            ans.append(str1.charAt(row - 1));
            row--;
        }
        while (col > 0) {
            ans.append(str2.charAt(col - 1));
            col--;
        }

        return ans.reverse().toString();
    }
}
