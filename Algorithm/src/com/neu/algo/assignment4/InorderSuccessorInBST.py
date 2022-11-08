from typing import Optional

from Algorithm.src.com.neu.algo.assignment4 import TreeNode

"""Inorder Successor in BST ****(https://leetcode.com/problems/inorder-successor-in-bst/"""


def inorderSuccessor(self, root: TreeNode, p: TreeNode) -> Optional[TreeNode]:
    res = None
    stack = []
    if root is None:
        return None
    node = root
    prev = None
    while node or stack:
        while node is not None:
            stack.append(node)
            node = node.left
        node = stack.pop()
        if prev and prev == p:
            res = node
            break
        prev = node
        node = node.right
    return res
