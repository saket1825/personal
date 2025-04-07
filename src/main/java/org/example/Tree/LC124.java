package org.example.Tree;

public class LC124 {
    int ans = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return ans;
    }

    private int dfs(TreeNode root) {
        if(root == null){
            return 0;
        }
        int leftLen = Math.max(dfs(root.left),0);
        int rightLen = Math.max(dfs(root.right),0);
        ans = Math.max(ans, root.val + rightLen + leftLen);
        return root.val + Math.max(leftLen, rightLen);
    }
}
