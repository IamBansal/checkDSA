package leetcode_linked_list;

import leetcode_linked_list.LeetCode206.ListNode;

public class LeetCode92 {

    /*
    92. Reverse Linked List II
    Given the head of a singly linked list and two integers left and right where left <= right,
    reverse the nodes of the list from position left to position right, and return the reversed list.
     */

    public static ListNode reverseList(ListNode head) {

        ListNode newHead = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {

        if (left == right) return head;

        ListNode start = new ListNode();
        start.next = head;
        ListNode leftNode = start;
        ListNode startNode = start;
        ListNode rightNode = start;

        for (int i = 1; i <= left; i++) {
            if (i != left) startNode = startNode.next;
            leftNode = leftNode.next;
        }

        for (int i = 0; i < right; i++) rightNode = rightNode.next;

        ListNode last = rightNode.next;

        rightNode.next = null;
        startNode.next = reverseList(leftNode);
        leftNode.next = last;

        return start.next;
    }

    public static void main(String[] args) {
        LeetCode206.ListNode head = new LeetCode206.ListNode(1, new LeetCode206.ListNode(2, new LeetCode206.ListNode(3, new LeetCode206.ListNode(4, new LeetCode206.ListNode(5, null)))));
        LeetCode206.ListNode result = reverseBetween(head, 2, 4);
        while (result != null) {
            System.out.print(result.val + "-> ");
            result = result.next;
        }

        System.out.println();

        LeetCode206.ListNode head1 = new LeetCode206.ListNode(1);
        LeetCode206.ListNode result1 = reverseBetween(head1, 1, 1);
        while (result1 != null) {
            System.out.print(result1.val + "-> ");
            result1 = result1.next;
        }
    }
}
