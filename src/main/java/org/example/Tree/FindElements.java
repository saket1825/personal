package org.example.Tree;

import java.util.HashSet;

public class FindElements {
    HashSet<Integer> hash = new HashSet<>();

    public FindElements(TreeNode root) {
        if (root != null) {
            int curr = 0;
            root.val = curr;
            hash.add(curr);
            dfs(root.left, (2 * curr) + 1);
            dfs(root.right, (2 * curr) + 2);
        }
    }

    private void dfs(TreeNode root, int curr) {
        if (root == null) {
            return;
        }
        root.val = curr;
        hash.add(curr);
        dfs(root.left, (2 * curr) + 1);
        dfs(root.right, (2 * curr) + 2);
    }

    public boolean find(int target) {
        return hash.contains(target);
    }
}
