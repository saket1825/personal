package org.example.Tree;

import java.util.HashMap;

public class LC105 {
    int preOrderStart = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < preorder.length; i++) {
            map.put(preorder[i], i);
        }
        return dfsBanao(preorder, 0, preorder.length - 1, map);
    }

    private TreeNode dfsBanao(int[] preorder, int l, int r, HashMap<Integer, Integer> map) {
        if (l > r) {
            return null;
        }
        int value = preorder[preOrderStart++];
        TreeNode root = new TreeNode(value);
        int mid = map.get(value);
        root.left = dfsBanao(preorder, l, mid - 1, map);
        root.right = dfsBanao(preorder, mid + 1, r, map);
        return root;
    }
}
