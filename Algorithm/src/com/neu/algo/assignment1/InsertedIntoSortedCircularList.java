package com.neu.algo.assignment1;

/*
 Insert into a Sorted Circular Linked List(https://leetcode.com/problems/insert-into-a-sorted-circular-linked-list/)
 */
public class InsertedIntoSortedCircularList {

    public static ListNode insertIntoList(ListNode head, int insertValue){
        if(head == null){
            ListNode node = new ListNode(insertValue, null);
            node.next = node;
            return node;
        }

        ListNode prev_node = head;
        ListNode curr_node = head.next;

        while(true){
            if (prev_node.val > curr_node.val){
                if (prev_node.val <= insertValue || insertValue <= curr_node.val){
                    break;
                }
            }else{
                if (prev_node.val <= insertValue && insertValue <= curr_node.val){
                    break;
                }
            }

            prev_node = prev_node.next;
            curr_node = curr_node.next;

            if (prev_node == head){
                break;
            }
        }

        prev_node.next = new ListNode(insertValue, curr_node);
        return head;
    }
}
