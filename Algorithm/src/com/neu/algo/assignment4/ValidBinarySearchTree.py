from collections import deque
from math import inf
from typing import Optional
from Algorithm.src.com.neu.algo.assignment4 import TreeNode

"""Validate Binary Search Tree (https://leetcode.com/problems/validate-binary-search-tree"""


def isValidBST(self, root: Optional[TreeNode]) -> bool:
    lower = float(-inf)
    higher = float(inf)
    node = root
    queue = deque()
    queue.append((lower, higher, node))

    if not node:
        return True

    while queue:
        lower, higher, node = queue.popleft()

        if node.val <= lower or node.val >= higher:
            return False

        if node.left:
            queue.append((lower, node.val, node.left))
        if node.right:
            queue.append((node.val, higher, node.right))
    return True
