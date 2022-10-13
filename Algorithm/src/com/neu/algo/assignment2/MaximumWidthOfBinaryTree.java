package com.neu.algo.assignment2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Maximum Width of Binary Tree (https://leetcode.com/problems/maximum-width-of-binary-tree/)
 */
public class MaximumWidthOfBinaryTree {
    public int maximumWidthOfBinaryTree(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> queueIndex = new LinkedList<>();
        int max = 0;
        queue.add(root);
        //store index, assuming root's index is 1
        queueIndex.add(1);

        while(!queue.isEmpty()){
            int size = queue.size();
            int start = 0, end = 0;
            for(int i=0; i<size; i++) {
                TreeNode node = queue.remove();
                int index = queueIndex.remove();
                //start and end index for each level
                if(i==0) start = index;
                if(i==size-1) end = index;
                if(node.left!=null)
                {
                    queue.add(node.left);
                    queueIndex.add(2*index);
                }
                if(node.right!=null)
                {
                    queue.add(node.right);
                    queueIndex.add(2*index+1);
                }
            }
            max = Math.max(max, end - start + 1);
        }
        return max;
    }
}
