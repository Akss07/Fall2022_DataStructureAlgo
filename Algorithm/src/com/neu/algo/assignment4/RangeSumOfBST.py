from collections import deque
from typing import Optional

from Algorithm.src.com.neu.algo.assignment4 import TreeNode

"""Range Sum of BST (https://leetcode.com/problems/range-sum-of-bst/"""


def rangeSumBST(self, root: Optional[TreeNode], low: int, high: int) -> int:
    queue = deque()
    sumOfNode = 0
    if root is None:
        return sumOfNode
    node = root
    while node or queue:
        while node is not None:
            queue.append(node)
            node = node.left
        node = queue.pop()
        if node.val >= low and node.val <= high:
            sumOfNode += node.val
        node = node.right
    return sumOfNode
