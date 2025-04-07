package org.example.Tree;

public class LC1448 {

    public int goodNodes(TreeNode root) {
        return dfs(root, Integer.MIN_VALUE);
    }

    private int dfs(TreeNode root, int maxValueTillNow) {
        if (root == null) {
            return 0;
        }
        if (root.val >= maxValueTillNow) {
            return 1 + dfs(root.left, root.val) + dfs(root.right, root.val);
        } else {
            return dfs(root.left, maxValueTillNow) + dfs(root.right, maxValueTillNow);
        }
    }
}
