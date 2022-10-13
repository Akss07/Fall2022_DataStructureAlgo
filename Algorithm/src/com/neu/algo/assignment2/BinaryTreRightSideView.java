package com.neu.algo.assignment2;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * Binary Tree Right Side View (https://leetcode.com/problems/binary-tree-right-side-view/)
 */
public class BinaryTreRightSideView {
    public List<Integer> rightSideView(TreeNode root){
        ArrayDeque<TreeNode> queue = new ArrayDeque(){{ offer(root); }};
        List<Integer> rightSide = new ArrayList();

        if (root == null){
            return new ArrayList<>();
        }

        while (!queue.isEmpty()) {
            int levelLength = queue.size();

            for(int i = 0; i < levelLength; ++i) {
                TreeNode node = queue.poll();
                // if it's the rightmost element
                if (i == levelLength - 1) {
                    rightSide.add(node.val);
                }
                // add child nodes in the queue
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return rightSide;
    }

}
