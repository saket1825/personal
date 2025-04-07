package org.example.Tree;

public class LC1123 {

    static class Pair<K, V> {
        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        K key;

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public Pair(K key, V value) {
            this.value = value;
            this.key = key;
        }

        V value;
    }

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        Pair<TreeNode, Integer> ansTree = lcaDeepestLeavesHelper(root);
        return ansTree.getKey();
    }

    private Pair<TreeNode, Integer> lcaDeepestLeavesHelper(TreeNode root) {
        if (root == null) {
            return new Pair<>(null, 0);
        }
        Pair<TreeNode, Integer> leftTree = lcaDeepestLeavesHelper(root.left);
        Pair<TreeNode, Integer> rightTree = lcaDeepestLeavesHelper(root.right);

        if (leftTree.getValue() > rightTree.getValue()) {
            return new Pair<>(leftTree.getKey(), leftTree.getValue() + 1);
        } else if (leftTree.getValue() < rightTree.getValue()) {
            return new Pair<>(rightTree.getKey(), rightTree.getValue() + 1);
        } else {
            return new Pair<>(root, leftTree.getValue() + 1);
        }
    }
}
