package com.neu.algo.assignment1;

/*
Rotate List (https://leetcode.com/problems/rotate-list/)
 */
public class RotateList {
    public ListNode rotateList(ListNode head, int k){
        if(head == null || head.next == null){
            return head;
        }

        int length = 0;
        ListNode node = head;
        ListNode curr = head;

        while (node != null){
            node = node.next;
            length += 1;
        }

        k = k % length;
        k = k > 0 ? length - k : 0;

        if (k == 0){
            return head;
        }

        while (k-1 != 0){
            curr = curr.next;
            k -= 1;
        }

        ListNode new_head = curr.next;
        curr.next = null;
        ListNode new_tail = new_head;

        while (new_tail.next != null){
            new_tail = new_tail.next;
        }

        new_tail.next = head;

        return new_head;
    }
}
