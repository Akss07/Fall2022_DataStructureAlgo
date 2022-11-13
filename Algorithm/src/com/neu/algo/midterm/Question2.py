"""2. Populate parent of each node. in the binary tree"""

from collections import *


class TreeNode:
    def __init__(self, val=0, left=None, right=None, parent=None):
        self.val = val
        self.left = left
        self.right = right
        self.parent = parent


def parentOfEachNode(node, parent):
    if node is None:
        return
    node.parent = parent
    parentOfEachNode(node.left, node)
    parentOfEachNode(node.right, node)


def printTree(node):
    res = deque()
    res.append(node)
    while res:
        node = res.pop()
        if node.parent is not None:
            print("Node:", node.val, "My parent:", node.parent.val)
        else:
            print("Node:", node.val, "My parent:", node.parent)
        if node.left:
            res.append(node.left)
        if node.right:
            res.append(node.right)


if __name__ == '__main__':
    root = TreeNode(1)
    root.left = TreeNode(2)
    root.right = TreeNode(3)
    root.left.left = TreeNode(4)
    root.left.right = TreeNode(5)
    root.right.left = TreeNode(6)
    root.right.right = TreeNode(7)
    parentOfEachNode(root, None)
    printTree(root)
