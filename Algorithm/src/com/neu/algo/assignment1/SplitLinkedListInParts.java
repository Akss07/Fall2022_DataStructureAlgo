package com.neu.algo.assignment1;

/*
Split Linked List in Parts (https://leetcode.com/problems/split-linked-list-in-parts/)
 */
public class SplitLinkedListInParts {

    public ListNode[] splitListInParts(ListNode head, int k) {
        // create a new List
        ListNode[] listNode = new ListNode[k];
        ListNode curr_node = head;

        int size = 0;

        // to find size of list
        while (curr_node != null) {
            curr_node = curr_node.next;
            size++;
        }


        int div = size / k;
        int partition = size % k;

        curr_node = head;

        for (int i = 0; i < k; ++i) {
            ListNode root = curr_node;
            // for each part , this will calculate how many nodes that list will have
            for (int j = 0; j < div + (i < partition ? 1 : 0) - 1; ++j) {
                if (curr_node != null) {
                    curr_node = curr_node.next;
                }
            }
                // split the list
                if (curr_node != null) {
                    ListNode temp = curr_node;
                    curr_node = curr_node.next;
                    temp.next = null;
                }
                // add node to ith index of listNode
                listNode[i] = root;
            }
            return listNode;
        }

    }

