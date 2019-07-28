/*
https://leetcode.com/problems/reverse-linked-list/
 */


public class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null){
            return head;
        }
        ListNode prev = head;
        ListNode current = head.next;
        prev.next = null;

        while (current != null){
                ListNode next = current.next;

                current.next = prev;
                prev = current;
                current = next;

            }

            return prev;
    }
}
