package leetcode_problems.leetcode_linked_list;

import leetcode_problems.leetcode_linked_list.LeetCode206.ListNode;

public class Leetcode19 {

    /*
    19. Remove Nth Node From End of List
    Given the head of a linked list, remove the nth node from the end of the list and return its head.
     */

    public static ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode start = new ListNode();
        start.next = head;
        ListNode fast = start;
        ListNode slow = start;

        for (int i = 0; i < n; i++) fast = fast.next;

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return start.next;
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode result = removeNthFromEnd(head, 2);
        while (result != null) {
            System.out.print(result.val + "-> ");
            result = result.next;
        }

        System.out.println();

        ListNode head1 = new ListNode(1);
        ListNode result1 = removeNthFromEnd(head1, 1);
        while (result1 != null) {
            System.out.print(result1.val + "-> ");
            result1 = result1.next;
        }
    }
}
