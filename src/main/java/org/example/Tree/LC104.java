package org.example.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class LC104 {
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int ans = 1;
        while(!queue.isEmpty()){
            int q = queue.size();
            for(int i = 0; i< q;i++){
                TreeNode popped = queue.poll();
                if(popped.left!=null){
                    queue.offer(popped.left);
                }
                if(popped.right!=null){
                    queue.offer(popped.right);
                }
            }
            ans++;
        }
        return ans;
    }
}
