import TreeNode

"""Convert Binary Search Tree to Sorted Doubly Linked List 
(https://leetcode.com/problems/convert-binary-search-tree-to-sorted-doubly-linked-list/Links)"""


def treeToDoublyList(self, root: TreeNode) -> TreeNode:
    prev = TreeNode()
    dummy = prev
    node = root
    stack = []

    if not node:
        return None

    while node is not None or stack:
        while node:
            stack.append(node)
            node = node.left

        node = stack.pop()
        prev.right = node
        node.left = prev
        prev = node
        node = node.right

    first = dummy.right
    dummy.right.left = prev
    prev.right = dummy.right
    return dummy.right
