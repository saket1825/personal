package org.example.Daily;

public class LC1079 {
    public int numTilePossibilities(String tiles) {
        int[] frequency = new int[26];
        for (char ch : tiles.toCharArray()) frequency[ch - 'A']++;
        return dfs(frequency);
    }

    private int dfs(int[] frequency) {
        int sum = 0;
        for (int i = 0; i < 26; i++) {
            if (frequency[i] == 0) continue;
            sum++;
            frequency[i]--;
            sum += dfs(frequency);
            frequency[i]++;
        }
        return sum;
    }
}
