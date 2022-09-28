package com.neu.algo.assignment1;

/*
Swapping Nodes in a Linked List(https://leetcode.com/problems/swapping-nodes-in-a-linked-list/)
 */
public class SwapNodes {

    public ListNode swapNodes(ListNode head, int k){
        if(head == null || head.next == null){
            return head;
        }
        int length = 0;
        ListNode node = head;

        while (node != null){
            node = node.next;
            length += 1;
        }

        int end = length - k;

        ListNode start_node = head;
        ListNode end_node = head;

        while(k - 1 != 0){
            start_node = start_node.next;
            k -= 1;
        }

        while(end != 0){
            end_node = end_node.next;
            end -= 1;
        }

        int temp = start_node.val;
        start_node.val = end_node.val;
        end_node.val = temp;

        return head;
    }
}
