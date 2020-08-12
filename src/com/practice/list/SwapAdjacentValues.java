package com.practice.list;

public class SwapAdjacentValues {
    public static void main(String[] args) {
        ListNode head1 = testCase1();
        while (head1 != null) {
            System.out.print(head1.data + " , ");
            head1 = head1.next;
        }

        ListNode head2 = testCase2();
        while (head2 != null) {
            System.out.print(head2.data + " , ");
            head2 = head2.next;
        }

        ListNode head3 = testCase3();
        while (head3 != null) {
            System.out.print(head3.data + " , ");
            head3 = head3.next;
        }

        ListNode head4 = testCase4();
        while (head4 != null) {
            System.out.print(head4.data + " , ");
            head4 = head4.next;
        }

        ListNode head5 = testCase5();
        while (head5 != null) {
            System.out.print(head5.data + " , ");
            head5 = head5.next;
        }

        ListNode head6 = testCase6();
        while (head6 != null) {
            System.out.print(head6.data + " , ");
            head6 = head6.next;
        }
    }

    private static ListNode testCase1() {
        Solution solution = new Solution();
        ListNode r = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, null))));
        return solution.swapPairs(r);
    }

    private static ListNode testCase2() {
        Solution solution = new Solution();
        ListNode r = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))));
        return solution.swapPairs(r);
    }

    private static ListNode testCase3() {
        Solution solution = new Solution();
        ListNode r = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, null))));
        return solution.swapAdjacentPairsUsingLoop(r);
    }

    private static ListNode testCase4() {
        Solution solution = new Solution();
        ListNode r = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))));
        return solution.swapAdjacentPairsUsingLoop(r);
    }

    private static ListNode testCase5() {
        Solution solution = new Solution();
        ListNode r = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, null))));
        return solution.swapAdjacentPairsUsingRecursion(r);
    }

    private static ListNode testCase6() {
        Solution solution = new Solution();
        ListNode r = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))));
        return solution.swapAdjacentPairsUsingRecursion(r);
    }
}

class Solution {

    public ListNode swapPairs(ListNode head) {
        ListNode tmp = head;
        swapAdjacentPairsUsingData(tmp);
        return head;
    }

    public void swapAdjacentPairsUsingData(ListNode root) {
        // break validation
        if (root == null)
            return;
        if (root.next == null)
            return;

        // swap
        int tmp = root.data;
        root.data = root.next.data;
        root.next.data = tmp;

        // recursion
        swapAdjacentPairsUsingData(root.next.next);
    }


    public ListNode swapAdjacentPairsUsingLoop(ListNode r) {
        ListNode newRoot = r.next;
        ListNode p = r;
        ListNode q;
        ListNode t;
        while (true) {
            q = p.next;
            t = q.next;
            q.next = p;
            if (t == null || t.next == null) {
                p.next = t;
                break;
            }
            p.next = t.next;
            p = t;
        }
        return newRoot;
    }

    public ListNode swapAdjacentPairsUsingRecursion(ListNode r) {
        ListNode newRoot = r.next;
        swapAdjacentPairsUsingRecursion1(r);
        return newRoot;
    }

    private void swapAdjacentPairsUsingRecursion1(ListNode r) {
        ListNode p = r;
        ListNode q = p.next;
        ListNode t = q.next;
        q.next = p;
        if (t == null || t.next == null) {
            p.next = t;
            return;
        }
        p.next = t.next;
        p = t;
        swapAdjacentPairsUsingRecursion(p);
    }
}

