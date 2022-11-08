from typing import Optional
import TreeNode

"""Recover Binary Search Tree (https://leetcode.com/problems/recover-binary-search-tree/"""


def recoverTree(root: Optional[TreeNode]) -> None:
    cur, node, swapNodes = root, TreeNode(-float("inf")), []
    while cur:
        if cur.left:
            pre = cur.left
            while pre.right and pre.right != cur:
                pre = pre.right
            if not pre.right:
                pre.right = cur
                cur = cur.left
            else:
                pre.right = None
                if cur.val < node.val:
                    swapNodes += [node, cur]
                node = cur
                cur = cur.right
        else:
            if cur.val < node.val:
                swapNodes += [node, cur]
            node = cur
            cur = cur.right

    swapNodes[0].val, swapNodes[-1].val = swapNodes[-1].val, swapNodes[0].val
