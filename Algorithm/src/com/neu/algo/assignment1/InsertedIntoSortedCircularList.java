package com.neu.algo.assignment1;

/*
 Insert into a Sorted Circular Linked List(https://leetcode.com/problems/insert-into-a-sorted-circular-linked-list/)
 */
public class InsertedIntoSortedCircularList {

    public static ListNode insertIntoList(ListNode head, int insertValue){
        //if head is null create new node with insertValue
        if(head == null){
            ListNode node = new ListNode(insertValue, null);
            node.next = node;
            return node;
        }

        // to track previous and current node
        ListNode prev_node = head;
        ListNode curr_node = head.next;

        while(true){
            //  check if prev is grater then head
            if (prev_node.val > curr_node.val){
                if (prev_node.val <= insertValue || insertValue <= curr_node.val){
                    break;
                }
            }else{
                //check if the value of new node sits between the minimal and maximal values of the current list.
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

        // if it does not fall into any of the above two conditions.
        prev_node.next = new ListNode(insertValue, curr_node);
        return head;
    }
}
