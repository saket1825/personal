package org.example.Backtrack;

import java.util.*;

public class BackTrack {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> currList = new ArrayList<>();
        backTrack(nums, 0, currList, ans);
        return ans;
    }

    private void backTrack(int[] nums, int i, List<Integer> currList, List<List<Integer>> ans) {
        if (i == nums.length) {
            ans.add(new ArrayList<>(currList));
            return;
        }
        currList.add(nums[i]);
        backTrack(nums, i + 1, currList, ans);
        currList.remove(currList.size() - 1);
        backTrack(nums, i + 1, currList, ans);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> currList = new ArrayList<>();
        backTrackCombinationSum(candidates, 0, currList, ans, target);
        return ans;
    }

    private void backTrackCombinationSum(int[] nums, int i, List<Integer> currList, List<List<Integer>> ans, int target) {
        if (target == 0) {
            ans.add(new ArrayList<>(currList));
            return;
        }
        if (i == nums.length || target < 0) {
            return;
        }
        currList.add(nums[i]);
        backTrackCombinationSum(nums, i, currList, ans, target - nums[i]);
        currList.remove(currList.size() - 1);
        backTrackCombinationSum(nums, i + 1, currList, ans, target);
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> currList = new ArrayList<>();
        Arrays.sort(candidates);
        backTrackCombinationSum2(candidates, 0, currList, ans, target);
        return ans;
    }

    private void backTrackCombinationSum2(int[] nums, int idx, List<Integer> currList, List<List<Integer>> ans, int target) {
        if (target == 0) {
            ans.add(new ArrayList<>(currList));
            return;
        }
        for (int i = idx; i < nums.length; i++) {
            if (i > idx && nums[i] == nums[i - 1]) {
                continue;
            }
            if (target - nums[i] < 0) {
                break;
            }
            currList.add(nums[i]);
            backTrackCombinationSum2(nums, i + 1, currList, ans, target - nums[i]);
            currList.remove(currList.size() - 1);
            backTrackCombinationSum2(nums, i + 1, currList, ans, target - nums[i]);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(nums, ans, 0);
        return ans;
    }

    private void dfs(int[] nums, List<List<Integer>> ans, int idx) {
        if (nums.length == idx) {
            List<Integer> curr = new ArrayList<>();
            for (int num : nums) {
                curr.add(num);
            }
            ans.add(curr);
        } else {
            for (int i = idx; i < nums.length; i++) {
                swap(nums, idx, i);
                dfs(nums, ans, idx + 1);
                swap(nums, idx, i);
            }
        }
    }

    private void swap(int[] nums, int idx, int i) {
        int temp = nums[idx];
        nums[idx] = nums[i];
        nums[i] = temp;
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> currList = new ArrayList<>();
        Arrays.sort(nums);
        subSetWithDuplicatesBackTrack(nums, 0, currList, ans);
        return ans;
    }

    private void subSetWithDuplicatesBackTrack(int[] nums, int idx, List<Integer> currList, List<List<Integer>> ans) {

        ans.add(new ArrayList<>(currList));
        for (int i = idx; i < nums.length; i++) {
            if (i > idx && nums[i] == nums[i - 1]) {
                continue;
            }
            currList.add(nums[i]);
            subSetWithDuplicatesBackTrack(nums, i + 1, currList, ans);
            currList.remove(currList.size() - 1);
        }
    }


    public boolean exist(char[][] board, String word) {
        int ROW = board.length;
        int COLUMN = board[0].length;
        for (int r = 0; r < ROW; r++) {
            for (int c = 0; c < COLUMN; c++) {
                if (dfsWordSearch(board, word, r, c, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfsWordSearch(char[][] board, String word, int r, int c, int stringIndex) {
        if (stringIndex == word.length()) {
            return true;
        }
        int ROW = board.length;
        int COLUMN = board[0].length;
        if (r < 0 || r >= ROW || c < 0 || c >= COLUMN || board[r][c] == '#' || board[r][c] != word.charAt(stringIndex)) {
            return false;
        }
        board[r][c] = '#';
        boolean res = dfsWordSearch(board, word, r + 1, c, stringIndex + 1)
                || dfsWordSearch(board, word, r - 1, c, stringIndex + 1)
                || dfsWordSearch(board, word, r, c + 1, stringIndex + 1)
                || dfsWordSearch(board, word, r, c - 1, stringIndex + 1);
        board[r][c] = word.charAt(stringIndex);
        return res;
    }

    public String clearDigits(String s) {
        Stack<Character> st = new Stack<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (Character.isDigit(s.charAt(i))) {
                st.pop();
            } else {
                st.push(s.charAt(i));
            }
        }
        StringBuilder ans = new StringBuilder();
        while (!st.isEmpty()) {
            ans.insert(0, st.pop());
        }
        return ans.toString();
    }

    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> currList = new ArrayList<>();
        partitionRecur(s, currList, ans, 0);
        return ans;
    }

    private void partitionRecur(String s, List<String> currList, List<List<String>> ans, int idx) {
        if (idx == s.length()) {
            ans.add(new ArrayList<>(currList));
            return;
        }
        for (int i = idx; i < s.length(); i++) {
            if (isPalindrome(s, idx, i)) {
                currList.add(s.substring(idx, i + 1));
                partitionRecur(s, currList, ans, i + 1);
                currList.remove(currList.size() - 1);
            }
        }
    }

    public boolean isPalindrome(String str, int l, int r) {
        if (str.isEmpty()) {
            return false;
        }
        while (l <= r) {
            if (str.charAt(l) != str.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    static {

    }

    public List<String> letterCombinations(String digits) {
        Map<Character, String> map = Map.of(
                '2', "abc", '3', "def", '4', "ghi", '5', "jkl",
                '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz"
        );
        return letterCombinations(digits, map, 0);
    }

    private List<String> letterCombinations(String digits, Map<Character, String> map, int i) {
        if (digits.length() == i) {
            return List.of("");
        }
//        System.out.println(digits + " str " + i);
        String characters = map.get(digits.charAt(i));
        List<String> ans = new ArrayList<>();
        List<String> nextAnswer = letterCombinations(digits, map, i + 1);
        for (String str : nextAnswer) {

            for (int j = 0; j < characters.length(); j++) {
                char ch = characters.charAt(j);
                ans.add(ch + str);
            }
        }
        return ans;
    }

    boolean[] col, posDiag, negDiag;
    List<List<String>> res;
    char[][] board;

    public List<List<String>> solveNQueens(int n) {
        col = new boolean[n];
        posDiag = new boolean[2 * n];
        negDiag = new boolean[2 * n];
        res = new ArrayList<>();
        board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        backtrack(0, n);
        return res;
    }

    private void backtrack(int r, int n) {
        if (r == n) {
            List<String> copy = new ArrayList<>();
            for (char[] row : board) {
                copy.add(new String(row));
            }
            res.add(copy);
            return;
        }
        for (int c = 0; c < n; c++) {
            if (col[c] || posDiag[r + c] || negDiag[r - c + n]) {
                continue;
            }
            col[c] = true;
            posDiag[r + c] = true;
            negDiag[r - c + n] = true;
            board[r][c] = 'Q';

            backtrack(r + 1, n);

            col[c] = false;
            posDiag[r + c] = false;
            negDiag[r - c + n] = false;
            board[r][c] = '.';
        }
    }
}
