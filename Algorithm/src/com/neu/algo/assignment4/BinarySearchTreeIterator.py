"""Binary Search Tree Iterator
(https://leetcode.com/problems/binary-search-tree-iterator/Links) """


def __init__(self, root):
    self.stack = []
    self.pushLeft(root)


def pushLeft(self, root):
    while root is not None:
        self.stack.append(root)
        root = root.left


def next(self):
    node = self.stack.pop()
    self.pushLeft(node.right)
    return node.val


def hasNext(self):
    return len(self.stack) > 0
