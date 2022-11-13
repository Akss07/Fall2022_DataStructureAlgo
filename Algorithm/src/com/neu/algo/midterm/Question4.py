"""Sorted insert in a Link list."""


class Node:
    def __init__(self, x: int, next: 'Node' = None):
        self.val = x
        self.next = next


def insert(head: 'Optional[Node]', insertVal: int) -> 'Node':
    node = Node(insertVal, None)
    if head is None:
        return node
    # if only one node in list
    if head.next is None:
        if insertVal >= head.val:
            head.next = node
            return head
        else:
            node.next = head
            return node
    # if at start of list
    if insertVal < head.val:
        node.next = head
        return node
    prev, curr = head, head.next
    # between and end
    while True:
        if curr is None:
            prev.next = node
            break
        if prev.val <= insertVal <= curr.val:
            prev.next = node
            node.next = curr
            break
        prev, curr = curr, curr.next
    return head


if __name__ == '__main__':
    head = Node(0, None)
    prev = head
    for i in range(1, 10, 5):
        newNode = Node(i, None)
        prev.next = newNode
        prev = newNode
    h = insert(head, 8)
    curr = h
    while curr:
        print(curr.val)
        curr = curr.next
