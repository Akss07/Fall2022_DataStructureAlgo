package com.neu.algo.Quiz;

public class isSameTree {
    public boolean isSameTree(TreeNode node1, TreeNode node2) {

        if (node1 == null && node2 == null) return true;

        if (node2 == null || node1 == null) return false;
        if (node1.val != node2.val) return false;
        return isSameTree(node2.right, node2.right) &&
                isSameTree(node2.left, node2.left);
    }
}
