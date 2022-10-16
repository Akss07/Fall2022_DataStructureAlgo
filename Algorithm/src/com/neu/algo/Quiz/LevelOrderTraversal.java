package com.neu.algo.Quiz;

import java.util.ArrayList;
import java.util.List;

public class LevelOrderTraversal {
    List<List<Integer>> levels = new ArrayList<>();

    public void levelOrderTraversal(TreeNode node, int level) {

        if (levels.size() == level)
            levels.add(new ArrayList<Integer>());


        levels.get(level).add(node.val);

        if (node.left != null)
            levelOrderTraversal(node.left, level + 1);
        if (node.right != null)
            levelOrderTraversal(node.right, level + 1);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return levels;
        levelOrderTraversal(root, 0);
        return levels;
    }
}
