from collections import deque
from typing import Optional

from Algorithm.src.com.neu.algo.assignment4 import TreeNode

"""Serialize and Deserialize BST (https://leetcode.com/problems/serialize-and-deserialize-bst"""


def serialize(self, root: Optional[TreeNode]) -> str:
    res = []
    if root is None:
        return ""
    stack = deque()
    stack.append(root)
    while stack:
        node = stack.pop()
        res.append(str(node.val))
        if node.right:
            stack.append(node.right)
        if node.left:
            stack.append(node.left)
    return ",".join(res)


def deserialize(self, data: str) -> Optional[TreeNode]:
    if data == "":
        return None
    split = data.split(",")
    index = 0

    def helper(low, high):
        nonlocal index
        if index == len(split):
            return None
        val = int(split[index])
        if val < low or val > high:
            return None
        node = TreeNode(val)
        index += 1
        node.left = helper(low, val)
        node.right = helper(val, high)
        return node

    return helper(float("-inf"), float("inf"))