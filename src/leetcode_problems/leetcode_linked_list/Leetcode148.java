package leetcode_problems.leetcode_linked_list;

import leetcode_problems.leetcode_linked_list.LeetCode206.ListNode;

public class Leetcode148 {

    /*
    148. Sort List
    Given the head of a linked list, return the list after sorting it in ascending order.
     */

    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode prev = null, slow = head, fast = head;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null;

        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);

        return merge(l1, l2);
    }

    private static ListNode merge(ListNode l1, ListNode l2) {
        ListNode l = new ListNode(0), p = l;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }

        if (l1 != null) p.next = l1;
        if (l2 != null) p.next = l2;

        return l.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(4, new ListNode(1, new ListNode(3, new ListNode(2))));
        ListNode result = sortList(head);
        while (result != null) {
            System.out.print(result.val + " -> ");
            result = result.next;
        }
        System.out.println();
    }
}
