package org.example.Tree;

public class LC235 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        TreeNode biggerNode = q.val > p.val ? q : p;
        TreeNode smallerNode = q.val < p.val ? q : p;
        if (root.val == biggerNode.val || root.val == smallerNode.val) {
            return root;
        }
        if (root.val > smallerNode.val && root.val < biggerNode.val) {
            return root;
        } else if (root.val > biggerNode.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else {
            return lowestCommonAncestor(root.right, p, q);
        }
    }
}
