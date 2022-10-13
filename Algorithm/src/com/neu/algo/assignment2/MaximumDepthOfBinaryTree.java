package com.neu.algo.assignment2;

import java.util.LinkedList;

/**
 * Maximum Depth of Binary Tree (https://leetcode.com/problems/maximum-depth-of-binary-tree/)
 */
public class MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<Integer> depth = new LinkedList<>();
        if (root == null){
            return 0;
        }

        int max_depth = 0;

        stack.add(root);
        //store index, assuming root's index is 1
        depth.add(1);

        while(!stack.isEmpty()){
            TreeNode curr_node = stack.pollLast();
            int curr_depth = depth.pollLast();

            // track the depth of left side of tree, if left node is not null add the node in stack
            // increase the count by 1
            if (curr_node.left != null){
                stack.add(curr_node.left);
                depth.add(curr_depth + 1);
            }
            // track the depth of right side of tree, if right node is not null add the node in stack
            // increase the count by 1
            if (curr_node.right != null){
                stack.add(curr_node.right);
                depth.add(curr_depth + 1);
            }

            max_depth = Math.max(curr_depth, max_depth);
        }
        return max_depth;
    }

}
