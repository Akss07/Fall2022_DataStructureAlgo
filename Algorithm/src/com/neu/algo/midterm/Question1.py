from collections import *

"""1. In a Binary Tree populate next left of a tree. """


class TreeNode:
    def __init__(self, val=0, left=None, right=None, nextLeft=None):
        self.val = val
        self.left = left
        self.right = right
        self.nextLeft = nextLeft


def populateNextleft(root: TreeNode):
    if root is None:
        return root
    q = deque()
    q.append(root)
    while q:
        size = len(q)
        while size > 0:
            node = q.popleft()
            size -= 1
            if size > 0:
                node.nextLeft = q[0]
            if node.right:
                q.append(node.right)
            if node.left:
                q.append(node.left)

def printTree(node):
    res = deque()
    while node is not None:
        res.append(node)
        node = node.right
    while res:
        n = res.popleft()
        print('')
        while n is not None:
            print(n.val, end='')
            n = n.nextLeft


if __name__ == '__main__':
    root = TreeNode(1)
    root.left = TreeNode(2)
    root.right = TreeNode(3)
    root.left.left = TreeNode(4)
    root.left.right = TreeNode(5)
    root.right.left = TreeNode(6)
    root.right.right = TreeNode(7)
    populateNextleft(root)
    printTree(root)
