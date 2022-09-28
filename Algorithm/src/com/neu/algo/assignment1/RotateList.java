package com.neu.algo.assignment1;

/*
Rotate List (https://leetcode.com/problems/rotate-list/)
 */
public class RotateList {
    public ListNode rotateList(ListNode head, int k){
        // checking for null
        if(head == null || head.next == null){
            return head;
        }

        int length = 0;
        ListNode node = head;
        ListNode curr = head;

        // to find the length of the list
        while (node != null){
            node = node.next;
            length += 1;
        }

        k = k % length;
        k = k > 0 ? length - k : 0;

        // that means no rotation needed return head
        if (k == 0){
            return head;
        }

        // To find new_head
        while (k-1 != 0){
            curr = curr.next;
            k -= 1;
        }

        ListNode new_head = curr.next;
        curr.next = null; // break the list
        ListNode new_tail = new_head;

        // To find new tail
        while (new_tail.next != null){
            new_tail = new_tail.next;
        }

        // rotated list pointing to head
        new_tail.next = head;

        // return rotated list head
        return new_head;
    }
}
