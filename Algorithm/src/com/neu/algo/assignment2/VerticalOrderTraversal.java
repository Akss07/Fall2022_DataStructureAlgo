package com.neu.algo.assignment2;

import java.util.*;

/**
 * Binary Tree Vertical Order Traversal (https://leetcode.com/problems/binary-tree-vertical-order-traversal/)
 */
public class VerticalOrderTraversal {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        int minColumnValue = 0;

        if (root == null) {
            return result;
        }

        //map's key is column, we assume the root column is zero, the left node will minus 1 ,and the right node will plus 1
        Map<Integer, ArrayList<Integer>> hashMap = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();

        //use a HashMap to store the TreeNode and the according column value
        Map<TreeNode, Integer> weight = new HashMap<>();
        queue.offer(root);
        weight.put(root, 0);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            int w = weight.get(node);
            if (!hashMap.containsKey(w)) {
                hashMap.put(w, new ArrayList<>());
            }
            hashMap.get(w).add(node.val);
            if (node.left != null) {
                queue.add(node.left);
                weight.put(node.left, w - 1);
            }
            if (node.right != null) {
                queue.add(node.right);
                weight.put(node.right, w + 1);
            }
            //update minColumnValue ,the minimum column value, which is the left most node
            minColumnValue = Math.min(minColumnValue, w);
        }
        while (hashMap.containsKey(minColumnValue)) {
            result.add(hashMap.get(minColumnValue++));
        }
        return result;
    }
}
