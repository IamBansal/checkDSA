package leetcode_linked_list;

import leetcode_linked_list.LeetCode206.ListNode;

public class Leetcode2095 {

    /*
    2095. Delete the Middle Node of a Linked List
    You are given the head of a linked list.
    Delete the middle node, and return the head of the modified linked list.
    The middle node of a linked list of size n is the ⌊n / 2⌋th node from the start using 0-based indexing,
    where ⌊x⌋ denotes the largest integer less than or equal to x.

    For n = 1, 2, 3, 4, and 5, the middle nodes are 0, 1, 1, 2, and 2, respectively.
     */

    public static ListNode deleteMiddle(ListNode head) {

        ListNode slow = head;
        ListNode prev = new ListNode(-1, slow);
        ListNode fast = head;
        while ((fast != null && fast.next != null)) {
            prev = prev.next;
            slow = slow.next;
            fast = fast.next.next;
        }

        if (slow == null || slow.next == null) {
            if (fast == slow) return null;
            prev.next = null;
            return prev;
        }
        slow.val = slow.next.val;
        slow.next = slow.next.next;

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(3, new ListNode(4, new ListNode(7, new ListNode(1, new ListNode(2, new ListNode(6)))))));
        ListNode head1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));

        ListNode result = deleteMiddle(head);
        while (result != null) {
            System.out.print(result.val + "-> ");
            result = result.next;
        }

        System.out.println();

        ListNode result1 = deleteMiddle(head1);
//        ListNode result1 = deleteMiddle(new ListNode(1));
        while (result1 != null) {
            System.out.print(result1.val + "-> ");
            result1 = result1.next;
        }

    }
}
