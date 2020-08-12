package com.practice.list;

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {

        if(head == null || head.next == null) {
            return head;
        }

        ListNode p = head;
        ListNode q = p.next;
        ListNode t = q.next;
        ListNode newHead = reverseListUsingRecursion(p, q, t);
        head.next = null;
        return newHead;
    }

    private ListNode reverseListUsingRecursion(ListNode p, ListNode q, ListNode t) {
        q.next = p;
        if(t == null) {
            p = q;
            return p;
        }
        if(t.next == null) {
            t.next = q;
            p = t;
            return p;
        }
        p = q;
        q = t;
        t = t.next;
        return reverseListUsingRecursion(p, q, t);
    }
}
