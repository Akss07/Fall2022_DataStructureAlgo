import ListNode
import TreeNode

"""Convert Sorted List to Binary Search Tree 
(https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/Links) """


def sortedListToBST(self, head: ListNode) -> TreeNode:
    if head is None:
        return None

    middle_node = self.findMiddleElement(head)

    node = TreeNode(middle_node.val)

    if head == middle_node:
        return node

    node.left = self.sortedListToBST(head)
    node.right = self.sortedListToBST(middle_node.next)
    return node


def findMiddleElement(self, head: ListNode):
    slow = head
    fast = head
    prev = None

    while fast and fast.next:
        prev = slow
        slow = slow.next
        fast = fast.next.next

    if prev:
        prev.next = None

    return slow
