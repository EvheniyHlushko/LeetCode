import java.util.ArrayList;
import java.util.List;


/*
https://leetcode.com/problems/reorder-list/
Given a singly linked list L: L0→L1→…→Ln-1→Ln,
        reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

        You may not modify the values in the list's nodes, only nodes itself may be changed.

        Example 1:

        Given 1->2->3->4, reorder it to 1->4->2->3.
        Example 2:

        Given 1->2->3->4->5, reorder it to 1->5->2->4->3.*/

public class Solution {
  /*  public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }

        List<ListNode> list = new ArrayList<ListNode>();
        list.add(head);
        ListNode node1 = head;
        while (node1.next != null) {
            list.add(node1.next);
            node1 = node1.next;
        }

        int n = list.size() - 1;

        int element = 1;

        ListNode nodeNext = head;

        for (int i = 1; i < list.size() + 1; i++){
            if(i % 2 == 0){
                nodeNext.next = list.get(element);
                element ++;
            }
            else{
                nodeNext.next = list.get(n);
                n--;
            }

            nodeNext = nodeNext.next;


        }

        if(nodeNext.next != null && nodeNext.next.next != null){
            nodeNext.next.next = null;
        }
    }*/

    public void reorderList(ListNode head) {
        if (head == null) return;

        // 1: get the number of nodes
        int count = 0;
        ListNode node = head;
        while (node != null) {
            node = node.next;
            count++;
        }

        node = head;
        ListNode res = null;
        // 2: get the latter half of the head
        for (int i = 0; i < (count + 1) / 2; i++) {
            res = node;
            node = node.next;
        }
        res.next = null;

        // 3: reverse the latter half
        ListNode prev = null;
        ListNode after = null;
        while (node != null) {
            after = node.next;
            node.next = prev;
            prev = node;
            node = after;
        }
        node = prev;

        ListNode left = head;
        // 4: switch the order:
        while (node != null) {
            ListNode temp = node.next;
            node.next = left.next;
            left.next = node;
            left = node.next;
            node = temp;
        }
    }
}
