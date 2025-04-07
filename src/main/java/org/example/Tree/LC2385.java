package org.example.Tree;

public class LC2385 {

    public int amountOfTime(TreeNode root, int start) {
        int[] ans = new int[1];
        dfs(root, start, ans);
        return ans[0];
    }

    private int dfs(TreeNode root, int start, int[] arr) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left, start, arr);
        int right = dfs(root.right, start, arr);

        if (start == root.val) {
            arr[0] = Math.max(left, right);
            return -1;
        } else if (left >= 0 && right >= 0) {
            return Math.max(left, right) + 1;
        } else {
            int curr = Math.abs(left) + Math.abs(right);
            arr[0] = Math.max(curr, arr[0]);
            return Math.max(left, right) - 1;
        }
    }
}
