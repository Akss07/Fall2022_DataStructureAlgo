package com.neu.algo.assignment2;

import java.util.ArrayList;
import java.util.List;

/**
 * Find Leaves of Binary Tree (https://leetcode.com/problems/find-leaves-of-binary-tree/)
 */
public class FindLeavesOfBinaryTree {
    public List<List<Integer>> findLeaves(TreeNode root) {

        List<List<Integer>> leavesList = new ArrayList<>();
        List<Integer> leaves = new ArrayList<Integer>();

        while(root != null) {
            if(isLeave(root, leaves)) root = null;
            leavesList.add(leaves);
            leaves = new ArrayList<Integer>();
        }
        return leavesList;
    }

    public boolean isLeave(TreeNode node, List<Integer> leaves) {

        // if node's left and right child is null, that means it's a leaf
        if (node.left == null && node.right == null) {
            leaves.add(node.val);
            return true;
        }

        // if node's left child is not null, check for its node.left's child
        if (node.left != null) {
            if(isLeave(node.left, leaves))  node.left = null;
        }

        // if node's right child is not null, check for its node.right's child
        if (node.right != null) {
            if(isLeave(node.right, leaves)) node.right = null;
        }

        return false;
    }
}


