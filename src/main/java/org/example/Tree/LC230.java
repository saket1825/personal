package org.example.Tree;

public class LC230 {
    int ans = 0;

    public int kthSmallest(TreeNode root, int k) {
        dfs(root, k, 0);
        return ans;
    }

    public int dfs(TreeNode root, int k, int curr) {
        if (root == null) {
            return 0;
        }
        System.out.println(root.val);
        int leftElements = dfs(root.left, k, curr);
        curr += leftElements + 1;
        if (k == curr) {
            ans = root.val;
        }
        int rightElements = dfs(root.right, k, curr);
        return 1 + rightElements + leftElements;
    }
}
