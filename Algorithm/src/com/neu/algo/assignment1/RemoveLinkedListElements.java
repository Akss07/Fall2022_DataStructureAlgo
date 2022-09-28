package com.neu.algo.assignment1;

/*
Remove Linked List Elements (https://leetcode.com/problems/remove-linked-list-elements/)
 */
public class RemoveLinkedListElements {

    public ListNode removeLinkedListElement(ListNode head, int value){
        // return null if head is null
        if(head == null){
            return null;
        }
        // create a sentinel node
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev_node = dummy; // to track previous node
        ListNode curr_node = head; // to track current node

        // traverse until current node is not null
        while (curr_node != null){
            // compare current node to value to delete
            if (curr_node.val == value){
                // if true delete the current node
                prev_node.next = curr_node.next;
            }else{
                // if false, set current node to prev
                prev_node = curr_node;
            }
            // move to the next node
            curr_node = curr_node.next;
        }
        // return sentinel Node
        return dummy.next;
    }
}
