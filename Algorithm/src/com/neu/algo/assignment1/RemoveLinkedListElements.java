package com.neu.algo.assignment1;

/*
Remove Linked List Elements (https://leetcode.com/problems/remove-linked-list-elements/)
 */
public class RemoveLinkedListElements {

    public ListNode removeLinkedListElement(ListNode head, int value){
        if(head == null){
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev_node = dummy;
        ListNode curr_node = head;

        while (curr_node != null){
            if (curr_node.val == value){
                prev_node.next = curr_node.next;
            }else{
                prev_node = curr_node;
            }
            curr_node = curr_node.next;
        }
        return dummy.next;
    }
}
