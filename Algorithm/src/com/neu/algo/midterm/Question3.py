class TreeNode:

    def __init__(self, data):
        self.val = data
        self.left = None
        self.right = None


def printValuesInsideOfRange(root, k1, k2):
    if root is None:
        return

    if k1 <= root.val <= k2:
        print(root.val, end=' ')
    if root.val>=k1:
        printValuesInsideOfRange(root.left, k1, k2)
    if root.val<=k2:
        printValuesInsideOfRange(root.right, k1, k2)


if __name__ == '__main__':
    k1 = 8
    k2 = 22
    root = TreeNode(20)
    root.left = TreeNode(8)
    root.right = TreeNode(22)
    root.left.left = TreeNode(4)
    root.left.right = TreeNode(12)
    printValuesInsideOfRange(root, k1, k2)