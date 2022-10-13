package com.neu.algo.assignment2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Symmetric Tree https://leetcode.com/problems/symmetric-tree/
 */
public class IsSymmetric {

    public boolean isSymmetric(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null){
            return false;
        }

        //Add root twice, one to track left nodes and other to track right nodes
        queue.add(root);
        queue.add(root);

        while (!queue.isEmpty()){
            TreeNode root1 = queue.poll();
            TreeNode root2 = queue.poll();

            // if both roots are null, that means it is symmetric
            if (root1 == null && root2 == null){
                continue;
            }
            //if only one of the node is null, that means tree is not symmetric return false
            if (root1 == null || root2 == null){
                return false;
            }
            if (root1 != null && root2 != null){
                if(root1.val != root2.val){
                    return false;
                }
            }
            queue.add(root1.left);
            queue.add(root2.right);
            queue.add(root1.right);
            queue.add(root2.left);
        }
        return true;
    }
}
